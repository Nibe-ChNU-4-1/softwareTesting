package edu.yevynchuk.projtest;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.ArchTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintStream;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@SpringBootTest
class ProjArchitectureTests {

    private JavaClasses applicationClasses;

    @BeforeEach
    void initialize() {
        applicationClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("edu.yevynchuk.projtest");
    }

    @Test
    void shouldFollowLayerArchitecture()  {
        layeredArchitecture()
                .consideringAllDependencies()
                .layer("Controller").definedBy("..controller..")
                .layer("Service").definedBy("..service..")
                .layer("Repository").definedBy("..repository..")
                //
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Service")
                .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
                //
                .check(applicationClasses);
    }



    // Controllers tests
    @Test
    void controllerClassesShouldBeNamedXController() {
        classes()
                .that().resideInAPackage("..controller..")
                .should()
                .haveSimpleNameEndingWith("Controller")
                .check(applicationClasses);
    }

    @Test
    void controllerClassesShouldBeAnnotatedWithRestController() {
        classes()
                .that().resideInAPackage("..controller..")
                .should()
                .beAnnotatedWith(RestController.class)
                .check(applicationClasses);
    }

    @Test
    void controllersShouldNotDependOnOtherControllers() {
        noClasses()
                .that().resideInAPackage("..controller..")
                .should()
                .dependOnClassesThat()
                .resideInAPackage("..controller..")
                .check(applicationClasses);
    }

    @Test
    void controllerFieldsShouldNotBeAutowired() {
        noFields()
                .that().areDeclaredInClassesThat().resideInAPackage("..controller..")
                .should().beAnnotatedWith(Autowired.class)
                .check(applicationClasses);
    }

    @Test
    void controllerMethodsShouldBePublic() {
        methods()
                .that().areDeclaredInClassesThat().resideInAPackage("..controller..")
                .should().bePublic()
                .check(applicationClasses);
    }

    // Service layer tests
    @Test
    void serviceClassesShouldBeAnnotatedWithService() {
        classes()
                .that().resideInAPackage("..service..")
                .should()
                .beAnnotatedWith(Service.class)
                .check(applicationClasses);
    }

    @Test
    void servicesShouldNotDependOnControllers() {
        noClasses()
                .that().resideInAPackage("..service..")
                .should()
                .dependOnClassesThat().resideInAPackage("..controller..")
                .check(applicationClasses);
    }

    @Test
    void serviceClassesShouldHaveSimpleNameEndingWithService() {
        classes()
                .that().resideInAPackage("..service..")
                .should().haveSimpleNameEndingWith("Service")
                .check(applicationClasses);
    }

    // Repository tests
    @Test
    void repositoryClassesShouldBeInterfaces() {
        classes()
                .that().resideInAPackage("..repository..")
                .should()
                .beInterfaces()
                .check(applicationClasses);
    }

    @Test
    void repositoriesShouldOnlyBeAccessedByServices() {
        classes()
                .that().resideInAPackage("..repository..")
                .should()
                .onlyAccessClassesThat().resideInAPackage("..service..")
                .check(applicationClasses);
    }

    @Test
    void repositoryClassesShouldHaveSimpleNameEndingWithRepository() {
        classes()
                .that().resideInAPackage("..repository..")
                .should().haveSimpleNameEndingWith("Repository")
                .check(applicationClasses);
    }

    // Model tests
    @Test
    void modelClassesShouldHavePrivateFields() {
        fields()
                .that().areDeclaredInClassesThat().resideInAPackage("..model..")
                .should().bePrivate()
                .check(applicationClasses);
    }

    @Test
    void modelClassesShouldBeAnnotatedWithDocumentAnnotation() {
        classes()
                .that().resideInAPackage("..model..")
                .should().beAnnotatedWith(org.springframework.data.mongodb.core.mapping.Document.class)
                .check(applicationClasses);
    }

    @Test
    void modelClassesShouldHaveGettersAndSetters() {
        classes()
                .that().resideInAPackage("..model..")
                .should().haveSimpleNameEndingWith("Book")
                .andShould().beAnnotatedWith(org.springframework.data.mongodb.core.mapping.Document.class)
                .check(applicationClasses);
    }

    @Test
    void modelClassesShouldNotDependOnControllerOrService() {
        noClasses()
                .that().resideInAPackage("..model..")
                .should()
                .dependOnClassesThat().resideInAPackage("..controller..")
                .orShould().resideInAPackage("..service..")
                .check(applicationClasses);
    }

    // General tests for the project
    @Test
    void classesShouldNotUseSystemOutPrintln() {
        noClasses()
                .should().accessClassesThat().haveNameMatching("System.out")
                .check(applicationClasses);
    }

    @Test
    void noFieldShouldBeAnnotatedWithDeprecated() {
        noFields()
                .should().beAnnotatedWith(Deprecated.class)
                .check(applicationClasses);
    }

    @Test
    void servicesShouldNotHavePublicFields() {
        fields()
                .that().areDeclaredInClassesThat().resideInAPackage("..service..")
                .should().bePrivate()
                .check(applicationClasses);
    }

    @Test
    void noClassesShouldAccessStandardStreams() {
        noClasses()
                .should().accessClassesThat().belongToAnyOf(System.class, PrintStream.class)
                .check(applicationClasses);
    }

}

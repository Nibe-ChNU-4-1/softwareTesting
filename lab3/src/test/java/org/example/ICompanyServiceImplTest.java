package org.example;

import org.junit.jupiter.api.*;

import java.util.List;

/*
    @author Nibe
    @project lab3
    @class ICompanyServiceImplTest
    @version 
    @SE 19.09.2024 - 15:24
*/

class ICompanyServiceImplTest {
    private final Company main = new Company(null, 5);
    private final Company bookkeeping = new Company(main, 4);
    private final Company HR = new Company(main, 3);
    private final Company development = new Company(main, 7);
    private final Company frontend = new Company(development, 6);
    private final Company design = new Company(development, 5);
    private final Company UXUI = new Company(design, 4);
    private final Company backend = new Company(development, 4);
    private final Company DB = new Company(backend, 4);
    private final Company businessLogic = new Company(backend, 3);

    List<Company> companies = List.of(main, bookkeeping, HR, development, frontend, design, UXUI, backend, DB, businessLogic);


    private final ICompanyService underTest = new ICompanyServiceImpl();




    @Test
    void whenCompanyIsMainThenTopLevelParentIsMain() {
        Company result = underTest.getTopLevelParent(main);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyIsBookkeepingThenTopLevelParentIsMain() {
        Company result = underTest.getTopLevelParent(bookkeeping);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyIsHRThenTopLevelParentIsMain() {
        Company result = underTest.getTopLevelParent(HR);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyIsDevelopmentThenTopLevelParentIsMain() {
        Company result = underTest.getTopLevelParent(development);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyIsFrontendThenTopLevelParentIsMain() {
        Company result = underTest.getTopLevelParent(frontend);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyIsDesignThenTopLevelParentIsMain() {
        Company result = underTest.getTopLevelParent(design);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyIsUXUIThenTopLevelParentIsMain() {
        Company result = underTest.getTopLevelParent(UXUI);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyIsBackendThenTopLevelParentIsMain() {
        Company result = underTest.getTopLevelParent(backend);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyIsDBThenTopLevelParentIsMain() {
        Company result = underTest.getTopLevelParent(DB);
        Assertions.assertEquals(main, result);
    }

    @Test
    void whenCompanyIsBusinessLogicThenTopLevelParentIsMain() {
        Company result = underTest.getTopLevelParent(businessLogic);
        Assertions.assertEquals(main, result);
    }







    @Test
    void whenCompanyIsMainThenEmployeeCountIncludesAllCompanies() {
        long result = underTest.getEmployeeCountForCompanyAndChildren(main, companies);
        Assertions.assertEquals(5 + 4 + 3 + 7 + 6 + 5 + 4 + 4 + 4 + 3, result);
    }

    @Test
    void whenCompanyIsBookkeepingThenEmployeeCountIncludesOnlyItself() {
        long result = underTest.getEmployeeCountForCompanyAndChildren(bookkeeping, companies);
        Assertions.assertEquals(4, result);
    }

    @Test
    void whenCompanyIsHRThenEmployeeCountIncludesOnlyItself() {
        long result = underTest.getEmployeeCountForCompanyAndChildren(HR, companies);
        Assertions.assertEquals(3, result);
    }

    @Test
    void whenCompanyIsDevelopmentThenEmployeeCountIncludesDevelopmentAndItsChildren() {
        long result = underTest.getEmployeeCountForCompanyAndChildren(development, companies);
        Assertions.assertEquals(7 + 6 + 5 + 4 + 4 + 4 + 3, result);
    }

    @Test
    void whenCompanyIsFrontendThenEmployeeCountIncludesOnlyItself() {
        long result = underTest.getEmployeeCountForCompanyAndChildren(frontend, companies);
        Assertions.assertEquals(6, result);
    }

    @Test
    void whenCompanyIsDesignThenEmployeeCountIncludesDesignAndItsChildren() {
        long result = underTest.getEmployeeCountForCompanyAndChildren(design, companies);
        Assertions.assertEquals(5 + 4, result);
    }

    @Test
    void whenCompanyIsUXUIThenEmployeeCountIncludesOnlyItself() {
        long result = underTest.getEmployeeCountForCompanyAndChildren(UXUI, companies);
        Assertions.assertEquals(4, result);
    }

    @Test
    void whenCompanyIsBackendThenEmployeeCountIncludesBackendAndItsChildren() {
        long result = underTest.getEmployeeCountForCompanyAndChildren(backend, companies);
        Assertions.assertEquals(4 + 4 + 3, result);
    }

    @Test
    void whenCompanyIsDBThenEmployeeCountIncludesOnlyItself() {
        long result = underTest.getEmployeeCountForCompanyAndChildren(DB, companies);
        Assertions.assertEquals(4, result);
    }

    @Test
    void whenCompanyIsBusinessLogicThenEmployeeCountIncludesOnlyItself() {
        long result = underTest.getEmployeeCountForCompanyAndChildren(businessLogic, companies);
        Assertions.assertEquals(3, result);
    }



}
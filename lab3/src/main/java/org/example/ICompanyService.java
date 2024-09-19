package org.example;
import java.util.List;

/*
    @author Nibe
    @project lab3
    @class ICompanyService
    @version 1
    @SE 19.09.2024 - 11:57
*/

public interface ICompanyService {
    Company getTopLevelParent(Company child);
    long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies);

}

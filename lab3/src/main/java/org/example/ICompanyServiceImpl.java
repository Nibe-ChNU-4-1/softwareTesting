package org.example;

/*
    @author Nibe
    @project lab3
    @class ICompanyServiceImpl
    @version 
    @SE 19.09.2024 - 12:20
*/

import java.util.List;

public class ICompanyServiceImpl implements ICompanyService {
    @Override
    public Company getTopLevelParent(Company child) {
        if (child == null){
            return null;
        }
        if (child.getParent() == null){
            return child;
        }
        return getTopLevelParent(child.getParent());
    }

    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        long totalEmployeeCount = company.getEmployeeCount();

        for (Company child : companies) {
            if (company.equals(child.getParent())) {
                totalEmployeeCount += getEmployeeCountForCompanyAndChildren(child, companies);
            }
        }

        return totalEmployeeCount;
    }
}

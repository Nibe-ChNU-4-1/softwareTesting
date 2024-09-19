package org.example;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
    @author Nibe
    @project lab3
    @class Company
    @version 1
    @SE 19.09.2024 - 11:47
*/

@Getter
@Setter
@AllArgsConstructor
public class Company {
    private Company parent;
    private long employeeCount;


}

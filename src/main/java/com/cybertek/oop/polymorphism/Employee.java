package com.cybertek.oop.polymorphism;

import com.cybertek.oop.encapsulation.User;
import com.cybertek.oop.inheritance.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee extends BaseEntity {

    private int employeeId;
    private String employeeTas;
    private User employeeManager;

    public void getEmployeeHours(){
        System.out.println("40 hours a week");
    }

    @Override
    public void overriddenOne(){

        System.out.println("Employee.overriddenOne()");

    }

}

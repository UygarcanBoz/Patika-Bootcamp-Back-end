/**
 * The Employee class represents factory employees and provides methods
 * to calculate their salary details, including tax, bonus, and salary increase.
 * The class has four attributes: name, salary, workHours, and hireYear.
 * It also includes a constructor to initialize these attributes and methods
 * for tax calculation, bonus calculation, salary increase calculation,
 * and displaying employee information.
 */

import java.util.Scanner;

public class Employee {
    private String name;        // Employee's name
    private double salary;      // Employee's salary
    private int workHours;      // Weekly work hours
    private int hireYear;       // Hire year

    // Constructor
    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    // Calculate tax
    public double tax() {
        if (salary > 1000) {
            return salary * 0.03;
        }
        return 0;
    }

    // Calculate bonus
    public double bonus() {
        if (workHours > 40) {
            int extraHours = workHours - 40;
            return extraHours * 30;
        }
        return 0;
    }

    // Calculate salary increase
    public double raiseSalary() {
        int currentYear = 2021;
        int yearsWorked = currentYear - hireYear;

        if (yearsWorked < 10) {
            return salary * 0.05;
        } else if (yearsWorked >= 10 && yearsWorked < 20) {
            return salary * 0.10;
        } else {
            return salary * 0.15;
        }
    }

    // Display information in a formatted way
    public String toString() {
        double totalSalary = salary - tax() + bonus() + raiseSalary();
        return "Name: " + name +
                "\nSalary: " + salary +
                "\nWorking Hours: " + workHours +
                "\nStart Year: " + hireYear +
                "\nTax: " + tax() +
                "\nBonus: " + bonus() +
                "\nSalary Increase: " + raiseSalary() +
                "\nSalary with Tax and Bonus: " + (totalSalary - salary + tax()) +
                "\nTotal Salary: " + totalSalary;
    }
}

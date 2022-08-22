package AbstractClasses.practice_2.src;

import AbstractClasses.practice_2.src.Company;
import AbstractClasses.practice_2.src.Employee;

public class Manager extends Company implements Employee {
    private final double bonusSalary = 0.05;
    private int salary = 100000;

    public Manager() {
        salary = getMonthSalary();
        totalIncome += income;
    }


    public double getIncome() {
        income = (int) (Math.random() * 25000 + 115000);
        return income;
    }

    @Override
    public int getMonthSalary() {
        salary = (int) (salary + getIncome() * bonusSalary);
        return salary;
    }
}

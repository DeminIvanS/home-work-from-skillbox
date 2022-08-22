package AbstractClasses.practice_2.src;

import AbstractClasses.practice_2.src.Company;
import AbstractClasses.practice_2.src.Employee;

public class Operator extends Company implements Employee {
    private int salary = (int) ((Math.random() * 5) * 1000 + 50000);

    @Override
    public int getMonthSalary() {
        salary = salary * 1;
        return salary;
    }

}
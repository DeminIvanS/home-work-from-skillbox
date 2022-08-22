package AbstractClasses.practice_2.src;

import AbstractClasses.practice_2.src.Company;
import AbstractClasses.practice_2.src.Employee;

public class TopManager extends Company implements Employee {
    private static final double bonusSalary = 1.5;
    private static int fixSalary = 110000;
    private int salary;

    public TopManager() {
        salary = getMonthSalary();
        income = getTotalIncome();
    }


    @Override
    public int getMonthSalary() {
        if (totalIncome > 10_000_000) {
            salary = (int) (fixSalary + fixSalary * bonusSalary);

        } else {
            salary = fixSalary;
        }
        return salary;
    }

}
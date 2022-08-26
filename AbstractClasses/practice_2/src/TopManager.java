package AbstractClasses.practice_2.src;


import static AbstractClasses.practice_2.src.Main.company;

public class TopManager implements Employee {
    private static final double bonusSalary = 1.5;
    private static int fixSalary = 110000;
    private int salary;

    public TopManager() {
        salary = getMonthSalary();
    }

    @Override
    public int getMonthSalary() {
        if (company.totalIncome > 1_000_000) {
            salary = (int) (fixSalary + fixSalary * bonusSalary);

        } else {
            salary = fixSalary;
        }
        return salary;
    }
}
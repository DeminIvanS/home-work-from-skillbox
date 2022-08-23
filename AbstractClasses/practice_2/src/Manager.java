package AbstractClasses.practice_2.src;

public class Manager implements Employee {
    private final double bonusSalary = 0.05;
    protected int fixSalary = 100000;

    public Manager() {
    }

    public double getIncome() {
        int income = (int) (Math.random() * 25000 + 115000);
        return income;
    }

    @Override
    public int getMonthSalary() {
        int salary = (int) (fixSalary + (getIncome() * bonusSalary));
        return salary;
    }
}

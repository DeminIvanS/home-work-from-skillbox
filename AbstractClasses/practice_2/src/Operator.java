package AbstractClasses.practice_2.src;

public class Operator implements Employee {
    private int salary = (int) ((Math.random() * 5) * 1000 + 50000);

    @Override
    public int getMonthSalary() {
        salary = salary * 1;
        return salary;
    }
}
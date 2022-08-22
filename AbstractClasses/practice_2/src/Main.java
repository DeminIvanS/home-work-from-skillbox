package AbstractClasses.practice_2;

public class AbstractClasses {
    public static Company company = new Company();

    public static void main(String[] args) {
        for (int i = 0; i < 270; i++) {
            if (i < 180) {
                company.hireEmployee(new Operator());
            }
            if (i >= 180 & i < 260) {
                company.hireEmployee(new Manager());

            }
            if (i >= 260 & i <= 270) {
                company.hireEmployee(new TopManager());
            }
        }
        System.out.println("Количество нанятых сотрудников " + company.getCountEmployees());
        System.out.println("Список самых высоких зарплат в компании: ");
        for (Employee employee : company.getTopSalaryStaff(15)) {
            System.out.println(employee);
        }
        System.out.println("Список самых низких зарплат в компании: ");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(employee);
        }
        company.fireEmployee(company.getCountEmployees()/2);

        System.out.println("Количество нанятых сотрудников " + company.getCountEmployees());
        for (Employee employee : company.getTopSalaryStaff(10)) {
            System.out.println(employee);
        }
        System.out.println("Список самых высоких зарплат в компании: ");
        for (Employee employee : company.getLowestSalaryStaff(30)) {
            System.out.println(employee);
        }
    }
}

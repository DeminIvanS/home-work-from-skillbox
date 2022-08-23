package AbstractClasses.practice_2.src;

import java.util.*;

public class Company
        implements Employee {
    int totalIncome;

    private List<Employee> employeesList;

    public Company() {

        employeesList = new ArrayList<>();
    }

    public void hireEmployee(Employee employees) {
        this.employeesList.add(employees);
    }

    public void hireEmployeeAll(List<Employee> employees) {
        this.employeesList.addAll(employees);
    }

    public void fireEmployee(int count) {

        for (; count > 0; count--) {
            int index = (int) (Math.random() * (employeesList.size() - 1));
            employeesList.remove(index);
        }
    }

    public int getTotalIncome() {
        for (Employee employee : employeesList) {
            if (employee instanceof Manager) {
                totalIncome += ((Manager) employee).getIncome();
            }
        }
        return totalIncome;
    }

    public int getCountEmployees() {
        return employeesList.size();
    }

    public List<Employee> getTopSalaryStaff(int count) {
        return sortList(count, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return (o2.getMonthSalary() - o1.getMonthSalary());
            }
        });
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        return sortList(count, new Comparator<Employee>() {
            public int compare(Employee o1, Employee o2) {
                return (o1.getMonthSalary() - o2.getMonthSalary());
            }
        });
    }

    private List<Employee> sortList(int count, Comparator<Employee> comparator) {
        Collections.sort(employeesList, comparator);
        List<Employee> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(employeesList.get(i));
        }
        return result;
    }
}
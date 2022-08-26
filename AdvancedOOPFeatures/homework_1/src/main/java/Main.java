import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static final String STAFF_TXT = "C:/\\Users/\\Ivan/\\IdeaProjects/\\skillbox/\\java_basics/\\Adv/\\AdvancedOOPFeatures/\\homework_1/\\data/\\staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        Collections.sort(staff,(o1, o2)->{
            int compareSalary = o1.getSalary().compareTo(o2.getSalary());
            return compareSalary != 0
                   ? compareSalary
            :o1.getName().compareTo(o2.getName());

        });
        findEmployeeWithHighestSalary(staff);
    }
    public static void findEmployeeWithHighestSalary(List<Employee> staff){
        staff.stream().sorted((Comparator.comparing((Employee :: getSalary)))).forEach(System.out::println);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        Collections.sort(staff,(o1, o2)->{
            int compareSalary = o1.getSalary().compareTo(o2.getSalary());
            return compareSalary != 0
                    ? compareSalary
                    :o1.getName().compareTo(o2.getName());
        });
        //TODO Метод должен отсортировать сотрудников по заработной плате и алфавиту.
    }
}
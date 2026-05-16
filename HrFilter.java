import java.util.List;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class HrFilter {
    public static void main(String[] args) {
        List<Employee> allEmployees = List.of(
                new Employee("Rahul", "Engineering", 85000),
                new Employee("Anjali", "HR", 60000),
                new Employee("Kiran", "Engineering", 50000),
                new Employee("Sneha", "Engineering", 92000),
                new Employee("Arun", "Sales", 45000)
        );

        System.out.println("--- Processing HR Data ---");

        List<String> topEngineers = allEmployees.stream()
                .filter(e -> e.getDepartment().equals("Engineering"))
                .filter(e -> e.getSalary() > 75000)
                .map(Employee::getName)
                .collect(Collectors.toList());

        System.out.println("\nTop Engineering Earners (>₹75k):");
        topEngineers.forEach(System.out::println);
    }
}
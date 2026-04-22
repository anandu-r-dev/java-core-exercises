import java.util.List;

public class StreamPractice {

    public record Employee(String name, String role, double salary) {}

    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee("Rahul", "Odoo Developer", 45000),
                new Employee("Sneha", "Java Developer", 65000),
                new Employee("Kiran", "Odoo Developer", 72000),
                new Employee("Arjun", "Frontend Developer", 40000),
                new Employee("Maya", "Java Developer", 55000)
        );

        System.out.println("Employees earning over 50,000:");

        employees.stream()
                .filter(emp -> emp.salary() > 50000)
                .map(Employee::name)
                .forEach(System.out::println);
    }
}
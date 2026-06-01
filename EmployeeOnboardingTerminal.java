import java.util.Scanner;

public class EmployeeOnboardingTerminal {

    public static void main(String[] args) {
        Scanner terminalInput = new Scanner(System.in);

        System.out.println("==================================================");
        System.out.println("    ENTERPRISE CORE SYSTEM: EMPLOYEE ONBOARDING   ");
        System.out.println("==================================================");

        System.out.print("Enter Target Employee ID: ");
        int employeeId = terminalInput.nextInt();

        terminalInput.nextLine();

        System.out.print("Enter Employee Full Name: ");
        String fullName = terminalInput.nextLine();

        System.out.print("Enter Target Base Salary ($): ");
        double baseSalary = terminalInput.nextDouble();

        System.out.print("Enter Primary Language (Single Word): ");
        String primaryLanguage = terminalInput.next();

        System.out.println("\n==================================================");
        System.out.println("          ONBOARDING METRICS CAPTURED             ");
        System.out.println("==================================================");

        System.out.println("System Profile ID    : " + employeeId);
        System.out.println("Full Legal Name      : " + fullName);
        System.out.println("Assigned Base Salary : $" + baseSalary);
        System.out.println("Core Capability Track: " + primaryLanguage);

        System.out.println("==================================================");
        System.out.println("Processing local resource cleanup...");

        terminalInput.close();
        System.out.println("Terminal disconnected successfully. Exit Code 0.");
    }
}
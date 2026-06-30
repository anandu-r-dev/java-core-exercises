class Employees {
    protected int employeeId;
    protected String name;

    public Employees(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
        System.out.println("LOG: Employee Superclass initialization block completed.");
    }

    public void displayProfile() {
        System.out.print("Staff ID: " + this.employeeId + " | Name: " + this.name);
    }
}

class DevOpsEngineer extends Employees {
    private String onCallRotationShift;

    public DevOpsEngineer(int employeeId, String name, String onCallRotationShift) {
        super(employeeId, name);

        this.onCallRotationShift = onCallRotationShift;
        System.out.println("LOG: DevOpsEngineer Subclass initialization block completed.");
    }

    public void displayOperationalStatus() {
        super.displayProfile();

        System.out.println(" | On-Call Shift: " + this.onCallRotationShift);
    }
}

public class EnterpriseCloudOperations {

    public static void main(String[] args) {
        System.out.println("Accessing Workforce Management System...");
        System.out.println("-----------------------------------------------------------------");

        DevOpsEngineer engineer = new DevOpsEngineer(9021, "Vikram Sinha", "Night-Shift-Asia");

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Triggering Specialized Inherited Reporting Diagnostics:");

        engineer.displayOperationalStatus();
    }
}
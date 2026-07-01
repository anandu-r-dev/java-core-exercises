class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateBonus() {
        return 5000.00;
    }
}

class DevOpsEngineer extends Employee {

    public DevOpsEngineer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateBonus() {
        return this.baseSalary * 0.10;
    }
}

class SiteReliabilityEngineer extends Employee {

    public SiteReliabilityEngineer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateBonus() {
        return (this.baseSalary * 0.15) + 2000.00;
    }
}

public class CloudOperationsBilling {

    public static void main(String[] args) {
        System.out.println("Processing System Operations Payroll Database...");
        System.out.println("-------------------------------------------------------");

        Employee[] teamManifest = new Employee[3];

        teamManifest[0] = new Employee("Alice Vance", 50000.00);
        teamManifest[1] = new DevOpsEngineer("Vikram Sinha", 80000.00);
        teamManifest[2] = new SiteReliabilityEngineer("Rohan Murthy", 95000.00);

        for (Employee member : teamManifest) {

            double calculatedBonus = member.calculateBonus();

            System.out.println("Staff Name : " + member.name);
            System.out.println("Calculated Bonus: ₹" + String.format("%.2f", calculatedBonus));
            System.out.println("-------------------------------------------------------");
        }
    }
}
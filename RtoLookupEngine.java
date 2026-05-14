import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RtoLookupEngine {
    public static void main(String[] args) {
        Map<String, String> rtoData = new HashMap<>();

        rtoData.put("KL-01", "Thiruvananthapuram");
        rtoData.put("KL-07", "Ernakulam");
        rtoData.put("KL-14", "Kasargod");
        rtoData.put("KL-41", "Aluva");
        rtoData.put("KL-39", "Thripunithura");

        Scanner scanner = new Scanner(System.in);
        System.out.println("--- RTO Lookup Engine Booted ---");
        System.out.println("Type 'EXIT' at any time to close the system.\n");

        while (true) {
            System.out.print("Enter RTO Code (e.g., KL-41): ");

            String inputCode = scanner.nextLine().trim().toUpperCase();

            if (inputCode.equals("EXIT")) {
                System.out.println("Shutting down the lookup engine... Goodbye.");
                break;
            }

            if (rtoData.containsKey(inputCode)) {
                String location = rtoData.get(inputCode);
                System.out.println("✅ MATCH FOUND: " + inputCode + " belongs to " + location + "\n");
            } else {
                System.out.println("❌ ERROR: RTO Code '" + inputCode + "' not found in database.\n");
            }
        }

        scanner.close();
    }
}
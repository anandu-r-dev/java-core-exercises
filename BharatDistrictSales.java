public class BharatDistrictSales {

    public static void main(String[] args) {
        final int TOTAL_ZONES = 3;
        final int TOTAL_QUARTERS = 4;

        System.out.println("=== BHARAT REGIONAL SALES MATRIX GENERATOR ===");
        System.out.println("Processing local database structures...\n");

        for (int zoneId = 1; zoneId <= TOTAL_ZONES; zoneId++) {
            System.out.println("--> Initiating Node Grid Mapping for Zone [ " + zoneId + " ]");

            for (int quarterId = 1; quarterId <= TOTAL_QUARTERS; quarterId++) {

                System.out.print("  [Zone" + zoneId + "-Q" + quarterId + "] ");

            }

            System.out.println("\n------------------------------------------------");
        }

        System.out.println("Matrix rendering operation completed successfully.");
    }
}
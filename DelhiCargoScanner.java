public class DelhiCargoScanner {

    public static void main(String[] args) {
        final int TOTAL_ROWS = 3;
        final int SLOTS_PER_ROW = 5;

        System.out.println("Initiating Delhi Cargo Grid Scanner Architecture...");
        System.out.println("-----------------------------------------------------");

        rowSearchLoop:
        for (int row = 1; row <= TOTAL_ROWS; row++) {
            System.out.println("Scanning Cargo Row " + row + "...");

            for (int slot = 1; slot <= SLOTS_PER_ROW; slot++) {

                if (row == 1 && slot == 3) {
                    System.out.println("  [Alert] Slot " + slot + " is damaged. Skipping slot via continue.");
                    continue;
                }

                if (row == 2 && slot == 2) {
                    System.out.println("  [MATCH] Priority parcel located at Row " + row + ", Slot " + slot + "!");
                    System.out.println("Terminating all background scanning threads safely...");

                    break rowSearchLoop;
                }

                System.out.println("  Processing Row " + row + ", Slot " + slot + " (Clear)");
            }

            System.out.println("Completed processing details for Row " + row);
        }

        System.out.println("-----------------------------------------------------");
        System.out.println("Scanner System Idle. Ready for next container layout.");
    }
}
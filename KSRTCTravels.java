import java.util.Arrays;

public class KSRTCTravels {

    public static void main(String[] args) {
        int[] bookingIds = new int[3];
        bookingIds[0] = 101;
        bookingIds[1] = 103;
        int activeSize = 2;

        System.out.println("Initial State: " + Arrays.toString(bookingIds) + " | Size: " + activeSize);

        int insertIndex = 1;
        int newBookingId = 102;

        for (int i = activeSize; i > insertIndex; i--) {
            bookingIds[i] = bookingIds[i - 1];
        }
        bookingIds[insertIndex] = newBookingId;
        activeSize++;

        System.out.println("After Insertion: " + Arrays.toString(bookingIds) + " | Size: " + activeSize);

        if (activeSize == bookingIds.length) {
            System.out.println("\n[Alert] Capacity reached. Initiating manual array resize...");

            int[] expandedArray = new int[bookingIds.length * 2];

            for (int i = 0; i < bookingIds.length; i++) {
                expandedArray[i] = bookingIds[i];
            }

            bookingIds = expandedArray;
            System.out.println("Resize Complete. New Capacity: " + bookingIds.length + " slots.");
        }

        bookingIds[activeSize] = 104;
        activeSize++;
        System.out.println("After Appending 104: " + Arrays.toString(bookingIds) + " | Size: " + activeSize);

        int deleteIndex = 0;
        System.out.println("\nCancelling booking at index " + deleteIndex + "...");

        for (int i = deleteIndex; i < activeSize - 1; i++) {
            bookingIds[i] = bookingIds[i + 1];
        }

        bookingIds[activeSize - 1] = 0;
        activeSize--;

        System.out.println("Final State: " + Arrays.toString(bookingIds) + " | Size: " + activeSize);
    }
}
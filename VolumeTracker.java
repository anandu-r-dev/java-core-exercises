import java.util.Scanner;

public class VolumeTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] setVolumes = new double[5];

        double totalVolume = 0.0;

        System.out.println("--- Workout Volume Tracker (Barbell Squats) ---");
        System.out.println("Let's log your 5 working sets.\n");

        for (int i = 0; i < 5; i++) {
            System.out.printf("--- Set %d ---%n", i + 1);

            System.out.print("Enter weight lifted (in kg): ");
            double weight = scanner.nextDouble();

            System.out.print("Enter reps completed: ");
            int reps = scanner.nextInt();

            double currentSetVolume = weight * reps;

            setVolumes[i] = currentSetVolume;

            totalVolume += currentSetVolume;

            System.out.println();
        }

        System.out.println("===========================");
        System.out.println("      WORKOUT SUMMARY      ");
        System.out.println("===========================");

        for (int i = 0; i < setVolumes.length; i++) {
            System.out.printf("Set %d Volume: %.1f kg%n", i + 1, setVolumes[i]);
        }

        System.out.printf("%nGrand Total Volume: %.1f kg%n", totalVolume);

        scanner.close();
    }
}
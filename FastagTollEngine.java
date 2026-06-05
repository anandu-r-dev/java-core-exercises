public class FastagTollEngine {

    public static void main(String[] args) {
        String vehicleType = "SUV";

        int tollFee = switch (vehicleType) {
            case "CAR", "SUV" -> 100;
            case "BUS", "TRUCK" -> 350;
            case "AUTO" -> 50;

            default -> {
                System.out.println("Warning: Unregistered vehicle type detected!");
                yield 500;
            }
        };

        System.out.println("--- NHAI Toll Receipt ---");
        System.out.println("Vehicle Type : " + vehicleType);
        System.out.println("FASTag Debit : " + tollFee);
    }
}
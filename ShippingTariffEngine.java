public class ShippingTariffEngine {

    public static void main(String[] args) {
        char destinationZone = 'B';

        double surcharge = 0.0;
        String tierDescription;
        switch (destinationZone) {
            case 'A':
            case 'B':
                tierDescription = "Domestic Express";
                surcharge = 15.00;
                break;

            case 'C':
                tierDescription = "Domestic Standard";
                surcharge = 5.00;
                break;

            default:
                tierDescription = "International Remote";
                surcharge = 50.00;
                break;
        }

        System.out.println("Destination Zone: " + destinationZone);
        System.out.println("Shipping Tier   : " + tierDescription);
        System.out.println("Zone Surcharge  : " + surcharge);
    }
}
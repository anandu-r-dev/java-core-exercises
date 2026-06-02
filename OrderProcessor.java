public class OrderProcessor {

    public static void main(String[] args) {
        double orderValue = 75.0;
        String customerType = "PREMIUM";
        int inventoryCount = 5;

        double shippingFee = 0.0;

        if (inventoryCount <= 0) {
            System.out.println("Order Rejected: Item is currently out of stock.");
            return;
        }

        if (customerType.equals("PREMIUM")) {
            if (orderValue >= 50.0) {
                shippingFee = 0.0;
            } else {
                shippingFee = 5.0;
            }
        } else if (customerType.equals("STANDARD")) {
            if (orderValue >= 100.0) {
                shippingFee = 0.0;
            } else {
                shippingFee = 10.0;
            }
        } else {
            System.out.println("Error: Unknown customer type.");
            return;
        }

        double totalCost = orderValue + shippingFee;

        System.out.println("Order Confirmed.");
        System.out.println("Base Value: $" + orderValue);
        System.out.println("Shipping Fee: $" + shippingFee);
        System.out.println("Total Charged: $" + totalCost);
    }
}
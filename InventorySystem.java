class Smartphone {
    private String brand;
    private String model;
    private int storageCapacity; // in GB
    private double price;

    public Smartphone(String brand, String model, int storageCapacity, double price) {
        this.brand = brand;
        this.model = model;
        this.storageCapacity = storageCapacity;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        if (newPrice >= 0) {
            this.price = newPrice;
        } else {
            System.out.println("Error: Price cannot be negative.");
        }
    }

    public void printSpecs() {
        System.out.printf("%s %s (%dGB) - ₹%.2f%n", brand, model, storageCapacity, price);
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        Smartphone phone1 = new Smartphone("Xiaomi", "14 Civi", 512, 42999.00);
        Smartphone phone2 = new Smartphone("Redmi", "Note 13 Pro", 256, 25999.00);

        System.out.println("--- Current Inventory ---");
        phone1.printSpecs();
        phone2.printSpecs();

        System.out.println("\nApplying a ₹3000 discount to the Redmi device...");
        double currentRedmiPrice = phone2.getPrice();
        phone2.setPrice(currentRedmiPrice - 3000.00);

        System.out.println("\n--- Updated Inventory ---");
        phone1.printSpecs();
        phone2.printSpecs();
    }
}
import java.util.ArrayList;
import java.util.List;

class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class OrderCart {
    private List<MenuItem> items;

    public OrderCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(MenuItem item) {
        items.add(item);
        System.out.println("Added to cart: " + item.getName());
    }

    public void printBill() {
        System.out.println("\n=========================");
        System.out.println("       FINAL BILL        ");
        System.out.println("=========================");

        double total = 0.0;

        for (MenuItem item : items) {
            System.out.printf("%-25s ₹%.2f%n", item.getName(), item.getPrice());
            total += item.getPrice();
        }

        System.out.println("-------------------------");
        System.out.printf("%-25s ₹%.2f%n", "GRAND TOTAL", total);
        System.out.println("=========================");
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        MenuItem biriyani = new MenuItem("Thalassery Dum Biriyani", 220.00);
        MenuItem porotta = new MenuItem("Kerala Porotta", 15.00);
        MenuItem beefRoast = new MenuItem("Beef Roast", 180.00);
        MenuItem limeJuice = new MenuItem("Fresh Lime Juice", 30.00);

        OrderCart myCart = new OrderCart();

        System.out.println("--- Building Order ---");
        myCart.addItem(biriyani);
        myCart.addItem(porotta);
        myCart.addItem(porotta);
        myCart.addItem(beefRoast);
        myCart.addItem(limeJuice);

        myCart.printBill();
    }
}
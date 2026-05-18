interface PaymentGateway {
    void processPayment(double amount);
}

class RazorpayGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("🔒 Connecting to Razorpay Servers...");
        System.out.printf("✅ Successfully deducted ₹%.2f via UPI.%n", amount);
    }
}

class StripeGateway implements PaymentGateway {
    @Override
    public void processPayment(double amount) {
        System.out.println("🔒 Connecting to Stripe Servers...");
        System.out.printf("✅ Successfully charged ₹%.2f to Credit Card.%n", amount);
    }
}

class CheckoutService {
    private PaymentGateway paymentGateway;

    public CheckoutService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void completeCheckout(double cartTotal) {
        System.out.println("\n--- Initiating Checkout ---");
        System.out.println("Cart Total: ₹" + cartTotal);
        paymentGateway.processPayment(cartTotal);
        System.out.println("--- Order Confirmed ---");
    }
}

public class PaymentSystem {
    public static void main(String[] args) {
        PaymentGateway currentGateway = new RazorpayGateway();

        CheckoutService service = new CheckoutService(currentGateway);
        service.completeCheckout(2500.00);

        PaymentGateway newGateway = new StripeGateway();
        CheckoutService updatedService = new CheckoutService(newGateway);

        updatedService.completeCheckout(4500.00);
    }
}
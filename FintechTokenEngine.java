import java.util.Arrays;

final class TransactionToken {

    private final int tokenId;
    private final String currencySymbol;
    private final int[] latencies;

    public TransactionToken(int tokenId, String currencySymbol, int[] incomingLatencies) {
        this.tokenId = tokenId;
        this.currencySymbol = currencySymbol;

        if (incomingLatencies == null) {
            this.latencies = new int[0];
        } else {
            this.latencies = new int[incomingLatencies.length];
            for (int i = 0; i < incomingLatencies.length; i++) {
                this.latencies[i] = incomingLatencies[i];
            }
        }
    }

    public int getTokenId() {
        return this.tokenId;
    }

    public String getCurrencySymbol() {
        return this.currencySymbol;
    }

    public int[] getLatencies() {
        int[] externalCopy = new int[this.latencies.length];
        for (int i = 0; i < this.latencies.length; i++) {
            externalCopy[i] = this.latencies[i];
        }
        return externalCopy;
    }
}

public class FintechTokenEngine {

    public static void main(String[] args) {
        System.out.println("Initializing Secure Token Integrity Tests...");
        System.out.println("----------------------------------------------");

        int[] sourceLatencies = {12, 45, 22};
        TransactionToken initialToken = new TransactionToken(8001, "INR", sourceLatencies);

        System.out.println("Initial Token Latencies: " + Arrays.toString(initialToken.getLatencies()));

        sourceLatencies[0] = 999;

        System.out.println("\nExecuting Security Breach Check #1...");
        System.out.println("Token Latencies after source modification: "
                + Arrays.toString(initialToken.getLatencies()) + " (Safe!)");

        int[] leakedLatencies = initialToken.getLatencies();
        leakedLatencies[1] = 888;

        System.out.println("\nExecuting Security Breach Check #2...");
        System.out.println("Token Latencies after getter manipulation: "
                + Arrays.toString(initialToken.getLatencies()) + " (Safe!)");
    }
}

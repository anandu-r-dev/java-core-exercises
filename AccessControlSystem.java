class SecureTurnstile {
    private final int turnstileId;
    private int commuteCount;

    public SecureTurnstile(int turnstileId) {
        this.turnstileId = turnstileId;
        this.commuteCount = 0;
    }

    public int getTurnstileId() {
        return this.turnstileId;
    }

    public int getCommuteCount() {
        return this.commuteCount;
    }

    public void registerValidCredentialScan() {
        System.out.println("LOG [ID " + this.turnstileId + "]: Valid credential processed. Unlocking gate...");
        this.commuteCount++;
    }
}

public class AccessControlSystem {

    public static void main(String[] args) {
        System.out.println("Booting Secure Perimeter Access Matrix...");
        System.out.println("----------------------------------------");

        SecureTurnstile lobbyGate = new SecureTurnstile(404);

        System.out.println("Deployed Node ID : " + lobbyGate.getTurnstileId());
        System.out.println("Initial Pass Count: " + lobbyGate.getCommuteCount());
        System.out.println("----------------------------------------");

        lobbyGate.registerValidCredentialScan();
        lobbyGate.registerValidCredentialScan();

        System.out.println("----------------------------------------");
        System.out.println("Updated Pass Count Value: " + lobbyGate.getCommuteCount() + " commutes.");

    }
}
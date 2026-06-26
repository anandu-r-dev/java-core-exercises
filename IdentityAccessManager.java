class UserAccount {
    int accountId;
    String username;
    String accessTier;

    public UserAccount() {
        this(-1, "GUEST");
        System.out.println("LOG: No-Argument constructor execution layer complete.");
    }

    public UserAccount(int accountId, String username) {
        this(accountId, username, "STANDARD");
        System.out.println("LOG: Two-Argument constructor execution layer complete.");
    }

    public UserAccount(int accountId, String username, String accessTier) {
        this.accountId = accountId;
        this.username = username;
        this.accessTier = accessTier;
        System.out.println("LOG: Master constructor field allocation complete.");
    }

    public void displayProfile() {
        System.out.println("Profile Info -> ID: " + accountId + " | User: " + username + " | Tier: " + accessTier);
        System.out.println("-----------------------------------------------------------------");
    }
}

public class IdentityAccessManager {

    public static void main(String[] args) {
        System.out.println("=== Instantiating Account A (Master Path) ===");
        UserAccount accountA = new UserAccount(5001, "alex_dev", "PREMIUM");
        accountA.displayProfile();

        System.out.println("=== Instantiating Account B (Standard Path Chaining) ===");
        UserAccount accountB = new UserAccount(5002, "sarah_qa");
        accountB.displayProfile();

        System.out.println("=== Instantiating Account C (Fallback Path Chaining) ===");
        UserAccount accountC = new UserAccount();
        accountC.displayProfile();
    }
}
import java.util.List;
import java.util.Optional;

class UserProfile {
    private int id;
    private String username;

    public UserProfile(int id, String username) {
        this.id = id;
        this.username = username;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
}

class UserRepository {
    private List<UserProfile> database = List.of(
            new UserProfile(1, "admin_rahul"),
            new UserProfile(2, "kerala_dev")
    );

    public Optional<UserProfile> findProfileById(int searchId) {
        return database.stream()
                .filter(user -> user.getId() == searchId)
                .findFirst();
    }
}

public class SafeQueryEngine {
    public static void main(String[] args) {
        UserRepository repository = new UserRepository();

        System.out.println("--- Scenario A: User Exists ---");
        Optional<UserProfile> foundUser = repository.findProfileById(1);

        if (foundUser.isPresent()) {
            System.out.println("Welcome back, " + foundUser.get().getUsername());
        }

        System.out.println("\n--- Scenario B: User Does NOT Exist (Functional Handling) ---");
        Optional<UserProfile> missingUser = repository.findProfileById(99);

        missingUser.ifPresentOrElse(
                user -> System.out.println("Found: " + user.getUsername()),
                () -> System.out.println("Error: No user found with that ID.")
        );

        System.out.println("\n--- Scenario C: The Spring Boot Way (Throwing an Error) ---");
        try {
            UserProfile requiredUser = repository.findProfileById(99)
                    .orElseThrow(() -> new RuntimeException("User ID 99 not found in database!"));

            System.out.println(requiredUser.getUsername()); // This won't run
        } catch (RuntimeException e) {
            System.out.println("EXCEPTION CAUGHT: " + e.getMessage());
        }
    }
}
public class RestApiPractice {

    public record UserRegistrationRequest(String username, String email, String role) {}

    public static class UserController {

        public void handlePostRequest(String endpoint, UserRegistrationRequest payload) {
            System.out.println("[API Layer] Received POST request at: " + endpoint);
            System.out.println("Payload extracted: " + payload.username() + " | " + payload.email());

            if (payload.email() == null || !payload.email().contains("@")) {
                System.out.println("HTTP 400 Bad Request: Invalid email format rejected.\n");
                return;
            }

            System.out.println("[Service Layer] Validation passed. Saving to database...");
            System.out.println("HTTP 201 Created -> User successfully registered.\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Spring Boot POST Endpoint Simulation ---\n");
        UserController controller = new UserController();

        UserRegistrationRequest validRequest = new UserRegistrationRequest("anandu_r", "anandu@dev.com", "Backend Engineer");
        controller.handlePostRequest("/api/v1/users", validRequest);

        UserRegistrationRequest badRequest = new UserRegistrationRequest("hacker99", "invalid-email-format", "User");
        controller.handlePostRequest("/api/v1/users", badRequest);
    }
}
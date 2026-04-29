public class ThreeTierArchitecture {

    public static class UserRepository {
        public String fetchUserFromDatabase(String userId) {
            return "User Profile [ID: " + userId + ", Name: Anandu, Role: Backend Engineer]";
        }
    }

    public static class UserService {
        private final UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public String processUserData(String userId) {
            System.out.println("[Service Layer] Applying business rules for ID: " + userId);
            String rawData = userRepository.fetchUserFromDatabase(userId);
            return rawData.toUpperCase();
        }
    }

    public static class UserController {
        private final UserService userService;

        public UserController(UserService userService) {
            this.userService = userService;
        }

        public void handleGetRequest(String requestUrl) {
            System.out.println("[API Layer] Received HTTP GET request at: " + requestUrl);

            String extractedId = requestUrl.substring(requestUrl.lastIndexOf("/") + 1);
            String responseBody = userService.processUserData(extractedId);

            System.out.println("HTTP 200 OK -> Payload: { " + responseBody + " }\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Booting up 3-Tier Microservice ---\n");

        UserRepository repo = new UserRepository();
        UserService service = new UserService(repo);
        UserController controller = new UserController(service);

        controller.handleGetRequest("https://api.mycompany.com/users/9981");
        controller.handleGetRequest("https://api.mycompany.com/users/1044");
    }
}
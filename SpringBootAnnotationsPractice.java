public class SpringBootAnnotationsPractice {

    public @interface Service {}
    public @interface RestController {}
    public @interface Autowired {}

    public interface NotificationService {
        void sendMessage(String user, String message);
    }

    @Service
    public static class EmailNotification implements NotificationService {
        @Override
        public void sendMessage(String user, String message) {
            System.out.println("Spring Boot sending EMAIL to " + user + ": " + message);
        }
    }

    @RestController
    public static class UserController {
        private final NotificationService notificationService;
        @Autowired
        public UserController(NotificationService notificationService) {
            this.notificationService = notificationService;
        }

        public void registerUser(String username) {
            System.out.println("API Request received to register: " + username);
            notificationService.sendMessage(username, "Welcome to the Spring Boot backend!");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Spring Boot Architecture Mental Model ---");
        System.out.println("Note: In a real Spring app, the framework runs the main method.");
        System.out.println("We are manually simulating the framework's behavior below:\n");

        NotificationService injectedService = new EmailNotification();
        UserController apiController = new UserController(injectedService);

        apiController.registerUser("Anandu R");
    }
}
public class Notification {
    public interface NotificationService {
        void sendMessage(String user, String message);
    }

    public static class EmailNotification implements NotificationService {
        @Override
        public void sendMessage(String user, String message) {
            System.out.println("Sending EMAIL to " + user + ": " + message);
        }
    }

    public static class SmsNotification implements NotificationService {
        @Override
        public void sendMessage(String user, String message) {
            System.out.println("Sending SMS to " + user + ": " + message);
        }
    }

    public static class UserRegistration {
        private final NotificationService notificationService;

        public UserRegistration(NotificationService notificationService) {
            this.notificationService = notificationService;
        }

        public void registerUser(String username) {
            System.out.println("Registering user in database: " + username);
            notificationService.sendMessage(username, "Welcome to the system!");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Spring Boot DI Simulation ---");

        NotificationService emailService = new EmailNotification();
        UserRegistration emailRegistration = new UserRegistration(emailService);
        emailRegistration.registerUser("Anandu R");

        System.out.println("---------------------------------");

        NotificationService smsService = new SmsNotification();
        UserRegistration smsRegistration = new UserRegistration(smsService);
        smsRegistration.registerUser("System Admin");
    }
}

public class GlobalExceptionHandlerPractice {

    public @interface RestControllerAdvice {}
    public @interface ExceptionHandler {}

    public static class InvalidPayloadException extends RuntimeException {
        public InvalidPayloadException(String message) {
            super(message);
        }
    }

    public record ErrorResponse(int statusCode, String errorMessage, String timestamp) {}

    @RestControllerAdvice
    public static class GlobalExceptionHandler {

        @ExceptionHandler
        public ErrorResponse handleInvalidPayload(InvalidPayloadException ex) {
            System.out.println(">>> [Global Safety Net] Intercepted an application crash! <<<");
            return new ErrorResponse(400, ex.getMessage(), "2026-05-01T19:00:00Z");
        }
    }

    public static class UserController {
        public void registerUser(String email) {
            System.out.println("[API Layer] Attempting to register: " + email);
            if (!email.contains("@")) {
                throw new InvalidPayloadException("Malformed email address rejected.");
            }
            System.out.println("HTTP 201 Created -> User successfully registered.\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Spring Boot Global Error Handling Simulation ---\n");

        UserController controller = new UserController();
        GlobalExceptionHandler advice = new GlobalExceptionHandler();

        try {
            controller.registerUser("anandu_r_dev_no_domain");
        } catch (InvalidPayloadException ex) {
            ErrorResponse formattedError = advice.handleInvalidPayload(ex);
            System.out.println("HTTP " + formattedError.statusCode() + " Bad Request -> Payload: ");
            System.out.println("{ error: '" + formattedError.errorMessage() + "', time: '" + formattedError.timestamp() + "' }");
        }
    }
}
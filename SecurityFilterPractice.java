public class SecurityFilterPractice {

    public @interface Component {}

    @Component
    public static class JwtAuthenticationFilter {

        public boolean doFilter(String authHeader) {
            System.out.println("[Security Filter] Intercepting incoming HTTP request...");

            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                System.out.println("HTTP 401 Unauthorized: Missing or invalid token. Dropping request.\n");
                return false;
            }

            String token = authHeader.substring(7);
            if (token.equals("valid_system_token_9981")) {
                System.out.println("[Security Filter] Token verified. Access Granted to API Layer.\n");
                return true;
            } else {
                System.out.println("HTTP 403 Forbidden: Token is forged or expired. Dropping request.\n");
                return false;
            }
        }
    }

    public static class BankController {
        public void getAccountBalance() {
            System.out.println("HTTP 200 OK -> Payload: { balance: 13800.00, status: 'SECURE' }\n");
        }
    }

    public static void main(String[] args) {
        System.out.println("--- Booting Spring Security Module ---\n");

        JwtAuthenticationFilter securityFilter = new JwtAuthenticationFilter();
        BankController api = new BankController();

        System.out.println("-> SCENARIO A: Unauthenticated Request (Hacker)");
        if (securityFilter.doFilter(null)) {
            api.getAccountBalance();
        }

        System.out.println("-> SCENARIO B: Authenticated Request (Legitimate User)");
        if (securityFilter.doFilter("Bearer valid_system_token_9981")) {
            api.getAccountBalance();
        }
    }
}
public class HDFCNetBankingSecure {

    public static void main(String[] args) {
        int currentAttemptCount = 0;
        final int MAX_ALLOWED_ATTEMPTS = 3;
        boolean isOtpVerified = false;

        System.out.println("Processing IMPS Transfer Request...");
        System.out.println("Secure OTP Challenge Issued via SMS.");
        System.out.println("----------------------------------------");

        do {
            currentAttemptCount++;
            System.out.println("Processing OTP Verification Attempt " + currentAttemptCount + " of " + MAX_ALLOWED_ATTEMPTS + "...");

            if (currentAttemptCount == 3) {
                isOtpVerified = true;
            }

            if (isOtpVerified) {
                System.out.println("Verification Status: OTP MATCHED SUCCESSFULLY.");
            } else {
                System.out.println("Verification Status: INVALID OTP entered.");
            }

            System.out.println("----------------------------------------");

        } while (!isOtpVerified && currentAttemptCount < MAX_ALLOWED_ATTEMPTS);

        if (isOtpVerified) {
            System.out.println("Transaction Status: SUCCESS. Funds dispatched.");
        } else {
            System.out.println("Transaction Status: FAILED. Device locked for 24 hours.");
        }
    }
}
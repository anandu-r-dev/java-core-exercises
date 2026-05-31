
public class BitwisePermissionController {

    public static final byte FLAG_READ    = 1 << 0;
    public static final byte FLAG_WRITE   = 1 << 1;
    public static final byte FLAG_EXECUTE = 1 << 2;
    public static final byte FLAG_DELETE  = 1 << 3;

    public static void main(String[] args) {
        byte securityProfile = 0;
        System.out.println("Initial Profile Binary Structure: " + String.format("%8s", Integer.toBinaryString(securityProfile)).replace(' ', '0'));
        System.out.println("--------------------------------------------------");

        securityProfile = (byte) (securityProfile | FLAG_READ);
        securityProfile = (byte) (securityProfile | FLAG_WRITE);

        System.out.println("Profile after granting READ & WRITE permissions:");
        displayProfileStatus(securityProfile);

        boolean canRead = (securityProfile & FLAG_READ) != 0;
        boolean canExecute = (securityProfile & FLAG_EXECUTE) != 0;

        System.out.println("Permission Verification Queries:");
        System.out.println(" -> Has READ access?     : " + canRead);
        System.out.println(" -> Has EXECUTE access?  : " + canExecute);
        System.out.println("--------------------------------------------------");

        System.out.println("Revoking WRITE permission flag dynamically...");
        securityProfile = (byte) (securityProfile & (~FLAG_WRITE));

        System.out.println("Final Profile Configuration:");
        displayProfileStatus(securityProfile);
    }

    private static void displayProfileStatus(byte profile) {
        String binaryRepresentation = String.format("%8s", Integer.toBinaryString(profile & 0xFF)).replace(' ', '0');
        System.out.println("Raw Byte Value (Binary) : " + binaryRepresentation);
        System.out.println("Raw Byte Value (Decimal): " + profile);
        System.out.println("==================================================");
    }
}
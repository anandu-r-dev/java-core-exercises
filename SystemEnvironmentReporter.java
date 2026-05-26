public class SystemEnvironmentReporter {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("  Java Runtime Environment Execution Report");
        System.out.println("==================================================");

        String javaVersion = System.getProperty("java.version");
        String javaVendor = System.getProperty("java.vendor");
        String osName = System.getProperty("os.name");
        String osArchitecture = System.getProperty("os.arch");

        System.out.println("Execution Status  : SUCCESS");
        System.out.println("Java Version      : " + javaVersion);
        System.out.println("Java Vendor       : " + javaVendor);
        System.out.println("Operating System  : " + osName);
        System.out.println("OS Architecture   : " + osArchitecture);

        System.out.println("==================================================");
    }
}
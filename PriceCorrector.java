import java.util.Arrays;

public class PriceCorrector {

    public static void main(String[] args) {
        int baseTaxPercentage = 5;

        int[] dailyPotatoRates = {18, 22, 20};

        System.out.println("=== INITIAL CONDITIONS (Before Method Invocation) ===");
        System.out.println("Stack Primitive (Tax)     : " + baseTaxPercentage + "%");
        System.out.println("Heap Object Data (Rates)  : " + Arrays.toString(dailyPotatoRates));
        System.out.println("-----------------------------------------------------");

        modifyPrimitive(baseTaxPercentage);
        System.out.println("=== AFTER modifyPrimitive() ===");
        System.out.println("Stack Primitive (Tax)     : " + baseTaxPercentage + "% (Unchanged!)");
        System.out.println("-----------------------------------------------------");

        modifyArray(dailyPotatoRates);
        System.out.println("=== AFTER modifyArray() ===");
        System.out.println("Heap Object Data (Rates)  : " + Arrays.toString(dailyPotatoRates) + " (Index altered, Reference protected!)");
    }

    public static void modifyPrimitive(int tax) {
        tax = 18;
    }

    public static void modifyArray(int[] rates) {
        rates[0] = 40;

        rates = new int[]{100, 200, 300};

        rates[0] = 999;
    }
}
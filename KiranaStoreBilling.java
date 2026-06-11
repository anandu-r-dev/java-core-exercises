public class KiranaStoreBilling {

    public static void main(String[] args) {
        int[] currentRiceBagsStock = {45, 12, 89, 34};

        int[] dailySugarSales = new int[4];

        System.out.println("=== Memory Initialization Baseline Values ===");
        System.out.println("Default Sugar Sales Index 0 Value: " + dailySugarSales[0]);
        System.out.println("Default Sugar Sales Index 3 Value: " + dailySugarSales[3]);
        System.out.println("---------------------------------------------");

        dailySugarSales[0] = 15;
        dailySugarSales[1] = 22;
        dailySugarSales[2] = 8;
        dailySugarSales[3] = 31;

        int riceArrayLength = currentRiceBagsStock.length;
        int sugarArrayLength = dailySugarSales.length;

        System.out.println("Array Sizing Diagnostics:");
        System.out.println(" Rice Stock Record Length : " + riceArrayLength + " slots");
        System.out.println(" Sugar Sales Record Length: " + sugarArrayLength + " slots");
        System.out.println("---------------------------------------------");

        System.out.println("Static Element Lookup Logs:");
        System.out.println(" First element in Rice Stock Array: " + currentRiceBagsStock[0] + " bags");
        System.out.println(" Final element in Rice Stock Array: " + currentRiceBagsStock[riceArrayLength - 1] + " bags");
        System.out.println(" Dynamic Match Index 2 Sugar Sales: " + dailySugarSales[2] + " kg");
    }
}
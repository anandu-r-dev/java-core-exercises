@FunctionalInterface
interface NumericFilter {
    boolean evaluateCondition(int value);
}

public class StreamProcessingEngine {

    public static void filterAndDisplay(int[] datasets, NumericFilter filterCriteria) {
        for (int item : datasets) {
            if (filterCriteria.evaluateCondition(item)) {
                System.out.print(item + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Initializing Functional Stream Processing Sandbox...");
        System.out.println("---------------------------------------------------------");

        int[] numericalPool = {12, 5, 18, 23, 40, 7, 52};

        NumericFilter evenFilterOldWay = new NumericFilter() {
            @Override
            public boolean evaluateCondition(int value) {
                return value % 2 == 0;
            }
        };
        System.out.print("Even Numbers (Anonymous Class) : ");
        filterAndDisplay(numericalPool, evenFilterOldWay);

        NumericFilter evenFilterLambda = (value) -> value % 2 == 0;

        System.out.print("Even Numbers (Lambda Reference): ");
        filterAndDisplay(numericalPool, evenFilterLambda);

        System.out.print("High Numbers Only (Value > 20)  : ");
        filterAndDisplay(numericalPool, (val) -> val > 20);

        System.out.println("---------------------------------------------------------");
    }
}
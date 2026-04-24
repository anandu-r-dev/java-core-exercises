public class BudgetTracker {

    public static double calculateDailyAllowance(double totalIncome, double fixedExpenses) {
        double remainingCash = totalIncome - fixedExpenses;
        return remainingCash / 30;
    }

    public static void main(String[] args) {
        double myIncome = 29800.0;
        double myFixedCosts = 16000.0;

        double dailyLimit = calculateDailyAllowance(myIncome, myFixedCosts);

        System.out.println("--- Financial Health Check ---");
        System.out.println("Monthly Take-home: ₹" + myIncome);
        System.out.println("Daily Survival Budget: ₹" + (int)dailyLimit);

        if (dailyLimit < 500) {
            System.out.println("Status: STRICT DISCIPLINE REQUIRED.");
        } else {
            System.out.println("Status: WITHIN SAFETY MARGIN.");
        }
    }
}
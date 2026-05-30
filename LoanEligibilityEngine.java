public class LoanEligibilityEngine {

    public static void main(String[] args) {
        int applicantCreditScore = 720;
        double applicantMonthlyIncome = 5500.00;
        boolean hasActiveBankruptcy = false;

        final int MIN_CREDIT_SCORE = 700;
        final double MIN_MONTHLY_INCOME = 5000.00;

        System.out.println("Beginning Gateway Security Rules Verification...");
        System.out.println("--------------------------------------------------");

        boolean isApproved = (applicantCreditScore >= MIN_CREDIT_SCORE)
                && (applicantMonthlyIncome >= MIN_MONTHLY_INCOME)
                && (!hasActiveBankruptcy);

        System.out.println("Diagnostic Evaluation Matrix Summary:");
        System.out.println("Credit Check Passed     : " + (applicantCreditScore >= MIN_CREDIT_SCORE));
        System.out.println("Income Check Passed     : " + (applicantMonthlyIncome >= MIN_MONTHLY_INCOME));
        System.out.println("Clean History Passed    : " + (!hasActiveBankruptcy));
        System.out.println("--------------------------------------------------");
        System.out.println("FINAL SYSTEM DECISION   : LOAN APPROVED = " + isApproved);
        System.out.println("================================================--");

        int activeAccountsCount = 0;
        int totalTransactionVolume = 50_000;

        boolean isHighDensityAccount = (activeAccountsCount != 0) && ((totalTransactionVolume / activeAccountsCount) > 10000);
        System.out.println("Safety Guard Active Account Volume Metric Match: " + isHighDensityAccount);
    }
}
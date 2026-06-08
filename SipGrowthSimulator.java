public class SipGrowthSimulator {

    public static void main(String[] args) {
        final int ANNUAL_INVESTMENT_INR = 10000;
        final double ANNUAL_GROWTH_RATE = 0.12;
        final int SIMULATION_TENURE_YEARS = 5;

        double totalPortfolioValue = 0.0;

        System.out.println("Starting 5-Year SIP Growth Simulation (10,000/Year @ 12%):");
        System.out.println("---------------------------------------------------------");

        for (int year = 1; year <= SIMULATION_TENURE_YEARS; year++) {
            totalPortfolioValue += ANNUAL_INVESTMENT_INR;

            totalPortfolioValue += (totalPortfolioValue * ANNUAL_GROWTH_RATE);

            System.out.println("End of Year " + year + " | Portfolio Valuation: " + String.format("%.2f", totalPortfolioValue));
        }


        System.out.println("---------------------------------------------------------");
        System.out.println("Simulation Complete. Final Maturity Value: " + String.format("%.2f", totalPortfolioValue));
    }
}
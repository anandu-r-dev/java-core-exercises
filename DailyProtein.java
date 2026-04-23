public class DailyProtein {
    public static void main(String[] args) {

        double exactProteinTarget = 160.5;
        int dailyProteinGoal = (int) exactProteinTarget;

        System.out.println("Daily Target: " + dailyProteinGoal + "g");

        int currentProtein = 0;
        int mealCount = 1;

        while (currentProtein < dailyProteinGoal) {

            int proteinAdded = 0;

            switch (mealCount) {
                case 1:
                    proteinAdded = 30;
                    break;
                case 2:
                    proteinAdded = 50;
                    break;
                case 3:
                    proteinAdded = 40;
                    break;
                default:
                    proteinAdded = 40;
                    break;
            }

            currentProtein += proteinAdded;
            System.out.println("Meal " + mealCount + " consumed. Total: " + currentProtein + "g");
            mealCount++;
        }

        if (currentProtein >= dailyProteinGoal) {
            System.out.println("Fuel target reached. Ready for Push/Pull/Legs session.");
        } else {
            System.out.println("Target missed. Check macros.");
        }
    }
}

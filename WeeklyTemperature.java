public class WeeklyTemperature {
    public static void main (String[] args){
        double[] weeklyTemp = {24.5, 26.0, 23.5, 25.0, 27.5, 28.0, 25.5};
        double sum = 0 ;

        for(double temp : weeklyTemp){
           sum += temp;
        }

        double avg = sum/weeklyTemp.length;

        System.out.println("Weekly Temperature Processing...");
        System.out.println("Average Temperature: " + avg + " Celsius");
    }
}

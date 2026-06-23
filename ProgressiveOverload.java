import java.util.ArrayList;

public class ProgressiveOverload {
    public static void main (String[] args){
        ArrayList<Double> weightList = new ArrayList<>();
        weightList.add(100.5);
        weightList.add(105.0);
        weightList.add(110.5);

        weightList.remove(0);

        System.out.println("Working Sets Tracked:");
        for (double weight : weightList){
            System.out.println("Set: " + weight + " kg");
        }
    }
}

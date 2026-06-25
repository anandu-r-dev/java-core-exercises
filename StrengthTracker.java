import java.util.ArrayList;
import java.util.List;

public class StrengthTracker {

    public static void main(String[] args){
        List<Double> weights = new ArrayList<>(List.of(82.5, 15.0, 83.0, 83.5, 450.0, 82.0));
        weights.stream()
                .mapToDouble(Double::doubleValue)
                .filter(w -> w >= 50 && w <= 150)
                .max().ifPresent(max -> System.out.println("Highest valid recorded weight: " + max + " kg"));
    }
}

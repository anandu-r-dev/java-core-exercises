import java.util.ArrayList;

interface Workout{
    int calculateCaloriesBurned(int minutes);
}

class Weightlifting implements Workout{
    public int calculateCaloriesBurned(int minutes){
        return minutes * 5;
    }
}

class Cardio implements Workout{
    public int calculateCaloriesBurned(int minutes) {
        return minutes * 10;
    }
}

public class WorkoutTracker {
    public static void main(String[] args){
        Weightlifting weightlifting = new Weightlifting();
        Cardio cardio = new Cardio();

        ArrayList<Workout> workoutList = new ArrayList<>();
        workoutList.add(weightlifting);
        workoutList.add(cardio);

        for (Workout workout : workoutList){
            System.out.println("Burned: " + workout.calculateCaloriesBurned(45) + " calories.");
        }

    }
}

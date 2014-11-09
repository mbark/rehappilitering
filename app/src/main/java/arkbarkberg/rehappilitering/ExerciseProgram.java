package arkbarkberg.rehappilitering;

import java.util.ArrayList;

/**
 * Created by mbark on 08/11/14.
 */
public class ExerciseProgram {
    public static final ArrayList<Exercise> EXERCISES = new ArrayList<Exercise>();

    public static boolean checkExercise(Exercise e) {
        if(EXERCISES.contains(e)) {
            EXERCISES.remove(e);
            return false;
        } else {
            EXERCISES.add(e);
            return true;
        }
    }

    public static void removeExercise(Exercise e) {
        EXERCISES.remove(e);
    }

    public static ArrayList<Exercise> getExercisesInProgram() {
        return EXERCISES;
    }
}

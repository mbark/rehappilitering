package arkbarkberg.rehappilitering;

import java.util.ArrayList;

/**
 * Created by mbark on 08/11/14.
 */
public class ExerciseProgram {
    public static final ArrayList<Exercise> EXERCISES = new ArrayList<Exercise>();

    public static void addExercise(Exercise e) {
        EXERCISES.add(e);
    }

    public static void removeExercise(Exercise e) {
        EXERCISES.remove(e);
    }

    public static ArrayList<Exercise> getExercisesInProgram() {
        return EXERCISES;
    }
}

package arkbarkberg.rehappilitering;

import java.util.ArrayList;

/**
 * Created by mbark on 08/11/14.
 */
public class ExerciseCategory {
    private ArrayList<Exercise> exercises;

    public ExerciseCategory(int id, String name) {
        exercises = new ArrayList<Exercise>();
    }

    public void setExercises(ArrayList<Exercise> exercises) {
        this.exercises = exercises;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}

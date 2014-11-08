package arkbarkberg.rehappilitering;

import java.util.ArrayList;

/**
 * Created by mbark on 08/11/14.
 */
public class ExerciseCategory {
    private int id;
    private String name;
    private ArrayList<Exercise> exercises;

    public ExerciseCategory(int id, String name) {
        this.id = id;
        this.name = name;
        exercises = new ArrayList<Exercise>();
    }

    public void addExercise(Exercise e) {
        exercises.add(e);
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}

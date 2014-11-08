package arkbarkberg.rehappilitering;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by mbark on 08/11/14.
 */
public class Database {
    private static ArrayList<ExerciseCategory> categories = new ArrayList<ExerciseCategory>();

    public static void constructDb() {
        ExerciseCategory categoryKnee = new ExerciseCategory(1, "Knä");
        ExerciseCategory categoryElbow = new ExerciseCategory(2, "Armbåge");

        ArrayList<Exercise> exercisesKnee = new ArrayList<Exercise>();
        exercisesKnee.add(new Exercise("Knäböj", "Gör knäböj", "http://www.youtube.com"));
        exercisesKnee.add(new Exercise("Knästräck", "Gör knästräck", "http://www.youtube.com"));
        exercisesKnee.add(new Exercise("Utfall", "Gör utfall", "http://www.youtube.com"));
        categoryKnee.setExercises(exercisesKnee);

        ArrayList<Exercise> exercisesElbow = new ArrayList<Exercise>();
        exercisesKnee.add(new Exercise("Armgos", "Do stuff", "http://www.youtube.com"));
        exercisesKnee.add(new Exercise("Armböj", "Do stuff", "http://www.youtube.com"));
        categoryKnee.setExercises(exercisesElbow);

        categories.add(categoryKnee);
        categories.add(categoryElbow);
    }

    public static ArrayList<ExerciseCategory> getCategories() {
        return categories;
    }
}

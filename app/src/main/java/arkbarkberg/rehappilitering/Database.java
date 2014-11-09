package arkbarkberg.rehappilitering;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by mbark on 08/11/14.
 */
public class Database {
    private static final ArrayList<ExerciseCategory> CATEGORIES = new ArrayList<ExerciseCategory>();

    public static void constructDb() {
        ExerciseCategory categoryKnee = new ExerciseCategory(1, "Knä");
        ExerciseCategory categoryElbow = new ExerciseCategory(2, "Armbåge");

        categoryKnee.addExercise(new Exercise("Knäböj", "Gör knäböj", "http://www.youtube.com"));
        categoryKnee.addExercise(new Exercise("Knästräck", "Gör knästräck", "http://www.youtube.com"));
        categoryKnee.addExercise(new Exercise("Utfall", "Gör utfall", "http://www.youtube.com"));

        categoryElbow.addExercise(new Exercise("Armgos", "Do stuff", "http://www.youtube.com"));
        categoryElbow.addExercise(new Exercise("Armböj", "Do stuff", "http://www.youtube.com"));

        CATEGORIES.add(categoryKnee);
        CATEGORIES.add(categoryElbow);
    }

    public static ArrayList<ExerciseCategory> getCategories() {
        return CATEGORIES;
    }
}

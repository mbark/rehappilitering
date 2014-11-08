package arkbarkberg.rehappilitering;

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
        exercisesKnee.add(new Exercise("Knägos", "Do stuff", "http://www.youtube.com"));
        exercisesKnee.add(new Exercise("Knäböj", "Do stuff", "http://www.youtube.com"));
        categoryKnee.setExercises(exercisesKnee);

        ArrayList<Exercise> exercisesElbow = new ArrayList<Exercise>();
        exercisesKnee.add(new Exercise("Armgos", "Do stuff", "http://www.youtube.com"));
        exercisesKnee.add(new Exercise("Armböj", "Do stuff", "http://www.youtube.com"));
        categoryKnee.setExercises(exercisesElbow);

        categories.add(categoryElbow);
        categories.add(categoryKnee);
    }

    public static ArrayList<ExerciseCategory> getCategories() {
        return categories;
    }
}

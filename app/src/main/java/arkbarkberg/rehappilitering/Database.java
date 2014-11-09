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

        categoryKnee.addExercise(new Exercise("Knäböj","Sitt på främre delen av stolen med det opererade benets fot bakom det friska benets fot. Böj i en mjuk rörelse fram och tillbaka, hjälp till med det friska benet.", "https://www.youtube.com/watch?v=kAyl8KiQ8m0"));
        categoryKnee.addExercise(new Exercise("Knästräck", "Spänn lårmuskeln så att knät sträcks så mycket som möjligt. Håll kvar 5 sekunder, vila 5 sekunder. Utför 5 - 10 gånger i följd varje timma. Pröva att knipa ihop med sätesmuskeln för att få mer kraft.", "https://www.youtube.com/watch?v=ufq_l2Z8m88"));
        categoryKnee.addExercise(new Exercise("Utfall", "Gör utfall", "http://www.youtube.com"));

        categoryKnee.addExercise(new Exercise("Armgos", "Do stuff", "http://www.youtube.com"));
        categoryKnee.addExercise(new Exercise("Armböj", "Do stuff", "http://www.youtube.com"));

        CATEGORIES.add(categoryKnee);
        CATEGORIES.add(categoryElbow);
    }

    public static ArrayList<ExerciseCategory> getCategories() {
        return CATEGORIES;
    }
}

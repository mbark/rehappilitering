package arkbarkberg.rehappilitering;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

//Listar övningar som kan läggas till. Kommer hit från AddExercises

public class AddExercisesToList extends Activity implements View.OnClickListener{

    ArrayList<Exercise> allExercises;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercises_to_list);

        LinearLayout verticalLayout = (LinearLayout) findViewById(R.id.exercisesWrapper);

        allExercises = Database.getCategories().get(0).getExercises();

        Log.e("*****", ""+allExercises.size());
        int i = 0;
        for(Exercise e : allExercises){
            Button exerciseButton = new Button(this);
            exerciseButton.setText(e.getName());
            exerciseButton.setTag(i);
            exerciseButton.setTextColor(Color.parseColor("#FFFFFF"));
            exerciseButton.setBackgroundColor(Color.parseColor("#C17575"));


            Button checkButton = new Button(this);
            checkButton.setText("+");
            checkButton.setTag(i);
            checkButton.setTextColor(Color.parseColor("#FFFFFF"));
            checkButton.setBackgroundColor(Color.parseColor("#C17575"));
            checkButton.setOnClickListener(this);

            LinearLayout horizontalLayout = new LinearLayout(this);
            horizontalLayout.setOrientation(LinearLayout.HORIZONTAL);

            LinearLayout.LayoutParams paramsLeft = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1
            );

            LinearLayout.LayoutParams paramsRight = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    9
            );

            exerciseButton.setLayoutParams(paramsLeft);
            checkButton.setLayoutParams(paramsRight);

            horizontalLayout.addView(exerciseButton);
            horizontalLayout.addView(checkButton);

            verticalLayout.addView(horizontalLayout);

            i++;
        }

        Button homeButton = new Button(this);
        homeButton.setText("Till startskärm");
        homeButton.setTag("home");
        homeButton.setOnClickListener(this);
        homeButton.setTextColor(Color.parseColor("#FFFFFF"));
        homeButton.setBackgroundColor(Color.parseColor("#C17575"));
        verticalLayout.addView(homeButton);

    }

    @Override
    public void onClick(View v) {
        Log.e("******", "HOME");
        if(v.getTag()=="home"){
            Log.e("******", "HOME2");
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Exercise e = allExercises.get((Integer) v.getTag());
            addExercise(e);
        }

    }

    private void addExercise(Exercise e) {
        ExerciseProgram.addExercise(e);
        Log.e("********", "ADDED");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_exercises_to_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

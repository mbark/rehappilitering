package arkbarkberg.rehappilitering;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.io.Console;
import java.util.ArrayList;


//Visar områden inom vilka man har övningar. Från startskärm.

public class YourExercises extends Fragment implements View.OnClickListener {

    public YourExercises(){
        //empty const
    }

    //Variabel som håller ett exercise objekt för att kunna skicka denna till en ny activity
    public static Exercise sendExercise;

    Context thiscontext;

    Button exerciseButton;
    //Global array med alla valda övningar
    ArrayList<Exercise> exercises = new ArrayList<Exercise>();

 /*   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_exercises);*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        thiscontext = container.getContext();


        //Skapar lite dummy content
        Exercise exercise1 = new Exercise("Knäböj","Stå rakt och böj på knäna försiktigt", "www.youtube.com");
        Exercise exercise2 = new Exercise("Knävrid","Stå rakt och vrid på knäna försiktigt", "www.youtube.com");
        exercises.add(exercise1);
        exercises.add(exercise2);



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_your_exercises, container, false);


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onViewCreated(view, savedInstanceState);

        //Hämtar en layout från XML-filen
        LinearLayout layout = (LinearLayout) getView().findViewById(R.id.exerciseButtons);

        //Loopar igenom array och skapar knappar
        for (int i=0; i<exercises.size(); i++){
            exerciseButton = new Button(thiscontext);

            //setTag hjälper oss skilja på olika knappar
            exerciseButton.setTag(i);
            exerciseButton.setText(exercises.get(i).getName());
            exerciseButton.setOnClickListener(this);
            layout.addView(exerciseButton);
        }

    }

    public void onClick(View v) {

        //Hämta det klickade objektet från array
        Exercise e = exercises.get((Integer) v.getTag());

        //Skapa intent dit användaren skickas
        Intent intent = new Intent(thiscontext, InstructionsYour.class);

        //Skapa bundle så vi kan skicka exercise objekt mellan aktiviteter
        Bundle bundle = new Bundle();
        bundle.putSerializable("exercise", e);
        intent.putExtras(bundle);

        //Starta ny aktivitet
        startActivity(intent);
    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_your_exercises, menu);
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
    }*/
}

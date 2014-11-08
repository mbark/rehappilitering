package arkbarkberg.rehappilitering;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.graphics.Color;

import android.net.Uri;

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

        if(ExerciseProgram.EXERCISES.size()==0){
            Button createProgramButton = (Button)getView().findViewById(R.id.createProgramButton);
            createProgramButton.setVisibility(View.VISIBLE);
            createProgramButton.setOnClickListener(this);
        }

        else{
                    //Loopar igenom array och skapar knappar

        for (int i=0; i<exercises.size(); i++){
            exerciseButton = new Button(thiscontext);

            //setTag hjälper oss skilja på olika knappar
            exerciseButton.setTag(i);
            exerciseButton.setText(exercises.get(i).getName());
            exerciseButton.setTextColor(Color.parseColor("#FFFFFF"));
            exerciseButton.setBackgroundColor(Color.parseColor("#C17575"));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(0, 0, 0, 10);
            exerciseButton.setLayoutParams(params);

            exerciseButton.setOnClickListener(this);
            layout.addView(exerciseButton);

            Button setNotificationButton = (Button)getView().findViewById(R.id.setNotification);
            setNotificationButton.setVisibility(View.VISIBLE);
            Button evaluateButton = (Button)getView().findViewById(R.id.evaluateButton);
            evaluateButton.setVisibility(View.VISIBLE);
        }
        }

    }


    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.createProgramButton:
                Intent intent = new Intent(thiscontext, AddExercises.class);
                startActivity(intent);
            break;


        case R.id.exerciseButtons://Hämta det klickade objektet från array
        Exercise e = exercises.get((Integer) v.getTag());

        //Skapa intent dit användaren skickas
        Intent intent2 = new Intent(thiscontext, InstructionsYour.class);

        //Skapa bundle så vi kan skicka exercise objekt mellan aktiviteter
        Bundle bundle = new Bundle();
        bundle.putSerializable("exercise", e);
        intent2.putExtras(bundle);

        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=cxLG2wtE7TM")));
        //Starta ny aktivitet
        //startActivity(intent);

            break;

        }
    }


}

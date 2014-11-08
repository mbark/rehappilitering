package arkbarkberg.rehappilitering;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

//Instruktioner om övningar. Skickas hit från YourExercisesListed. Kan vara samma kod som InstructionsAdd


public class InstructionsYour extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_your);

        Exercise e = (Exercise)getIntent().getSerializableExtra("exercise");

        if(e != null) {
            //Sätt in övningens text på skärmen

            TextView exerciseTitle = (TextView) findViewById(R.id.exerciseTitle);
            exerciseTitle.setText(e.getName());

            //startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=cxLG2wtE7TM")));

            TextView exerciseText = (TextView) findViewById(R.id.exerciseText);
            exerciseText.setText(e.getInstructions());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_instructions_your, menu);
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

package arkbarkberg.rehappilitering;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//Instruktioner om övningar. Skickas hit från YourExercisesListed. Kan vara samma kod som InstructionsAdd


public class InstructionsYour extends Activity implements View.OnClickListener {

    Exercise e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instructions_your);

        e = (Exercise)getIntent().getSerializableExtra("exercise");

        if(e != null) {
            //Sätt in övningens text på skärmen

            TextView exerciseTitle = (TextView) findViewById(R.id.exerciseTitle);
            exerciseTitle.setText(e.getName());

            ImageView videoButton = (ImageView) findViewById(R.id.videoButton);
            videoButton.setOnClickListener(this);

            TextView exerciseText = (TextView) findViewById(R.id.exerciseText);
            exerciseText.setText(e.getInstructions());
        }
    }

    public void onClick(View v) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(e.getVideoUrl())));
        /*if(v.findViewById(R.id.videoButton).toString() == "videoButton"){

        }*/
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

package arkbarkberg.rehappilitering;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends Activity implements View.OnClickListener {

    ImageButton maddButton;
    ImageButton mscheduleButton;
    ImageButton mstatisticsButton;
    ImageButton mexerciseButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maddButton = (ImageButton)findViewById(R.id.addButton);
        maddButton.setOnClickListener(this);

       mscheduleButton = (ImageButton)findViewById(R.id.scheduleButton);
       mscheduleButton.setOnClickListener(this);

        mstatisticsButton = (ImageButton)findViewById(R.id.statisticsButton);
        mstatisticsButton.setOnClickListener(this);

        mexerciseButton = (ImageButton)findViewById(R.id.exerciseButton);
        mexerciseButton.setOnClickListener(this);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v){

        switch(v.getId()) {
            case R.id.addButton:

                //Skicka till skärm "Lägg till övning"

            break;

            case R.id.scheduleButton:

                //Skicka till skärm "Ditt rehabschema"

            break;

            case R.id.statisticsButton:

                //Skicka till skärm "Din rehabstatistik"

            break;

            case R.id.exerciseButton:

                //Skicka till skärm "Dina rehabområden"

            break;

        }

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

package arkbarkberg.rehappilitering;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;




public class MainActivity extends FragmentActivity implements ActionBar.TabListener {

    ImageButton maddButton;
    ImageButton mscheduleButton;
    ImageButton mstatisticsButton;
    ImageButton mexerciseButton;

    ActionBar mactionBar;
    ViewPager mviewPager;


    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        Database.constructDb();
        setContentView(R.layout.activity_main);

      /*  maddButton = (ImageButton)findViewById(R.id.addButton);
        maddButton.setOnClickListener(this);

       mscheduleButton = (ImageButton)findViewById(R.id.scheduleButton);
       mscheduleButton.setOnClickListener(this);

        mstatisticsButton = (ImageButton)findViewById(R.id.statisticsButton);
        mstatisticsButton.setOnClickListener(this);

        mexerciseButton = (ImageButton)findViewById(R.id.exerciseButton);
        mexerciseButton.setOnClickListener(this);*/

        mviewPager = (ViewPager)findViewById(R.id.mainpager);
        FragmentManager fm = getSupportFragmentManager();
        mviewPager.setAdapter(new MyAdapter(fm)); //passing manager object

        mviewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
                //Log.d("onpagescrolled",","+i+","+v+","+i2);

            }

            @Override
            public void onPageSelected(int i) {
                Log.d("OnpageSelected at",":"+i);

                mactionBar.setSelectedNavigationItem(i);

            }

            @Override
            public void onPageScrollStateChanged(int i) {

                if(i==ViewPager.SCROLL_STATE_IDLE){
                    Log.d("scrollstate","idle");
                }
                if(i==ViewPager.SCROLL_STATE_DRAGGING){
                    Log.d("scrollstate","dragging");
                }
                if(i==ViewPager.SCROLL_STATE_SETTLING){
                    Log.d("scrollstate","settling");
                }

            }
        });

        mactionBar = getActionBar();
        mactionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);


        ActionBar.Tab scheduleTab = mactionBar.newTab();
        scheduleTab.setText(R.string.schedule);
        scheduleTab.setTabListener(this);

        ActionBar.Tab statisticsTab = mactionBar.newTab();
        statisticsTab.setText(R.string.statistics);
        statisticsTab.setTabListener(this);

        ActionBar.Tab exerciseTab = mactionBar.newTab();
        exerciseTab.setText(R.string.exercise);
        exerciseTab.setTabListener(this);

        mactionBar.addTab(exerciseTab);
        mactionBar.addTab(scheduleTab);
        mactionBar.addTab(statisticsTab);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    /*public void onClick(View v){

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

    }*/

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

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        mviewPager.setCurrentItem(tab.getPosition());
        //Log.d("Tabs", " onTabSelected at "+ "position"+tab.getPosition()+" name" + tab.getText());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        //Log.d("Tabs", " onTabUnselected at "+ "position"+tab.getPosition()+" name" + tab.getText());

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        //Log.d("Tabs", " onTabReselected at "+ "position"+tab.getPosition()+" name" + tab.getText());
    }
}

class MyAdapter extends FragmentPagerAdapter
    //hey, give me the fragment at pos 0
{

    public MyAdapter(FragmentManager fm){
        super(fm);
        Log.d("Arg","vaaaa???");
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=null;
        if(i==0){
            fragment = new Statistics();
            Log.d("Arg","00");
        }
        else if(i==1){
            fragment = new Schedule();
            Log.d("Arg","01");
        }
        else if(i==2){
            fragment = new Statistics();
            Log.d("Arg","02");
        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
package arkbarkberg.rehappilitering;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
//import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.app.Fragment;

public class Schedule extends Fragment {
  public Schedule(){
      //Required empty public constructor
  }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        //Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false);
    }

}

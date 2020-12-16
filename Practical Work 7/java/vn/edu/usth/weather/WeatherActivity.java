package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity {

    PagerAdapter pagerAdapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
//        Log.i("OnCreate","something");

        ViewPager viewPager = (ViewPager) findViewById(R.id.vpager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(pagerAdapter);
//        if( savedInstanceState == null) {
//            WeatherAndForecastFragment weatherAndForecastFragment = new WeatherAndForecastFragment();
//            getSupportFragmentManager().beginTransaction().add(R.id.fragment_parent, weatherAndForecastFragment).commit();
//        }
    }


    @Override
    public void onStart(){
        super.onStart();
        Log.i("OnStart","something");

    }

    @Override
    public void onResume(){
        super.onResume();
        Log.i("OnResume","something");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.i("OnPause","something");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.i("OnStop","something");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.i("OnDestroy","something");
    }
}
package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("OnCreate","something");
//        if( savedInstanceState == null) {
//            ForecastFragment forecastFragment = new ForecastFragment();
//            getSupportFragmentManager().beginTransaction().add(R.id.container, forecastFragment).commit();
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
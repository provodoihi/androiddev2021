package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {

    PagerAdapter pagerAdapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
//        Log.i("OnCreate","something");

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.how_you_like_that);
        mediaPlayer.start();

        //view pager
        ViewPager viewPager = (ViewPager) findViewById(R.id.vpager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

//        if( savedInstanceState == null) {
//            WeatherAndForecastFragment weatherAndForecastFragment = new WeatherAndForecastFragment();
//            getSupportFragmentManager().beginTransaction().add(R.id.fragment_parent, weatherAndForecastFragment).commit();
//        }
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.i("OnStart", "something");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("OnResume", "something");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("OnPause", "something");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("OnStop", "something");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("OnDestroy", "something");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refreshbtt: {
                // create a toast
                Toast.makeText(getApplicationContext(), "Refreshing", Toast.LENGTH_LONG).show();
                return true;
            }
            case R.id.settingbtt:{
                // create a new activity
                Intent intent = new Intent(this,PrefActivity.class);
                startActivity(intent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {

    PagerAdapter pagerAdapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
//
//    final Handler handler = new Handler(Looper.getMainLooper()){
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            String content = msg.getData().getString("server_response");
//            Toast.makeText(getApplicationContext(),content,Toast.LENGTH_LONG).show();
//        }
//    };

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
//                Toast.makeText(getApplicationContext(), "Refreshing", Toast.LENGTH_LONG).show();
//                return true;
//                Thread thread = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//// wait for 5 seconds to simulate a long network access
//                            Thread.sleep(5000);
//                        }
//                        catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//// Assume that we got our data from server
//                        Bundle bundle = new Bundle();
//                        bundle.putString("server_response", "some sample json here");
//// notify main thread
//                        Message msg = new Message();
//                        msg.setData(bundle);
//                        handler.sendMessage(msg);
//                    }
//                });
//                thread.start();
//                return true;

                AsyncTask<String, Integer, Bitmap> task = new AsyncTask<String, Integer, Bitmap>() {
                    @Override
                    protected void onPreExecute() {
                        // do some preparation here, if needed
                    }
                    @Override
                    protected Bitmap doInBackground(String... params) {
                        // This is where the worker thread's code is executed
                        // params are passed from the execute() method call
                        try {
                        // wait for 5 seconds to simulate a long network access
                            Thread.sleep(5000);
                        }
                        catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                    @Override
                    protected void onProgressUpdate(Integer... values) {
                        // This method is called in the main thread, so it's possible
                        // to update UI to reflect the worker thread progress here.
                        // In a network access task, this should update a progress bar
                        // to reflect how many percent of data has been retrieved
                    }
                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        // This method is called in the main thread. After #doInBackground returns
                        // the bitmap data, we simply set it to an ImageView using ImageView.setImageBitmap()
                        Toast.makeText(getApplicationContext(),"some json response here",Toast.LENGTH_LONG).show();
                    }
                };
                task.execute("http://ict.usth.edu.vn/wp-content/uploads/usth/usthlogo.png");
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
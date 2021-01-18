package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

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

//                AsyncTask<String, Integer, Bitmap> task = new AsyncTask<String, Integer, Bitmap>() {
//                    Bitmap bitmap;
//
//                    @Override
//                    protected void onPreExecute() {
//                        // do some preparation here, if needed
//                    }
//
//                    @Override
//                    protected Bitmap doInBackground(String... params) {
//                        // This is where the worker thread's code is executed
//                        // params are passed from the execute() method call
//                        try {
//                            // wait for 5 seconds to simulate a long network access
////                            Thread.sleep(5000);
//                            // initialize URL
//                            URL url = new URL("https://wallpaperboat.com/wp-content/uploads/2020/06/04/42521/blackpink-09-728x410.jpg");
//// Make a request to server
//                            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
//                            connection.setRequestMethod("GET");
//                            connection.setDoInput(true);
//// allow reading response code and response data connection.
//                            connection.connect();
//// Receive response
//                            int response = connection.getResponseCode();
//                            Log.i("USTHWeather", "The response is: " + response);
//                            InputStream is = connection.getInputStream();
//                            bitmap = BitmapFactory.decodeStream(is);
//                            // Process image response
//
//
//                            connection.disconnect();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//
//                        return bitmap;
//                    }
//
//                    @Override
//                    protected void onProgressUpdate(Integer... values) {
//                        // This method is called in the main thread, so it's possible
//                        // to update UI to reflect the worker thread progress here.
//                        // In a network access task, this should update a progress bar
//                        // to reflect how many percent of data has been retrieved
//                    }
//
//                    @Override
//                    protected void onPostExecute(Bitmap bitmap) {
//                        // This method is called in the main thread. After #doInBackground returns
//                        // the bitmap data, we simply set it to an ImageView using ImageView.setImageBitmap()
////                        Toast.makeText(getApplicationContext(),"some json response here",Toast.LENGTH_LONG).show();
//                        ImageView logo = (ImageView) findViewById(R.id.logo);
//                        logo.setImageBitmap(bitmap);
//
//                    }
//                };
//                task.execute("https://wallpaperboat.com/wp-content/uploads/2020/06/04/42521/blackpink-09-728x410.jpg");
//                return true;

                // once, should be performed once per app instance
                RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
// a listener (kinda similar to onPostExecute())
                Response.Listener<Bitmap> listener = new Response.Listener<Bitmap>() {
                            @Override
                            public void onResponse(Bitmap response) {
                                ImageView iv = (ImageView) findViewById(R.id.logo);
                                iv.setImageBitmap(response);
                            }
                        };
// a simple request to the required image
                ImageRequest imageRequest = new ImageRequest("https://wallpaperboat.com/wp-content/uploads/2020/06/04/42521/blackpink-09-728x410.jpg",
                        listener, 0, 0, ImageView.ScaleType.CENTER,
                        Bitmap.Config.ARGB_8888,null);

                String url = "https://api.openweathermap.org/data/2.5/weather?q=Hanoi&units=metric&appid=abf405cfdd1684a27c3c19e86ae79f07";

                StringRequest stringRequest = new StringRequest(Request.Method.GET,url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Log.i("USTHWeather", "Json response " + response);
                                Toast.makeText(getApplicationContext(), "Refreshing", Toast.LENGTH_SHORT).show();
                                JSONObject obj = null;
                                try {
                                    obj = new JSONObject(response);
                                    String city = obj.getString("name");
                                    JSONObject temper = obj.getJSONObject("main");
                                    String temp = temper.getString("temp");
                                    String press = temper.getString("pressure");
                                    String humid = temper.getString("humidity");
//                                    JSONArray condition = obj.getJSONArray("weather");
                                    TextView textView1 = findViewById(R.id.temp);
                                    TextView textView2 = findViewById(R.id.weather);
                                    TextView textView3 = findViewById(R.id.humid);
                                    TextView textView4 = findViewById(R.id.cityy);
                                    textView4.setText("City: "+city);
                                    textView1.setText("Temperature: "+temp+"C");
                                    textView2.setText("Pressure: "+press);
                                    textView3.setText("Humid: "+humid+"%");

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), "Some error occur", Toast.LENGTH_LONG).show();
                            }
                        });
// go!
                queue.add(imageRequest);
                queue.add(stringRequest);
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
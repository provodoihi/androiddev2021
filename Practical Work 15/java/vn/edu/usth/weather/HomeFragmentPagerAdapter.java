package vn.edu.usth.weather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class HomeFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int Page_count = 3;
    private String title[] = new String[] {"Weather Forecast","Weather","Forecast"};

    public HomeFragmentPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        // returns an instance of Fragment corresponding to the specified page
        switch (position){
            case 0: return WeatherAndForecastFragment.newInstance(0,"Page 1");
            case 1: return WeatherFragment.newInstance(1,"Page 2");
            case 2: return ForecastFragment.newInstance(2,"Page 3");
        }
        ;
        return null;
    }

    @Override
    public int getCount() {
        // number of pages for a ViewPager
        return Page_count;
    }

    @Override
    public CharSequence getPageTitle(int position){
        // returns a tab title corresponding to the specified page
        return title[position];
    }
}

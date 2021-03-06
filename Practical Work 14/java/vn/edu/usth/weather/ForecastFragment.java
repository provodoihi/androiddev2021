package vn.edu.usth.weather;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForecastFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private int mParam1;
    private String mParam2;

    public ForecastFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForcastFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForecastFragment newInstance(Integer param1, String param2) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1,0);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


//         Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_forcast, container, false);
//        view.setBackgroundColor(0xff00ffff);
//        return view;
        return inflater.inflate(R.layout.fragment_forcast,container,false);

//        LinearLayout linearLayout = new LinearLayout(getContext());
//        linearLayout.setOrientation(LinearLayout.VERTICAL);

//        TextView textView = new TextView(getContext());
//        textView.setText("Thursday");
//        linearLayout.addView(textView);
//
//        ImageView imageView = new ImageView(getContext());
//        imageView.setImageResource(R.drawable.cloud);
//        linearLayout.addView(imageView);
//
//        return linearLayout;
    }
}
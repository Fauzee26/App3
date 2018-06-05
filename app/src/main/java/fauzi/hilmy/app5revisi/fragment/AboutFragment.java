package fauzi.hilmy.app5revisi.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import fauzi.hilmy.app5revisi.AboutApp;
import fauzi.hilmy.app5revisi.AboutDeveloper;
import fauzi.hilmy.app5revisi.AboutNawawi;
import fauzi.hilmy.app5revisi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends Fragment {


    public AboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_about, container, false);
        // Inflate the layout for this fragment
        ImageButton btnApp = (ImageButton)v.findViewById(R.id.btnApp);
        btnApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutApp = new Intent(getActivity(), AboutApp.class);
                startActivity(aboutApp);
            }
        });
        ImageButton btnDeveloper = (ImageButton)v.findViewById(R.id.btnDeveloper);
        btnDeveloper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abotDeveloper = new Intent(getActivity(), AboutDeveloper.class);
                startActivity(abotDeveloper);
            }
        });
        ImageButton btnNawawi = (ImageButton)v.findViewById(R.id.btnNawawi);
        btnNawawi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent aboutnawawii = new Intent(getActivity(), AboutNawawi.class);
                startActivity(aboutnawawii);
            }
        });
        return v;
//        return inflater.inflate(R.layout.fragment_about, container, false);
    }

}

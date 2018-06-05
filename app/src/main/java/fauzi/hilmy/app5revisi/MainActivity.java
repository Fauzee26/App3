package fauzi.hilmy.app5revisi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.widget.FrameLayout;

import fauzi.hilmy.app5revisi.fragment.AboutFragment;
import fauzi.hilmy.app5revisi.fragment.HadisFragment;
import fauzi.hilmy.app5revisi.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view = findViewById(R.id.navigation);
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                android.support.v4.app.Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.mHome:
                        // Put Intent Here
//                        selectedFragment = new HomeFragment();
                        Intent a11 = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(a11);
                        finish();
                        break;
                    case R.id.mHadis:
                        // Put Intent Here
//                        selectedFragment = new HadisFragment();
                        FrameLayout idLayout2 = (FrameLayout) findViewById(R.id.frame_layout);
                        idLayout2.removeAllViews();
                        HadisFragment fragment2 = new HadisFragment();
                        FragmentManager fragmentManager2 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                        fragmentTransaction2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction2.replace(R.id.frame_layout, fragment2);
                        fragmentTransaction2.addToBackStack(null);
                        fragmentTransaction2.commit();
                        break;
                    case R.id.mAbout:
                        // Put Intent Here
                        FrameLayout idLayout1 = (FrameLayout) findViewById(R.id.frame_layout);
                        idLayout1.removeAllViews();
                        AboutFragment fragment1 = new AboutFragment();
                        FragmentManager fragmentManager1 = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                        fragmentTransaction1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                        fragmentTransaction1.replace(R.id.frame_layout, fragment1);
                        fragmentTransaction1.addToBackStack(null);
                        fragmentTransaction1.commit();
//                        return true;
//                        selectedFragment = new AboutFragment();
                        break;
                }
//                android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.support, selectedFragment);
//                transaction.commit();
                return true;
            }
        });
//        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.support, HomeFragment.newInstance());
//        transaction.commit();
    }
}

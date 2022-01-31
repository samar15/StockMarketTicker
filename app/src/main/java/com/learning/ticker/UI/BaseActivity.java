package com.learning.ticker.UI;

import android.view.View;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.learning.ticker.R;

public class BaseActivity extends AppCompatActivity {

    FrameLayout frameLayout;
    public void addFragment(Fragment fragment , int containerViewId){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(containerViewId,fragment);
        fragmentTransaction.commit();
    }
    public void replaceFragment(Fragment fragment , int containerViewId){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(containerViewId,fragment);
        fragmentTransaction.commit();
    }

    public void removeFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.remove(fragment);
        fragmentTransaction.commit();
    }
    @Override
    public void onBackPressed() {
        View view = findViewById(R.id.fragment_container);
        Fragment fragment = FragmentManager.findFragment(view);
        if(fragment instanceof SummaryFragment ){
            removeFragment(fragment);
        }else {
            super.onBackPressed();
        }
    }
}

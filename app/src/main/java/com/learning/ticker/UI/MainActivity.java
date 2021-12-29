package com.learning.ticker.UI;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.learning.ticker.R;

public class MainActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragment(new HomeFragment(), R.id.fragment_container);
    }
}

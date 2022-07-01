package com.example.tugassesi3.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.tugassesi3.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tablayout);
        viewPager2 = findViewById(R.id.viewpager);

        setViewPager2(viewPager2);
        new TabLayoutMediator(tabLayout, viewPager2, ((tab, position)-> {
            tab.setText(pageAdapter.getFragmentTitle(position));
        })).attach();
    }

    private void setViewPager2(ViewPager2 viewPager2){
        if(pageAdapter == null){
            pageAdapter = new PageAdapter(this);
            pageAdapter.addFragment(new GreetingsFragment(), "Home");
            pageAdapter.addFragment(new ItemFragment(), "Items");
            viewPager2.setAdapter(pageAdapter);
        }
    }
}
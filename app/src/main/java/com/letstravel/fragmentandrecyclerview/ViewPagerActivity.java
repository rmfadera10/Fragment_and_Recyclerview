package com.letstravel.fragmentandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import adapter.ViewPagerAdapter;
import fragment.LoginFragment;
import fragment.SignupFragment;

public class ViewPagerActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPagers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        tabLayout=findViewById(R.id.tablayoyt);
        viewPagers=findViewById(R.id.viewPager);


        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
        ViewPagerAdapter viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new LoginFragment(),"LOGIN");
        viewPagerAdapter.addFragment(new SignupFragment(),"SIGNUP");


        viewPagers.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPagers);
    }
}

package com.riseofash.innerworkindia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    IntroViewPageAdapter introViewPageAdapter;
    List<ScreenItem> mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        mList=new ArrayList<>();
        mList.add(new ScreenItem("Search Schools","Search for your child school among the list of schools where Wayezi provides its invaluable services",R.drawable.searchschool));
        mList.add(new ScreenItem("Compare Schools","Compare facilities provided by schools where Wayezi provides its services",R.drawable.compareschool));
        mList.add(new ScreenItem("Live Streaming","View the live streaming of the camera from the bus in which your child is travelling",R.drawable.livestream));
        mList.add(new ScreenItem("Chat Box","Chat with other parents whose child travel in the same bus as your child",R.drawable.chatroom));
        mList.add(new ScreenItem("Bus Tracking","Track the current location of the bus",R.drawable.currentlocation));
        mList.add(new ScreenItem("School Fees Payment","Pay your child school fees",R.drawable.schoolfees));
        mList.add(new ScreenItem("Meeting","Hold a video call meeting with parents of other child to have important discussion",R.drawable.meeting));
        mList.add(new ScreenItem("Delivery","",R.drawable.delivery));

        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewPager);
        introViewPageAdapter=new IntroViewPageAdapter(this,mList);
        viewPager.setAdapter(introViewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
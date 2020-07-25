package com.riseofash.innerworkindia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    IntroViewPageAdapter introViewPageAdapter;
    List<ScreenItem> mList;
    int position=0;
    Button next,prev,skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        next=findViewById(R.id.next);
        prev=findViewById(R.id.prev);
        skip=findViewById(R.id.skip);

        tabLayout=findViewById(R.id.tablayout);
        viewPager=findViewById(R.id.viewPager);
        mList=new ArrayList<>();
        mList.add(new ScreenItem("Search Schools","Search for your child school among the list of schools where Wayezi provides its invaluable services",R.drawable.searchschool));
        mList.add(new ScreenItem("Compare Schools","Compare facilities provided by schools where Wayezi provides its services",R.drawable.compareschool));
        mList.add(new ScreenItem("Live Streaming","View the live streaming of the camera from the bus in which your child is travelling",R.drawable.livestream));
        mList.add(new ScreenItem("Chat Box","Chat with other parents whose child travel in the same bus as your child",R.drawable.chatroom));
        mList.add(new ScreenItem("Bus Tracking","Track the current location of the bus",R.drawable.currentlocation));
        mList.add(new ScreenItem("School Fees Payment","Pay your child school fees",R.drawable.schoolfees));
        mList.add(new ScreenItem("Meeting","Hold a video call meeting with parents of other child to have important discussion",R.drawable.meeting));
        mList.add(new ScreenItem("Delivery","Get your Child's Books and School Uniform deivered to your home",R.drawable.delivery));
        introViewPageAdapter=new IntroViewPageAdapter(this,mList);
        viewPager.setAdapter(introViewPageAdapter);
        tabLayout.setupWithViewPager(viewPager);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position=viewPager.getCurrentItem();
                if(position<mList.size()){
                    position++;
                    if(position<8){
                        viewPager.setCurrentItem(position);
                    }
                    else{
                        startActivity(new Intent(MainActivity.this,HomePage.class));
                    }
                }
            }
        });
        prev.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                position=viewPager.getCurrentItem();
                if(position<8){
                    position--;
                    viewPager.setCurrentItem(position);
                }
            }
        });
        skip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,HomePage.class));
            }
        });


    }

}
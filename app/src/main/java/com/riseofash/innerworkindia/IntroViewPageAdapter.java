package com.riseofash.innerworkindia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class IntroViewPageAdapter extends PagerAdapter {

    Context context;
    List<ScreenItem> screenItemList;

    TextView title,desc;
    ImageView img;

    public IntroViewPageAdapter(Context context, List<ScreenItem> screenItemList) {
        this.context = context;
        this.screenItemList = screenItemList;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<ScreenItem> getScreenItemList() {
        return screenItemList;
    }

    public void setScreenItemList(List<ScreenItem> screenItemList) {
        this.screenItemList = screenItemList;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layoutScreen=layoutInflater.inflate(R.layout.layout_screen,null);

        title=layoutScreen.findViewById(R.id.title);
        desc=layoutScreen.findViewById(R.id.desc);
        img=layoutScreen.findViewById(R.id.image);

        title.setText(screenItemList.get(position).getTitle());
        desc.setText(screenItemList.get(position).getDesc());
        img.setImageResource(screenItemList.get(position).getScreenimg());
        container.addView(layoutScreen);
        return layoutScreen;
    }

    @Override
    public int getCount() {
        return screenItemList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}

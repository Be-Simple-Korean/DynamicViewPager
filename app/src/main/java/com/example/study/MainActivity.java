package com.example.study;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {
    ArrayList<Fragment> far=null;
    ViewPager vp;
    FragmentPagerAdapter fp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        far=new ArrayList<>();
        far.add(new BaseFragment("1"));
        far.add(new BaseFragment("2"));
        far.add(new BaseFragment("3"));
        far.add(new BaseFragment("4"));
        far.add(new BaseFragment("5"));
        vp=findViewById(R.id.vp);
        CircleIndicator indicator = (CircleIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(vp);
        indicator.createIndicators(11,0);
        indicator.animatePageSelected(0);
        fp=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return far.get(position);
            }

            @Override
            public int getCount() {
                return far!=null?far.size():0;
            }
        };
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                indicator.animatePageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        fp.registerDataSetObserver(indicator.getDataSetObserver());
        vp.setAdapter(fp);
    }

}
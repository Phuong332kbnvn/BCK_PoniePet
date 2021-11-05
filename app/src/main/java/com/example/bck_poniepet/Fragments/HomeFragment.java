package com.example.bck_poniepet.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.bck_poniepet.Adapters.PhotoNewsViewPagerAdapter;
import com.example.bck_poniepet.Objects.PhotoNews;
import com.example.bck_poniepet.R;
import com.example.bck_poniepet.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (binding.vpNews.getCurrentItem() == getListPhotoNews().size()-1)
                binding.vpNews.setCurrentItem(0);
            else
                binding.vpNews.setCurrentItem(binding.vpNews.getCurrentItem()+1);
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);

        PhotoNewsViewPagerAdapter photoNewsViewPagerAdapter = new PhotoNewsViewPagerAdapter(getListPhotoNews());
        binding.vpNews.setAdapter(photoNewsViewPagerAdapter);
        binding.circleIndicator.setViewPager(binding.vpNews);

        handler.postDelayed(runnable,3000);
        binding.vpNews.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                handler.removeCallbacks(runnable);
                handler.postDelayed(runnable,3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return binding.getRoot();
    }

    private List<PhotoNews> getListPhotoNews(){
        List<PhotoNews> list = new ArrayList<>();
        list.add(new PhotoNews(R.drawable.img1));
        list.add(new PhotoNews(R.drawable.img2));
        list.add(new PhotoNews(R.drawable.img3));
        list.add(new PhotoNews(R.drawable.img4));
        return list;
    }


    @Override
    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        handler.postDelayed(runnable,3000);
    }
}

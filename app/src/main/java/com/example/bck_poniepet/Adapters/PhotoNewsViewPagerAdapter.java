package com.example.bck_poniepet.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.bck_poniepet.Objects.PhotoNews;
import com.example.bck_poniepet.R;

import java.util.List;

public class PhotoNewsViewPagerAdapter extends PagerAdapter {
    private List<PhotoNews> list;

    public PhotoNewsViewPagerAdapter(List<PhotoNews> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_photonews,container,false);
        ImageView imageView = view.findViewById(R.id.ivItemPhotonews);
        PhotoNews photoNews = list.get(position);
        imageView.setImageResource(photoNews.getResourceId());
        container.addView(view);
        return view;
    }

    @Override
    public int getCount() {
        if (list!= null)
            return list.size();
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}

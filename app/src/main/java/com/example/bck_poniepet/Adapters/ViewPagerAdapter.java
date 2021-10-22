package com.example.bck_poniepet.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.bck_poniepet.Fragments.BlogFragment;
import com.example.bck_poniepet.Fragments.HomeFragment;
import com.example.bck_poniepet.Fragments.NotificationFragment;
import com.example.bck_poniepet.Fragments.ProfileFragment;
import com.example.bck_poniepet.Fragments.ShoppingFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new ShoppingFragment();
            case 2:
                return new BlogFragment();
            case 3:
                return new NotificationFragment();
            case 4:
                return new ProfileFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}

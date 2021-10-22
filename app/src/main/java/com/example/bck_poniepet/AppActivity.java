package com.example.bck_poniepet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.bck_poniepet.Adapters.ViewPagerAdapter;
import com.example.bck_poniepet.databinding.ActivityAppBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AppActivity extends AppCompatActivity {
    ActivityAppBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_app);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_app);

        setUpViewPager();
        binding.bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        binding.viewPager.setCurrentItem(0);
                        break;
                    case R.id.navigation_shopping:
                        binding.viewPager.setCurrentItem(1);
                        break;
                    case R.id.navigation_blog:
                        binding.viewPager.setCurrentItem(2);
                        break;
                    case R.id.navigation_notification:
                        binding.viewPager.setCurrentItem(3);
                        break;
                    case R.id.navigation_profile:
                        binding.viewPager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });
    }
    private void setUpViewPager(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPager.setAdapter(viewPagerAdapter);
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        binding.bottomNav.getMenu().findItem(R.id.navigation_home).setChecked(true);
                        break;
                    case 1:
                        binding.bottomNav.getMenu().findItem(R.id.navigation_shopping).setChecked(true);
                        break;
                    case 2:
                        binding.bottomNav.getMenu().findItem(R.id.navigation_blog).setChecked(true);
                        break;
                    case 3:
                        binding.bottomNav.getMenu().findItem(R.id.navigation_notification).setChecked(true);
                        break;
                    case 4:
                        binding.bottomNav.getMenu().findItem(R.id.navigation_profile).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
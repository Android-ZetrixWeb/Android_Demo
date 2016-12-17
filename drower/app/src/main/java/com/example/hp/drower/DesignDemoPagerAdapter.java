package com.example.hp.drower;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by hp on 08-12-2016.
 */

public class DesignDemoPagerAdapter extends FragmentStatePagerAdapter {
    public DesignDemoPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return BlankFragment.newInstance(position);
        } else if (position == 1) {
            return BlankFragment1.newInstance();
        } else if (position == 2) {
            return BlankFragment2.newInstance();
        }
        return BlankFragment.newInstance(position);
    }


    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "Home";
        } else if (position == 1) {
            return "SingUp";
        } else if (position == 2) {
            return "LogIn";
        }
        return "Activity" + position;
    }
}
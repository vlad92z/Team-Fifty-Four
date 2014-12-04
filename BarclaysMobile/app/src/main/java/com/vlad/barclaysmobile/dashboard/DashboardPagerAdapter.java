package com.vlad.barclaysmobile.dashboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

// Since this is an object collection, use a FragmentStatePagerAdapter,
// and NOT a FragmentPagerAdapter.
public class DashboardPagerAdapter extends FragmentStatePagerAdapter {
    public DashboardPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment;
        switch (i) {
            case 0:
                
                fragment = new DashboardTransactionFragment();
                break;
            case 1:
                fragment = new DashboardCategoryFragment();
                break;
            case 2:
                fragment = new DashboardTransactionFragment();
                break;
            default:
                fragment = new DashboardTransactionFragment();
                break;
        }
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(DashboardTransactionFragment.ID, i + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        FragmentName fragment = (FragmentName) getItem(position);
        return fragment.getName();
    }
}

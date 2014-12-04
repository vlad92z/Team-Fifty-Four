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
        Fragment fragment = new DashboardStatementFragment();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(DashboardStatementFragment.ID, i + 1);
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

package com.vlad.barclaysmobile.adventure;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.vlad.barclaysmobile.dashboard.DashboardCategoryFragment;
import com.vlad.barclaysmobile.dashboard.DashboardForecastFragment;
import com.vlad.barclaysmobile.dashboard.DashboardTransactionFragment;
import com.vlad.barclaysmobile.dashboard.FragmentName;

// Since this is an object collection, use a FragmentStatePagerAdapter,
// and NOT a FragmentPagerAdapter.
public class TransactionPagerAdapter extends FragmentStatePagerAdapter {
    public TransactionPagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new TransactionFragment();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(DashboardTransactionFragment.ID, i + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //FragmentName fragment = (FragmentName) getItem(position);
        String[] list = (("December 2014,November 2014,October 2014,September 2014,August 2014,July 2014" +
                ",June 2014,May 2014,April 2014,March 2014,February 2014,January 2014").split(","));
        return list[11-position];
    }
}

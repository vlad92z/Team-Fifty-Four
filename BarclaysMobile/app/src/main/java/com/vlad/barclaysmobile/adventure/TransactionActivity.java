package com.vlad.barclaysmobile.adventure;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.vlad.barclaysmobile.R;
import com.vlad.barclaysmobile.dashboard.DashboardPagerAdapter;
import com.vlad.barclaysmobile.dashboard.DashboardTransactionFragment;
import com.vlad.barclaysmobile.utils.Utils;

public class TransactionActivity extends FragmentActivity implements DashboardTransactionFragment.OnFragmentInteractionListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;
    TransactionPagerAdapter transactionAdapter;
    ViewPager transactionPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        transactionAdapter =
                new TransactionPagerAdapter(
                        getSupportFragmentManager());
        transactionPager = (ViewPager) findViewById(R.id.transaction_pager);
        transactionPager.setAdapter(transactionAdapter);
        transactionPager.setCurrentItem(transactionAdapter.getCount() - 1);

        setupActionBar();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.string.drawer_open, R.string.drawer_close) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu()
            }
        };

        // Set the drawer toggle as the DrawerListener
        mDrawerLayout.setDrawerListener(mDrawerToggle);
       mDrawerList = (ListView) findViewById(R.id.left_drawer);
        // Set the adapter for the list view
        mDrawerList.setAdapter(new MenuAdapter(this));
        // Set the list's click listener
        Utils.setMenuListener(mDrawerList, this);

        /** initializing the actual adventure activity views*/


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * sets up the action bar with a custom view and changes its font
     */
    private void setupActionBar() {
        ActionBar ab = getActionBar();
        ab.setDisplayShowCustomEnabled(true);
        ab.setDisplayShowTitleEnabled(false);
        ab.setIcon(R.drawable.abc_ic_menu_moreoverflow_mtrl_alpha);
        LayoutInflater inflator = (LayoutInflater) this
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflator.inflate(R.layout.actionbar, null);

        TextView titleTV = (TextView) v.findViewById(R.id.title);
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Baker.ttf");
        titleTV.setTypeface(tf);

        ab.setCustomView(v);

        //ab.setDisplayHomeAsUpEnabled(false);
        ab.setHomeButtonEnabled(true);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

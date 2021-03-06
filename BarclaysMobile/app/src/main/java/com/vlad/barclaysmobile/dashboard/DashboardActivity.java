package com.vlad.barclaysmobile.dashboard;

import android.app.ActionBar;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.vlad.barclaysmobile.adventure.MenuAdapter;
import com.vlad.barclaysmobile.R;
import com.vlad.barclaysmobile.utils.Utils;

public class DashboardActivity extends FragmentActivity implements DashboardTransactionFragment.OnFragmentInteractionListener{

    // When requested, this adapter returns a DemoObjectFragment,
    // representing an object in the collection.
    DashboardPagerAdapter dashboardAdapter;
    ViewPager dashboardPager;

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //todo setup fragments
        // ViewPager and its adapters use support library
        // fragments, so use getSupportFragmentManager.
        dashboardAdapter =
                new DashboardPagerAdapter(
                        getSupportFragmentManager());
        dashboardPager = (ViewPager) findViewById(R.id.dashboard_pager);
        dashboardPager.setAdapter(dashboardAdapter);



        setupActionBar();


        mDrawerLayout = (DrawerLayout) findViewById(R.id.dashboard_drawer_layout);
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


        mDrawerList = (ListView) findViewById(R.id.dashboard_left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new MenuAdapter(this));
        // Set the list's click listener
        Utils.setMenuListener(mDrawerList, this);


        //app code
        setBalance();


    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    //deals with the slide out drawer clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //todo
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

        ab.setDisplayHomeAsUpEnabled(false);
        ab.setHomeButtonEnabled(true);
    }

    private void setBalance(){
        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/Baker.ttf");
        TextView title = (TextView) findViewById(R.id.dahsboard_current_account_label);
        TextView number = (TextView) findViewById(R.id.dashboard_account_number);
        TextView balance = (TextView) findViewById(R.id.dashboard_balance);
        TextView overdraft = (TextView) findViewById(R.id.dashboard_overdraft_limit);
        TextView budget = (TextView) findViewById(R.id.dashboard_remaining_budget);
        title.setTypeface(tf);
        number.setTypeface(tf);
        balance.setTypeface(tf);
        overdraft.setTypeface(tf);
        budget.setTypeface(tf);
        PagerTitleStrip titleStrip = (PagerTitleStrip) findViewById(R.id.pager_title_strip);
        for (int counter = 0 ; counter<titleStrip.getChildCount(); counter++) {

            if (titleStrip.getChildAt(counter) instanceof TextView) {
                ((TextView) titleStrip.getChildAt(counter)).setTypeface(tf);
                ((TextView)titleStrip.getChildAt(counter)).setTextSize(25);
            }
        }
        number.setText("00-00-00 | 8348425");
        balance.setText("Balance: £500.89");
        overdraft.setText("Overdraft Limit: £200");
        budget.setText("Remaining Budget: £301.52");
    }
}

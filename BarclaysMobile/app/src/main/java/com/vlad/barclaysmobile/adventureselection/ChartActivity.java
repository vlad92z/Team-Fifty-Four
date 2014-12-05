package com.vlad.barclaysmobile.adventureselection;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import com.vlad.barclaysmobile.R;
import com.vlad.barclaysmobile.adventure.TransactionActivity;
import com.vlad.barclaysmobile.adventure.MenuAdapter;
import com.vlad.barclaysmobile.dashboard.DashboardTransactionFragment;
import com.vlad.barclaysmobile.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;

public class ChartActivity extends Activity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charts);
        setupActionBar();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.object_drawer_layout);
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


        mDrawerList = (ListView) findViewById(R.id.object_left_drawer);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new MenuAdapter(this));
        // Set the list's click listener
        Utils.setMenuListener(mDrawerList, this);


//                "http://mobilebanking.elasticbeanstalk.com/piechart", "{\"data\":[[\"category\", \"value\"]," +
//                "[\"cat1\", 10],[\"cat2\", 20],[\"cat3\", 30],[\"cat4\", 40],[\"cat5\", 50]]}", new Response.Listener() {


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

}

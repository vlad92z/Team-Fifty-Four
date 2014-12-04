package com.vlad.barclaysmobile.adventure;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vlad.barclaysmobile.R;
import com.vlad.barclaysmobile.utils.UserManager;
import com.vlad.barclaysmobile.utils.Utils;

/**
 * Created by Vladislavs on 06/11/2014.
 * This is the slide-out menu adapter
 * All the data here is hardcoded as it doesn't change throughout the app
 */
public class MenuAdapter extends BaseAdapter {
    private String[] menuTitles;
    private LayoutInflater inflater;
    private Activity activity;

    public MenuAdapter(Activity activity) {
        menuTitles = "Dashboard,Charts,Transactions,Forecast,Budget Management,Help Section,Go To Browser,Contact Us".split(",");
        this.activity = activity;

    }

    @Override
    public int getCount() {
        return menuTitles.length + 1;
    }

    @Override
    public Object getItem(int position) {
        return menuTitles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater.from(parent.getContext()));
        if (position == 0) {
            convertView = inflater.inflate(R.layout.slideout_menu_top, parent, false);
            TextView username = (TextView) convertView.findViewById(R.id.adventure_user_name);
            username.setText(UserManager.getInstance().getUser().getFirstName() +
                    " " + UserManager.getInstance().getUser().getLastName());
            username.setTypeface(Utils.getBakerTypeface(activity));
            return convertView;
        } else {
            convertView = inflater.inflate(R.layout.row_slideout_menu, parent, false);
            TextView option = (TextView) convertView.findViewById(R.id.menu_item_title);
            option.setText(menuTitles[position-1]);
            option.setTypeface(Utils.getBakerTypeface(activity));
            return convertView;
        }
    }
}

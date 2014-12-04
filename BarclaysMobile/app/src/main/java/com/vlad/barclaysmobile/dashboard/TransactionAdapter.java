package com.vlad.barclaysmobile.dashboard;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vlad.barclaysmobile.R;
import com.vlad.barclaysmobile.utils.Utils;

/**
 * Created by Vladislavs on 06/11/2014.
 */
public class TransactionAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ViewHolder viewHolder;
    private Activity activity;

    public TransactionAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public String getItem(int position) {
        return "";//tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // View rowView = convertView;

        if (convertView == null) {
            inflater = (LayoutInflater.from(parent.getContext()));
            convertView = inflater.inflate(R.layout.row_transaction, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.balance = (TextView) convertView.findViewById(R.id.transaction_balance);
            viewHolder.date = (TextView) convertView.findViewById(R.id.transaction_date);
            viewHolder.description = (TextView) convertView.findViewById(R.id.transaction_description);
            Typeface tf = Utils.getBakerTypeface(activity);
            viewHolder.balance.setTypeface(tf);
            viewHolder.date.setTypeface(tf);
            viewHolder.description.setTypeface(tf);
            viewHolder.position = position;
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.description.setText("get description for transaction".toUpperCase());
        viewHolder.date.setText("15/11");
        viewHolder.balance.setText("-£54.02");

        viewHolder.position = position;
        return convertView;

    }

    static class ViewHolder {
        TextView date;
        TextView description;
        TextView balance;
        int position;
    }
}

package com.vlad.barclaysmobile.dashboard;

import android.app.Activity;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ListView;
import android.widget.TextView;

import com.vlad.barclaysmobile.R;
import com.vlad.barclaysmobile.utils.Utils;

/**
 * Adventure fragment
 */
public class DashboardTransactionFragment extends android.support.v4.app.Fragment implements FragmentName {
    public static final String ID = "param1";
    public static final String PROGRESS = "param2";

    private OnFragmentInteractionListener mListener;

    public DashboardTransactionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
//            adventureId = getArguments().getString(ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_transaction, container, false);
    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        ListView listView = (ListView) getView().findViewById(R.id.statement_transations);
        listView.setAdapter(new TransactionAdapter(getActivity()));

        Typeface tf = Utils.getBakerTypeface(getActivity());
        ((TextView) view.findViewById(R.id.date_label)).setTypeface(tf);
        ((TextView) view.findViewById(R.id.balance_label)).setTypeface(tf);
        ((TextView) view.findViewById(R.id.description_label)).setTypeface(tf);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }


    public String getName(){
        return "Statement";
    }

}

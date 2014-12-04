package com.vlad.barclaysmobile.dashboard;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.GridView;

import com.vlad.barclaysmobile.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DashboardTransactionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DashboardCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardCategoryFragment extends android.support.v4.app.Fragment implements FragmentName {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String USER_ID = "param1";

    // TODO: Rename and change types of parameters
    private String userId;

    private DashboardTransactionFragment.OnFragmentInteractionListener mListener;

    private GridView recommendations;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param uId Parameter 1.
     * @return A new instance of fragment DashboardRecommendFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardCategoryFragment newInstance(String uId) {
        DashboardCategoryFragment fragment = new DashboardCategoryFragment();
        Bundle args = new Bundle();
//        args.putString(USER_ID, uId);
        fragment.setArguments(args);
        return fragment;
    }

    public DashboardCategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            userId = getArguments().getString(USER_ID);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard_category, container, false);


    }

    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // initialise your views
        WebView webView = (WebView) view.findViewById(R.id.pie_chart_webview);
        webView.loadUrl("http://mobilebanking.elasticbeanstalk.com/piechart");

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
            mListener = (DashboardTransactionFragment.OnFragmentInteractionListener) activity;
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

    @Override
    public String getName() {
        return "Expenses";
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
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        public void onFragmentInteraction(Uri uri);
//    }

}

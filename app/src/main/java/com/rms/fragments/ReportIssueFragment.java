package com.rms.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rms.R;

/**
 * Created by Ashish on 9/13/2016.
 */
public class ReportIssueFragment extends Fragment {

    public static ReportIssueFragment newInstance(){
        Bundle bundle = new Bundle();
        ReportIssueFragment fragment = new ReportIssueFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.report_issue_view,null);
        return view;
    }
}

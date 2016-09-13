package com.rms.fragments;

import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.rms.R;

/**
 * Created by Ashish on 9/13/2016.
 */
public class CreateEventFragment extends Fragment {

    private Spinner spinner;
    private String[] strings = {"Anniversary","Birthday","Festival","Social Event","Marriage","Engagment","Other"};

    public CreateEventFragment(){

    }

    public static CreateEventFragment newInstance(){
        Bundle bundle = new Bundle();
        CreateEventFragment fragment = new CreateEventFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.create_event_view,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner = (Spinner)view.findViewById(R.id.spinnerEventSelector);

    }
}

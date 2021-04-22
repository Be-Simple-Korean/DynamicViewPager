package com.example.study;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BaseFragment extends Fragment {
    private String text="";
    public BaseFragment(String text) {
        this.text=text;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_base, container, false);
        TextView tv =v.findViewById(R.id.text);
        tv.setText(text);
        return v;
    }
}
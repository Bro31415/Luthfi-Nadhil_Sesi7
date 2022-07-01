package com.example.tugassesi3.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tugassesi3.R;


public class ItemFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_item, container, false);


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentFrag = new Intent(getContext(), MainActivity2.class);
                startActivity(intentFrag);
            }
        };

        Button pick = (Button) view.findViewById(R.id.btnTeamPick);
        pick.setOnClickListener(listener);


        return view;
    }
}
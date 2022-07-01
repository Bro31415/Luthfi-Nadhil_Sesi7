package com.example.tugassesi3.view;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tugassesi3.R;


public class GreetingsFragment extends Fragment {

    TextView username;
    Button logout;
    AlertDialog confirm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View a = inflater.inflate(R.layout.fragment_greetings, container, false);
        username = a.findViewById(R.id.tvuname);
        logout = a.findViewById(R.id.btnlogout);

        Intent intent = getActivity().getIntent();
        String tempUsername = intent.getStringExtra("account_username");

        username.setText(tempUsername);
        Intent logoutIntent = new Intent(getActivity(), LoginActivity.class);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Confirmation").setMessage("Do you want to logout?").setPositiveButton("Yes, log me out", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(logoutIntent);
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                confirm.dismiss();
            }
        });
        confirm = builder.create();

        logout.setOnClickListener(v -> {
            confirm.show();
        });

        return a;

    }




}
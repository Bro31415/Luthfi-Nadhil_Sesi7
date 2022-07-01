package com.example.tugassesi3.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.tugassesi3.databinding.ActivityOfflineBinding;
import com.example.tugassesi3.remote.TeamsItem;


public class OfflineActivity extends AppCompatActivity {

    private ActivityOfflineBinding mBinding;

    private OfflineViewModel mOfflineViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityOfflineBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mOfflineViewModel = new OfflineViewModel(getApplication());

        mBinding.rvteams.setLayoutManager(new LinearLayoutManager(this));
        mOfflineViewModel.getOfflineData().observe(this, TeamsItem -> {
            mBinding.rvteams.setAdapter(new TeamsAdapter(TeamsItem));
        });


    }
}
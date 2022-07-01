package com.example.tugassesi3.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.example.tugassesi3.databinding.ActivityMainBinding;
import com.example.tugassesi3.remote.TeamsItem;
import com.example.tugassesi3.view.MainViewModel;
import com.example.tugassesi3.view.MainViewModelFactory;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    private MainViewModel mMainViewModel;

    private TeamsAdapter mTeamsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mMainViewModel = new ViewModelProvider(this,
                new MainViewModelFactory(getApplication())
        ).get(MainViewModel.class);

        mMainViewModel.callApi();

        mBinding.rvteams.setLayoutManager(new LinearLayoutManager(this));
        mMainViewModel.getTeamsItems().observe(this, TeamsItem -> {
            mTeamsAdapter = new TeamsAdapter(TeamsItem);
            mTeamsAdapter.setOnItemClickCallback(new TeamsAdapter.OnItemClickCallback() {
                @Override
                public void onInsertClick(TeamsItem TeamItem) {
                    mMainViewModel.insertItem(TeamItem);
                }
            });
            mBinding.rvteams.setAdapter(new TeamsAdapter(TeamsItem));
        });

        mBinding.btnOfflineMode.setOnClickListener(view ->
                startActivity(new Intent( MainActivity2.this, OfflineActivity.class)));

    }
}
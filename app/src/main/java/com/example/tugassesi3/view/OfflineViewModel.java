package com.example.tugassesi3.view;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.tugassesi3.remote.TeamsItem;
import com.example.tugassesi3.repo.TeamsRepo;

import java.util.List;

public class OfflineViewModel extends ViewModel {

    private TeamsRepo mTeamsRepo;

    public OfflineViewModel(Application application){
        mTeamsRepo = new TeamsRepo(application);
    }

    public LiveData<List<TeamsItem>> getOfflineData(){
        return mTeamsRepo.getItems();
    }

}

package com.example.tugassesi3.view;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tugassesi3.repo.TeamsRepo;
import com.example.tugassesi3.remote.ApiConfig;
import com.example.tugassesi3.remote.ApiService;
import com.example.tugassesi3.remote.TeamsItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private TeamsRepo mTeamsRepo;

    public MainViewModel(Application application) {
        mTeamsRepo = new TeamsRepo(application);
    }

    private MutableLiveData<List<TeamsItem>> _teamsitem = new MutableLiveData<>();

    public LiveData<List<TeamsItem>> getTeamsItems() {
        return _teamsitem;
    }

    private final ApiService mApiService = ApiConfig.getApiService();

    public void callApi() {
        mApiService.getTeams().enqueue(new Callback<List<TeamsItem>>() {
            @Override
            public void onResponse(Call<List<TeamsItem>> call, Response<List<TeamsItem>> response) {
                if (response.isSuccessful()) {
                    _teamsitem.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<TeamsItem>> call, Throwable t) {

            }
        });
    }

    public void insertItem(TeamsItem teamItem) {
        mTeamsRepo.insert(teamItem);
    }
}

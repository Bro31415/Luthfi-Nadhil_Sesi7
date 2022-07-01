package com.example.tugassesi3.repo;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.tugassesi3.local.TeamsDao;
import com.example.tugassesi3.local.TeamRoomDB;
import com.example.tugassesi3.remote.TeamsItem;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TeamsRepo {
    private final TeamsDao mTeamsDao;
    private final ExecutorService mExecutorService;

    public TeamsRepo(Application application) {
        mExecutorService = Executors.newSingleThreadExecutor();
        TeamRoomDB db = TeamRoomDB.getDatabase(application);
        mTeamsDao = db.mTeamsDao();
    }

    public LiveData<List<TeamsItem>> getItems() {
        return mTeamsDao.getTeams();
    }

    // synchronous -> UI thread
    public void insert(final TeamsItem teamsItem) {
        mExecutorService.execute(() -> {
            mTeamsDao.insert(teamsItem);
        });
    }

}

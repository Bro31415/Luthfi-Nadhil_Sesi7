package com.example.tugassesi3.local;

import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Dao;

import com.example.tugassesi3.remote.TeamsItem;

import java.util.List;

@Dao
public interface TeamsDao {

    @Insert
    void insert(TeamsItem teamsItem);

    @Query("SELECT * from TeamsItem")
    LiveData<List<TeamsItem>> getTeams();

}

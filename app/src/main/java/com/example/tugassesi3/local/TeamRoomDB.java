package com.example.tugassesi3.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tugassesi3.remote.TeamsItem;

@Database(entities = {TeamsItem.class}, version = 1)
public abstract class TeamRoomDB extends RoomDatabase {
    public abstract TeamsDao mTeamsDao();

    public TeamRoomDB() {
    }

    private static TeamRoomDB INSTANCE;

    public static TeamRoomDB getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TeamRoomDB.class) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        TeamRoomDB.class,
                        "team_db").build();
            }
        }
        return INSTANCE;
    }
}

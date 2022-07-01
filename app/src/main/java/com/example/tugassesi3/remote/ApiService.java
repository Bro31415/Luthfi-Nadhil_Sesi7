package com.example.tugassesi3.remote;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.Call;

public interface ApiService {
    @GET("f1_teams")
    Call<List<TeamsItem>>getTeams();
}

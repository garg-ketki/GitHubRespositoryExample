package com.example.beautifulcode.data.remote.service;

import com.example.beautifulcode.data.model.api.Repository;

import java.util.ArrayList;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ketkigarg on 20/02/18.
 */

public interface RepoService {
  @GET("users/{user}/repos")
  Single<ArrayList<Repository>> getRepositoryList(@Path("user") String user);
}

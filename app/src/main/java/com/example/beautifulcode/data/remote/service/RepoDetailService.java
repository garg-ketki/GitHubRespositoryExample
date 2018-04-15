package com.example.beautifulcode.data.remote.service;

import com.example.beautifulcode.data.model.api.RepositoryDetail;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ketkigarg on 20/02/18.
 */

public interface RepoDetailService {

  @GET("/repos/{user}/{reponame}")
  Single<RepositoryDetail> getRepositoryDetail(@Path("user") String user,
                                               @Path("reponame") String repoName);
}

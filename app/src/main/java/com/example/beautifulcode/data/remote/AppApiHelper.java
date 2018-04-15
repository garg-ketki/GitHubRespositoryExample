package com.example.beautifulcode.data.remote;

import com.example.beautifulcode.data.model.api.Repository;
import com.example.beautifulcode.data.model.api.RepositoryDetail;
import com.example.beautifulcode.data.remote.service.RepoDetailService;
import com.example.beautifulcode.data.remote.service.RepoService;

import java.util.ArrayList;

import io.reactivex.Single;

/**
 * Created by ketkigarg on 20/02/18.
 */

public class AppApiHelper implements ApiHelper {
  private static AppApiHelper INSTANCE;

  private AppApiHelper() {

  }

  public static AppApiHelper getInstance() {
    if (INSTANCE == null) {
      synchronized (AppApiHelper.class) {
        if (INSTANCE == null) {
          INSTANCE = new AppApiHelper();
        }
      }
    }
    return INSTANCE;
  }

  @Override
  public Single<ArrayList<Repository>> getRepositoryList(String user) {
    return NetworkHelper.getRetrofit().create(RepoService.class).getRepositoryList(user);
  }

  @Override
  public Single<RepositoryDetail> getRepositoryDetail(String user, String repoName) {
    return NetworkHelper.getRetrofit()
        .create(RepoDetailService.class)
        .getRepositoryDetail(user, repoName);
  }
}

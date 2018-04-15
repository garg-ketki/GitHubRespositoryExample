package com.example.beautifulcode.data;

import com.example.beautifulcode.data.model.api.Repository;
import com.example.beautifulcode.data.model.api.RepositoryDetail;
import com.example.beautifulcode.data.remote.ApiHelper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

/**
 * Created by ketkigarg on 20/02/18.
 */

public class AppDataManager implements DataManager {

  private static AppDataManager INSTANCE;
  private ApiHelper apiHelper;

  private AppDataManager() {

  }

  public static AppDataManager getInstance(ApiHelper apiHelper) {
    if (INSTANCE == null) {
      synchronized (AppDataManager.class) {
        if (INSTANCE == null) {
          INSTANCE = new AppDataManager();
          INSTANCE.apiHelper = apiHelper;
        }
      }
    }
    return INSTANCE;
  }

  @Override
  public Single<ArrayList<Repository>> getRepositoryList(String user) {
    return apiHelper.getRepositoryList(user);
  }

  @Override
  public Single<RepositoryDetail> getRepositoryDetail(String user, String repoName) {
    return apiHelper.getRepositoryDetail(user, repoName);
  }
}

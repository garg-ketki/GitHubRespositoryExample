package com.example.beautifulcode.data.remote;

import com.example.beautifulcode.data.model.api.Repository;
import com.example.beautifulcode.data.model.api.RepositoryDetail;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

/**
 * Created by ketkigarg on 20/02/18.
 */

public interface ApiHelper {

  Single<ArrayList<Repository>> getRepositoryList(String user);

  Single<RepositoryDetail> getRepositoryDetail(String user, String repoName);
}

package com.example.beautifulcode.ui.repodetailscreen;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.example.beautifulcode.data.others.CustomRepoDetail;
import com.example.beautifulcode.ui.base.BaseViewModel;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by ketkigarg on 20/02/18.
 */

public class DetailViewModel extends BaseViewModel<DetailNavigator> {

  public CustomRepoDetail repoDetailObservable;
  private MutableLiveData<CustomRepoDetail> customRepoDetailLiveData;

  public DetailViewModel() {
    customRepoDetailLiveData = new MutableLiveData<>();
    repoDetailObservable = new CustomRepoDetail();
  }

  public void getRepoDetails(String user, String repoName) {
    setIsLoading(true);
    addDisposable(getDataManager().getRepositoryDetail(user, repoName)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .map(repositoryDetail -> {
          CustomRepoDetail repoDetail = new CustomRepoDetail();
          repoDetail.setName(repositoryDetail.fullName);
          repoDetail.setStars(repositoryDetail.stars);
          repoDetail.setImageUrl(repositoryDetail.owner.imageUrl);
          //repoDetail.setCreatedAt(new Date(repositoryDetail.createdAt));
          return repoDetail;
        })
        .subscribe(response -> {
              Log.v("ketki", "inside onSuccess");
              setIsLoading(false);
              customRepoDetailLiveData.postValue(response);
            },
            error -> {
              setIsLoading(false);
              Log.v("ketki", "inside error");
              getNavigator().handleError(error.getMessage());
            }));
  }

  public MutableLiveData<CustomRepoDetail> getRepoLiveData() {
    return customRepoDetailLiveData;
  }

  public void setCustomRepoDetail(CustomRepoDetail repoDetailObservable) {
    this.repoDetailObservable.setCreatedAt(repoDetailObservable.getCreatedAt());
    this.repoDetailObservable.setImageUrl(repoDetailObservable.getImageUrl());
    this.repoDetailObservable.setStars(repoDetailObservable.getStars());
    this.repoDetailObservable.setName(repoDetailObservable.getName());
  }
}

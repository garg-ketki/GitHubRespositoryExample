package com.example.beautifulcode.ui.repolistscreen;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;

import com.example.beautifulcode.data.model.api.Repository;
import com.example.beautifulcode.ui.base.BaseViewModel;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ketkigarg on 20/02/18.
 */

public class GitRepoListViewModel extends BaseViewModel<GitRepoListNavigator> {

  public MutableLiveData<ArrayList<Repository>> listMutableLiveData;
  public ObservableArrayList<Repository> observableArrayList;

  public GitRepoListViewModel() {
    listMutableLiveData = new MutableLiveData<>();
    observableArrayList = new ObservableArrayList<>();
  }

  public MutableLiveData<ArrayList<Repository>> getListMutableLiveData() {
    return listMutableLiveData;
  }

  public void getRepoList() {
    addDisposable(getDataManager().getRepositoryList("google")
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(list -> listMutableLiveData.postValue(list)));
  }

  public void setObservableArrayList(ArrayList<Repository> list) {
    getNavigator().updateList(list);
  }

}

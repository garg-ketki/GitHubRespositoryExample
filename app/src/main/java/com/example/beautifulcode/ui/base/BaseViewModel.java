package com.example.beautifulcode.ui.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.example.beautifulcode.data.AppDataManager;
import com.example.beautifulcode.data.DataManager;
import com.example.beautifulcode.data.remote.AppApiHelper;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by ketkigarg on 20/02/18.
 */

public class BaseViewModel<T> extends ViewModel {
  private DataManager dataManager;
  private CompositeDisposable compositeDisposable;
  private T navigator;
  public ObservableBoolean isLoading = new ObservableBoolean(false);

  public BaseViewModel() {
    dataManager = AppDataManager.getInstance(AppApiHelper.getInstance());
    compositeDisposable = new CompositeDisposable();
  }

  protected void addDisposable(Disposable disposable) {
    compositeDisposable.add(disposable);
  }

  public DataManager getDataManager() {
    return dataManager;
  }

  @Override
  protected void onCleared() {
    if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
      compositeDisposable.dispose();
    }
    super.onCleared();
  }

  public void setIsLoading(boolean loading) {
    isLoading.set(loading);
  }

  public ObservableBoolean getIsLoading() {
    return isLoading;
  }

  public void setNavigator(T navigator) {
    this.navigator = navigator;
  }

  public T getNavigator() {
    return navigator;
  }
}

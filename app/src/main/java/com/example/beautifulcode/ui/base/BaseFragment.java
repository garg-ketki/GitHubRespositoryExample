package com.example.beautifulcode.ui.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ketkigarg on 20/02/18.
 */

public abstract class BaseFragment<T extends ViewDataBinding, V extends BaseViewModel>
    extends Fragment {

  private T mViewDataBinding;
  private View itemView;
  private V baseViewModel;
  private String name;
  public BaseActivity activity;

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    baseViewModel = getViewModel();
    name = getName();
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof BaseActivity) {
      BaseActivity activity = (BaseActivity) context;
      this.activity = activity;
      activity.onFragmentAttached(name);
    }
  }

  @Override
  public void onDetach() {
    if (activity instanceof BaseActivity) {
      activity.onFragmentAttached(name);
    }
    activity = null;
    super.onDetach();
  }

  protected abstract V getViewModel();

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                           @Nullable Bundle savedInstanceState) {
    mViewDataBinding = DataBindingUtil.inflate(getLayoutInflater(), getLayoutId(), container,
        false);
    itemView = mViewDataBinding.getRoot();
    return itemView;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    mViewDataBinding.setVariable(getBindingVariable(), baseViewModel);
    mViewDataBinding.executePendingBindings();
  }

  @LayoutRes
  public abstract int getLayoutId();

  public abstract String getName();

  public abstract int getBindingVariable();


  public T getDataBinding() {
    return mViewDataBinding;
  }

  interface FragmentCallback {

    void onFragmentAttached(String name);

    void onFragmentDetached(String name);

  }
}

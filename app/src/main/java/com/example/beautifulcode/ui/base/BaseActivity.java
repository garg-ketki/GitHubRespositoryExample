package com.example.beautifulcode.ui.base;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.beautifulcode.utils.CommonUtils;

/**
 * Created by ketkigarg on 20/02/18.
 */

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel>
    extends AppCompatActivity implements BaseFragment.FragmentCallback {
  private T mViewDataBinding;
  private V mViewModel;
  private ProgressDialog progressDialog;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.v("ketki", "inside oncreate start !!");
    mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutRes());
    mViewModel = getViewModel();
    mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
    mViewDataBinding.executePendingBindings();
    Log.v("ketki", "inside onCreate !!");
  }

  protected abstract int getBindingVariable();

  protected abstract V getViewModel();

  protected abstract int getLayoutRes();

  public void showProgressBar() {
    hideProgressBar();
    if (progressDialog == null) {
      progressDialog = CommonUtils.showLoadingDialog(this);
    }
    progressDialog.show();
  }

  public void hideProgressBar() {
    if (progressDialog != null && progressDialog.isShowing()) {
      progressDialog.dismiss();
    }
  }

  @Override
  public void onFragmentAttached(String name) {

  }

  @Override
  public void onFragmentDetached(String name) {

  }
}

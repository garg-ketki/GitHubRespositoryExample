package com.example.beautifulcode.ui.repodetailscreen;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.beautifulcode.BR;
import com.example.beautifulcode.R;
import com.example.beautifulcode.databinding.FragmentDetailRepoBinding;
import com.example.beautifulcode.ui.base.BaseFragment;

/**
 * Created by ketkigarg on 20/02/18.
 */

public class DetailFragment extends BaseFragment<FragmentDetailRepoBinding, DetailViewModel>
    implements DetailNavigator {

  private DetailViewModel mDetailViewModel;

  public static DetailFragment newInstance(String userName, String repoName) {
    DetailFragment fragment = new DetailFragment();
    Bundle bundle = new Bundle();
    bundle.putString("userName", userName);
    bundle.putString("repoName", repoName);
    fragment.setArguments(bundle);
    return fragment;
  }

  @Override
  protected DetailViewModel getViewModel() {
    mDetailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);
    return mDetailViewModel;
  }

  @Override
  public int getLayoutId() {
    return R.layout.fragment_detail_repo;
  }

  @Override
  public String getName() {
    return DetailFragment.class.getName();
  }

  @Override
  public int getBindingVariable() {
    return BR.viewModel;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mDetailViewModel.setNavigator(this);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    subscribeToLiveData();
    mDetailViewModel.getRepoDetails(getArguments().getString("userName"),
        getArguments().getString("repoName"));
  }


  private void subscribeToLiveData() {
    mDetailViewModel.getRepoLiveData().observe(this, value -> {
      mDetailViewModel.setCustomRepoDetail(value);
    });
  }

  @Override
  public void handleError(String msg) {
    Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
  }
}

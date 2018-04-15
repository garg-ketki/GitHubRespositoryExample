package com.example.beautifulcode.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.beautifulcode.ActivityNavigator;
import com.example.beautifulcode.BR;
import com.example.beautifulcode.R;
import com.example.beautifulcode.databinding.ActivityGitRepoBinding;
import com.example.beautifulcode.ui.base.BaseActivity;
import com.example.beautifulcode.ui.repodetailscreen.DetailFragment;
import com.example.beautifulcode.ui.repolistscreen.GitRepoListFragment;

public class GitRepoActivity extends BaseActivity<ActivityGitRepoBinding, GitRepoViewModel>
    implements ActivityNavigator {
  private GitRepoViewModel mGitViewModel;

  @Override
  protected int getBindingVariable() {
    return BR.viewModel;
  }

  @Override
  protected GitRepoViewModel getViewModel() {
    mGitViewModel = ViewModelProviders.of(this).get(GitRepoViewModel.class);
    return mGitViewModel;
  }

  @Override
  protected int getLayoutRes() {
    return R.layout.activity_git_repo;
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Log.v("ketki", "inside onCreate");
    loadListFragment();
  }

  @Override
  public void loadDetailFrgament(String repoName) {
    Log.v("ketki", "inside on fragment load");
    DetailFragment fragment = DetailFragment.newInstance("google", repoName);
    getSupportFragmentManager()
        .beginTransaction()
        .addToBackStack(null)
        .replace(R.id.fl_container, fragment, fragment.getName())
        .commit();
  }

  @Override
  public void loadListFragment() {
    GitRepoListFragment fragment = GitRepoListFragment.newInstance();
    getSupportFragmentManager()
        .beginTransaction()
        .add(R.id.fl_container, fragment, fragment.getName())
        .commit();
  }

  public void onItemSelected(String repoName) {
    loadDetailFrgament(repoName);
  }
}

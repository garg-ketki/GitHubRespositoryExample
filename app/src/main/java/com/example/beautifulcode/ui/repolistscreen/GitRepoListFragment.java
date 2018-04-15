package com.example.beautifulcode.ui.repolistscreen;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ObservableField;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.beautifulcode.BR;
import com.example.beautifulcode.R;
import com.example.beautifulcode.data.model.api.Repository;
import com.example.beautifulcode.databinding.FragmentListRepoBinding;
import com.example.beautifulcode.ui.GitRepoActivity;
import com.example.beautifulcode.ui.base.BaseFragment;

import java.util.ArrayList;

/**
 * Created by ketkigarg on 20/02/18.
 */

public class GitRepoListFragment
    extends BaseFragment<FragmentListRepoBinding, GitRepoListViewModel> implements
    GitRepoListNavigator, ClickListener {
  private GitRepoListViewModel viewModel;
  private FragmentListRepoBinding binding;
  private GitRepoListAdapter adapter;

  @Override
  protected GitRepoListViewModel getViewModel() {
    viewModel = ViewModelProviders.of(this).get(GitRepoListViewModel.class);
    return viewModel;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    viewModel.setNavigator(this);
    binding = getDataBinding();
    LinearLayoutManager layoutManager =
        new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
    binding.rv.setLayoutManager(layoutManager);
    adapter = new GitRepoListAdapter(viewModel.observableArrayList, this);
    binding.rv.setAdapter(adapter);
    subscribeLiveData();
    viewModel.getRepoList();
  }

  private void subscribeLiveData() {
    viewModel.getListMutableLiveData()
        .observe(this, list -> viewModel.setObservableArrayList(list));
  }

  @Override
  public int getLayoutId() {
    return R.layout.fragment_list_repo;
  }

  @Override
  public String getName() {
    return GitRepoListFragment.class.getName();
  }

  @Override
  public int getBindingVariable() {
    return BR.viewModel;
  }

  public static GitRepoListFragment newInstance() {
    GitRepoListFragment fragment = new GitRepoListFragment();
    return fragment;
  }

  @Override
  public void updateList(ArrayList<Repository> list) {
    adapter.setData(list);
  }

  @Override
  public void OnItemClick(String name) {
    ((GitRepoActivity) getActivity()).onItemSelected(name);
  }
}

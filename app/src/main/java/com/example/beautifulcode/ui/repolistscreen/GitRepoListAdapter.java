package com.example.beautifulcode.ui.repolistscreen;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.beautifulcode.R;
import com.example.beautifulcode.data.model.api.Repository;
import com.example.beautifulcode.databinding.LayoutItemBinding;

import java.util.ArrayList;

/**
 * Created by ketkigarg on 20/02/18.
 */

class GitRepoListAdapter extends RecyclerView.Adapter<GitRepoItemVH> {
  public ArrayList<Repository> observableArrayList;
  public ClickListener clickListener;

  public GitRepoListAdapter(ObservableArrayList<Repository> observableArrayList,
                            ClickListener clickListener) {
    this.observableArrayList = observableArrayList;
    this.clickListener = clickListener;
  }

  @Override
  public GitRepoItemVH onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
        R.layout.layout_item, parent, false);
    return new GitRepoItemVH(binding.getRoot(), binding, clickListener);
  }

  @Override
  public void onBindViewHolder(GitRepoItemVH holder, int position) {
    holder.onBind(observableArrayList.get(position));
  }

  @Override
  public int getItemCount() {
    if (observableArrayList == null) {
      return 0;
    }
    return observableArrayList.size();
  }

  public void setData(ArrayList<Repository> data) {
    observableArrayList.clear();
    observableArrayList.addAll(data);
    notifyDataSetChanged();
  }
}

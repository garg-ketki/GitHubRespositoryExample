package com.example.beautifulcode.ui.repolistscreen;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.beautifulcode.BR;
import com.example.beautifulcode.data.model.api.Repository;
import com.example.beautifulcode.databinding.LayoutItemBinding;

/**
 * Created by ketkigarg on 20/02/18.
 */

class GitRepoItemVH extends RecyclerView.ViewHolder {
  private LayoutItemBinding binding;
  private ClickListener clickListener;

  public GitRepoItemVH(View root, LayoutItemBinding binding, ClickListener clickListener) {
    super(root);
    this.clickListener = clickListener;
    this.binding = binding;
  }

  public void onBind(Repository repository) {
    binding.setVariable(BR.viewModel, new VHViewModel(repository,clickListener ));
  }
}

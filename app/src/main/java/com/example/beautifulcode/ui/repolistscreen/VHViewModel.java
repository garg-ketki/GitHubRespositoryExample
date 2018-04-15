package com.example.beautifulcode.ui.repolistscreen;

import android.databinding.ObservableField;

import com.example.beautifulcode.data.model.api.Repository;

/**
 * Created by ketkigarg on 20/02/18.
 */

public class VHViewModel {
  public ObservableField<String> name;
  public ObservableField<String> language;
  public ObservableField<String> watchers;
  public ClickListener clickListener;

  public VHViewModel(Repository repository, ClickListener clickListener) {
    name = new ObservableField(repository.name);
    language = new ObservableField(repository.language);
    watchers = new ObservableField(repository.watchers + "");
    this.clickListener = clickListener;
  }

  public void onItemClick() {
    clickListener.OnItemClick(name.get());
  }
}

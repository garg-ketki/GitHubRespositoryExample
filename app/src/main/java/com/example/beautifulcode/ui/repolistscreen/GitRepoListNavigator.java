package com.example.beautifulcode.ui.repolistscreen;

import com.example.beautifulcode.data.model.api.Repository;

import java.util.ArrayList;

/**
 * Created by ketkigarg on 20/02/18.
 */

public interface GitRepoListNavigator {

  void updateList(ArrayList<Repository> list);

}

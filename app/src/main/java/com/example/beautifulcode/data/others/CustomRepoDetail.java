package com.example.beautifulcode.data.others;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.beautifulcode.BR;

import java.util.Date;


/**
 * Created by ketkigarg on 20/02/18.
 */

public class CustomRepoDetail extends BaseObservable {
  private String name;
  private Date createdAt;
  private long stars;
  private String imageUrl;

  @Bindable
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
    notifyPropertyChanged(BR.name);
  }

  @Bindable
  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
    notifyPropertyChanged(BR.createdAt);
  }

  @Bindable
  public long getStars() {
    return stars;
  }

  public void setStars(long stars) {
    this.stars = stars;
    notifyPropertyChanged(BR.stars);
  }

  @Bindable
  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
    notifyPropertyChanged(BR.imageUrl);
  }
}

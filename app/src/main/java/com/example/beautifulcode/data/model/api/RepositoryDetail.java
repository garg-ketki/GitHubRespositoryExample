package com.example.beautifulcode.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ketkigarg on 20/02/18.
 */

public class RepositoryDetail implements Parcelable {

  @SerializedName("full_name")
  public String fullName;

  @SerializedName("created_at")
  public String createdAt;

  @SerializedName("stargazers_count")
  public long stars;

  public Owner owner;


  protected RepositoryDetail(Parcel in) {
    fullName = in.readString();
    createdAt = in.readString();
    stars = in.readLong();
    owner = in.readParcelable(Owner.class.getClassLoader());
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(fullName);
    dest.writeString(createdAt);
    dest.writeLong(stars);
    dest.writeParcelable(owner, flags);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<RepositoryDetail> CREATOR = new Creator<RepositoryDetail>() {
    @Override
    public RepositoryDetail createFromParcel(Parcel in) {
      return new RepositoryDetail(in);
    }

    @Override
    public RepositoryDetail[] newArray(int size) {
      return new RepositoryDetail[size];
    }
  };
}

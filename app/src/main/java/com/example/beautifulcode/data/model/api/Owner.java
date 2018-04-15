package com.example.beautifulcode.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ketkigarg on 20/02/18.
 */

public class Owner implements Parcelable {
  @SerializedName("avatar_url")
  public String imageUrl;

  protected Owner(Parcel in) {
    imageUrl = in.readString();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(imageUrl);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<Owner> CREATOR = new Creator<Owner>() {
    @Override
    public Owner createFromParcel(Parcel in) {
      return new Owner(in);
    }

    @Override
    public Owner[] newArray(int size) {
      return new Owner[size];
    }
  };
}

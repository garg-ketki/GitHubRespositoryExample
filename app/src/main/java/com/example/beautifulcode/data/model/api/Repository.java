package com.example.beautifulcode.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ketkigarg on 20/02/18.
 */

public class Repository implements Parcelable {
  public String name;
  public String language;
  public int watchers;
  public long id;

  protected Repository(Parcel in) {
    name = in.readString();
    language = in.readString();
    watchers = in.readInt();
    id = in.readLong();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(name);
    dest.writeString(language);
    dest.writeInt(watchers);
    dest.writeLong(id);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<Repository> CREATOR = new Creator<Repository>() {
    @Override
    public Repository createFromParcel(Parcel in) {
      return new Repository(in);
    }

    @Override
    public Repository[] newArray(int size) {
      return new Repository[size];
    }
  };
}

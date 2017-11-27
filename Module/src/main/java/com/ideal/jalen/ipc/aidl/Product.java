package com.ideal.jalen.ipc.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author: jalen
 * date: 2017/11/27
 * editor:
 * date:
 * describe:
 */
public class Product implements Parcelable {
    public String name;
    public int price;

    protected Product() {
    }

    protected Product(Parcel in) {
        name = in.readString();
        price = in.readInt();
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.price);
    }
}

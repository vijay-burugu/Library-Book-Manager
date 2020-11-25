package com.example.librarybookmanage;

import android.os.Parcel;
import android.os.Parcelable;

public class Product_Books implements Parcelable {
    String id;
    String name;
    String qty;
    String price;
    String description;

    public String getPvaliddays() {
        return pvaliddays;
    }

    public void setPvaliddays(String pvaliddays) {
        this.pvaliddays = pvaliddays;
    }

    public String getPdepartment() {
        return pdepartment;
    }

    public void setPdepartment(String pdepartment) {
        this.pdepartment = pdepartment;
    }

    String pvaliddays;
    String pdepartment;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.qty);
        dest.writeString(this.price);
        dest.writeString(this.description);
        dest.writeString(this.pvaliddays);
        dest.writeString(this.pdepartment);
    }

    public Product_Books() {
    }

    protected Product_Books(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.qty = in.readString();
        this.price = in.readString();
        this.description = in.readString();
        this.pvaliddays=in.readString();
        this.pdepartment=in.readString();
    }

    public static final Creator<Product_Books> CREATOR = new Creator<Product_Books>() {
        @Override
        public Product_Books createFromParcel(Parcel source) {
            return new Product_Books(source);
        }

        @Override
        public Product_Books[] newArray(int size) {
            return new Product_Books[size];
        }
    };
}

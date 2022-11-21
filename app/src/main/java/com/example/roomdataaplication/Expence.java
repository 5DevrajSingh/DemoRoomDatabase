package com.example.roomdataaplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "expence")
public class Expence {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "mobileNo")
    private String mobileNo;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "coarseName")
    private String coarseName;

    @ColumnInfo(name = "imageUrl")
    private String imageUrl;

    public Expence(String name, String mobileNo, String email, String coarseName, String imageUrl) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.email = email;
        this.coarseName = coarseName;
        this.imageUrl = imageUrl;
    }

//    @Ignore
//    Expence(String title, String amount){
//        this.title = title;
//        this.amount = amount;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCoarseName() {
        return coarseName;
    }

    public void setCoarseName(String coarseName) {
        this.coarseName = coarseName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}

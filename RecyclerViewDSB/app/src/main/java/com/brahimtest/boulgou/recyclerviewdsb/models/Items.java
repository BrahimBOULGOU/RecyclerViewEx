package com.brahimtest.boulgou.recyclerviewdsb.models;

import java.io.Serializable;

/**
 * Created by Brahim BOULGOU on 2/22/18.
 */

public class Items implements Serializable {
    int mImage;
    String mTitle;
    String mDescription;

    public Items(String mTitle, String mDescription, int mImage) {
        this.mImage = mImage;
        this.mTitle = mTitle;
        this.mDescription = mDescription;
    }

    public int getmImage() {
        return mImage;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

}

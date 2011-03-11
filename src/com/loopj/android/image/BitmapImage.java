package com.loopj.android.image;

import android.graphics.Bitmap;

public class BitmapImage implements SmartImage {
    private Bitmap bitmap;

    public BitmapImage(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }
}
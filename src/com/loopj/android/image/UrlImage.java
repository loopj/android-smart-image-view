package com.loopj.android.image;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class UrlImage implements SmartImage {
    private static final int CONNECTION_TIMEOUT = 1000;

    private String url;

    public UrlImage(String url) {
        this.url = url;
    }

    public Bitmap getBitmap() {
        Bitmap bitmap = null;

        try {
            URLConnection conn = new URL(url).openConnection();
            conn.setConnectTimeout(1000);
            conn.setReadTimeout(1000);
            bitmap = BitmapFactory.decodeStream((InputStream) conn.getContent());
        } catch(Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
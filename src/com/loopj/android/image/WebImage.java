package com.loopj.android.image;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class WebImage implements SmartImage {
    private static final int CONNECT_TIMEOUT = 1000;
    private static final int READ_TIMEOUT = 1000;

    private static WebImageCache webImageCache;

    private String url;

    public WebImage(Context context, String url) {
        if(webImageCache == null) {
            webImageCache = new WebImageCache(context);
        }

        this.url = url;
    }

    public Bitmap getBitmap() {
        Bitmap bitmap = null;

        try {
            URLConnection conn = new URL(url).openConnection();
            conn.setConnectTimeout(CONNECT_TIMEOUT);
            conn.setReadTimeout(READ_TIMEOUT);
            bitmap = BitmapFactory.decodeStream((InputStream) conn.getContent());
        } catch(Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
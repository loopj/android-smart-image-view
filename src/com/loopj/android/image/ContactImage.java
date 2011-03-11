package com.loopj.android.image;

import java.io.InputStream;

import android.content.ContentUris;
import android.content.ContentResolver;
import android.content.Context;
import android.provider.ContactsContract;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

public class ContactImage implements SmartImage {
    private static ContentResolver contentResolver;

    private Context context;
    private int contactId;

    public ContactImage(Context context, int contactId) {
        if(contentResolver == null) {
            contentResolver = context.getContentResolver();
        }

        this.contactId = contactId;
    }

    public Bitmap getBitmap() {
        Bitmap bitmap = null;

        try {
            Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contactId);
            InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(contentResolver, uri);
            if(input != null) {
                bitmap = BitmapFactory.decodeStream(input);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
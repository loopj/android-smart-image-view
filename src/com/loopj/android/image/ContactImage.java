package com.loopj.android.image;

import java.io.InputStream;

import android.content.ContentUris;
import android.content.ContentResolver;
import android.provider.ContactsContract;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

public class ContactImage implements SmartImage {
    private static final int CONNECTION_TIMEOUT = 1000;

    private String url;

    public ContactImage(int contactId) {
        this.contactId = contactId;
    }

    public Bitmap getBitmap() {
        Bitmap bitmap = null;

        try {
            ContentResolver resolver = imageView.getContext().getContentResolver();
            Uri uri = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, contactId);
            InputStream input = ContactsContract.Contacts.openContactPhotoInputStream(cr, uri);
            if(input != null) {
                bitmap = BitmapFactory.decodeStream(input);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

        return bitmap;
    }
}
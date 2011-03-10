package com.loopj.android.image;

import android.os.Handler;
import android.os.Message;

public class SmartImageTask implements Runnable {
    private static final int BITMAP_READY = 0;

    private boolean cancelled = false;
    private OnCompleteHandler onCompleteHandler;

    public static class OnCompleteHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            Bitmap bitmap = (Bitmap)msg.obj;
            onComplete(bitmap);
        }

        public void onComplete(Bitmap bitmap){};
    }

    public void setOnCompleteHandler(OnCompleteHandler handler){
        this.onCompleteHandler = handler;
    }

    public void cancel() {
        cancelled = true;
    }

    public void complete(Bitmap bitmap){
        if(onCompleteHandler != null && !cancelled) {
            onCompleteHandler.sendMessage(onCompleteHandler.obtainMessage(BITMAP_READY, bitmap));
        }
    }
}
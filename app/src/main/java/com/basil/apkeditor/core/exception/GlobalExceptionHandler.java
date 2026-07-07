package com.basil.apkeditor.core.exception;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;
import com.basil.apkeditor.core.utils.Logger;

public class GlobalExceptionHandler implements Thread.UncaughtExceptionHandler {
    private final Context context;
    private final Thread.UncaughtExceptionHandler defaultHandler;

    public GlobalExceptionHandler(Context context) {
        this.context = context;
        this.defaultHandler = Thread.getDefaultUncaughtExceptionHandler();
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        Logger.e("GlobalExceptionHandler", "Uncaught exception", throwable);
        
        new Thread(() -> {
            Looper.prepare();
            Toast.makeText(context, "An unexpected error occurred. Please restart the app.", Toast.LENGTH_LONG).show();
            Looper.loop();
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (defaultHandler != null) {
            defaultHandler.uncaughtException(thread, throwable);
        } else {
            System.exit(1);
        }
    }
}

package com.basil.apkeditor.core.utils;

import android.util.Log;

public class Logger {
    private static final String TAG = "APKEditorBSL";
    private static boolean isDebuggable = true;

    public static void setDebuggable(boolean debuggable) {
        isDebuggable = debuggable;
    }

    public static void d(String tag, String message) {
        if (isDebuggable) Log.d(TAG + "-" + tag, message);
    }

    public static void i(String tag, String message) {
        if (isDebuggable) Log.i(TAG + "-" + tag, message);
    }

    public static void w(String tag, String message) {
        if (isDebuggable) Log.w(TAG + "-" + tag, message);
    }

    public static void e(String tag, String message, Throwable t) {
        if (isDebuggable) Log.e(TAG + "-" + tag, message, t);
    }
}

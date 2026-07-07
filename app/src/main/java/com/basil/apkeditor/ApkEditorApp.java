package com.basil.apkeditor;

import android.app.Application;

import com.basil.apkeditor.core.exception.GlobalExceptionHandler;
import com.basil.apkeditor.core.utils.ThemeManager;

public class ApkEditorApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        
        // Setup global exception handler
        Thread.setDefaultUncaughtExceptionHandler(new GlobalExceptionHandler(this));
        
        // Apply theme early
        ThemeManager.applyTheme(this);
    }
}

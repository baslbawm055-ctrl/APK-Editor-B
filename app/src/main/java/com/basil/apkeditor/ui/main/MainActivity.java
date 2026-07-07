package com.basil.apkeditor.ui.main;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.basil.apkeditor.R;
import com.basil.apkeditor.core.base.BaseActivity;
import com.basil.apkeditor.core.utils.Logger;
import com.google.android.material.card.MaterialCardView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);
        
        Logger.i("MainActivity", "App started");
    }

    @Override
    protected void setupUI() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MaterialCardView cardStorage = findViewById(R.id.card_choose_apk_storage);
        MaterialCardView cardApps = findViewById(R.id.card_choose_apk_apps);
        MaterialCardView cardExtract = findViewById(R.id.card_extract_apk);

        if (cardStorage != null) {
            cardStorage.setOnClickListener(v -> 
                Toast.makeText(this, getString(R.string.choose_apk_storage), Toast.LENGTH_SHORT).show()
            );
        }

        if (cardApps != null) {
            cardApps.setOnClickListener(v -> 
                Toast.makeText(this, getString(R.string.choose_apk_apps), Toast.LENGTH_SHORT).show()
            );
        }

        if (cardExtract != null) {
            cardExtract.setOnClickListener(v -> 
                Toast.makeText(this, getString(R.string.extract_apk), Toast.LENGTH_SHORT).show()
            );
        }
    }
}

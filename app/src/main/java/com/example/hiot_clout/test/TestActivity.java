package com.example.hiot_clout.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hiot_clout.R;
import com.example.hiot_clout.test.glidetest.TestGlideActivity;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Button btnGlideTest = findViewById(R.id.btn_glide_test_activity);
        btnGlideTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this, TestGlideActivity.class);
                startActivity(intent);
            }
        });
    }
}

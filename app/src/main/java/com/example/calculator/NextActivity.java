package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    private TextView tvNextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Button btnFinishActivity = findViewById(R.id.btn_finish_activity);
        btnFinishActivity.setOnClickListener(v -> {
        finishAffinity();
        });

        tvNextResult = findViewById(R.id.tv_next_result);
        String result = getIntent().getStringExtra("result");
        if(result != null)
            tvNextResult.setText(result);

        Log.d("Aifer","onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Aifer", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Aifer", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Aifer", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Aifer", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Aifer", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Aifer", "onRestart");
    }
}
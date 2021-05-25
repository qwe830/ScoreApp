package com.example.scoreapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.scoreapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
        private int scoreA, scoreB, saveA, saveB;
        private final String KEY = "key";
        private final String MY_SP = "my_sp", SP_A = "sp_a", SP_B = "sp_b";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mBinding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(mBinding.getRoot());

            mBinding.buttonAAdd1.setOnClickListener(v -> {
                addA(1);
            });
            mBinding.buttonAAdd2.setOnClickListener(v -> {
                addA(2);
            });
            mBinding.buttonAAdd3.setOnClickListener(v -> {
                addA(3);
            });
            mBinding.buttonBAdd1.setOnClickListener(v -> {
                addB(1);
            });
            mBinding.buttonBAdd2.setOnClickListener(v -> {
                addB(2);
            });
            mBinding.buttonBAdd3.setOnClickListener(v -> {
                addB(3);
            });



    }

    private void addB(int i) {
        show();
        scoreB += i;
    }

    private void addA(int i) {
        show();
        scoreA += i;
    }
    public void show() {
        mBinding.textScoreA.setText(String.valueOf(scoreA));
        mBinding.textScoreB.setText(String.valueOf(scoreB));
    }
}
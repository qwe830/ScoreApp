package com.example.scoreapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.scoreapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private int scoreA, scoreB;
    private int saveA,saveB;
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
            mBinding.imageButtonRevoke.setOnClickListener(v -> {
               reset();
            });
           mBinding.imageButtonReset.setOnClickListener(v ->{
               revoke();
           });

    }

    private void writeSP() {
        SharedPreferences.Editor sp = getSharedPreferences(MY_SP, MODE_PRIVATE).edit();
        sp.putInt(SP_A, scoreA).putInt(SP_B, scoreB).apply();
    }



    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray(KEY, new int[]{scoreA, scoreB, saveA, saveB});
    }

    private void revoke() {
        scoreA = saveA;
        scoreB = saveB;

        show();
    }


    private void reset() {
        scoreA = 0;
        scoreB = 0;
        show();
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
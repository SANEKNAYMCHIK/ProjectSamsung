package com.example.projectsamsung;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class AlphabetActivity extends AppCompatActivity {
    ImageButton btn1, btn2;
    ViewPager viewPager;
    int[] mass1, mass2;
    ArrayList<Integer> arrayList, arrayList2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);

        viewPager = findViewById(R.id.viewpager);
        TypedArray letters = getResources().obtainTypedArray(R.array.arrayabcletters);
        TypedArray words = getResources().obtainTypedArray(R.array.arrayabcwords);
        mass1 = new int[letters.length()];
        mass2 = new int[words.length()];

        for (int i = 0; i < letters.length(); i++) {
            mass1[i] = letters.getResourceId(i, 0);
        }
        letters.recycle();

        for (int i = 0; i < words.length(); i++) {
            mass2[i] = words.getResourceId(i, 0);
        }
        words.recycle();
        arrayList = new ArrayList<Integer>(mass1.length);
        for (int i:mass1) {
            arrayList.add(i);
        }
        arrayList2 = new ArrayList<Integer>(mass2.length);
        for (int i:mass2) {
            arrayList2.add(i);
        }
        ImageAdapter adapter = new ImageAdapter(AlphabetActivity.this, arrayList, arrayList2);
        viewPager.setAdapter(adapter);
    }
}
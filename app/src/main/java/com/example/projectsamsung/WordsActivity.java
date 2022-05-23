package com.example.projectsamsung;

import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectsamsung.db.DbManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class WordsActivity extends AppCompatActivity {
    ImageButton imgbtnmain, imgbtn1, imgbtn2, imgbtn3, imgbtn4;
    int[] lettersimg;
    int[] wordsimg;
    String[] tags;
    MediaPlayer mediaPlayer;
    DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);
        dbManager = new DbManager(this);

        imgbtnmain = findViewById(R.id.mainletter);
        imgbtn1 = findViewById(R.id.letter1);
        imgbtn2 = findViewById(R.id.letter2);
        imgbtn3 = findViewById(R.id.letter3);
        imgbtn4 = findViewById(R.id.letter4);

        TypedArray letters = getResources().obtainTypedArray(R.array.arrayletters);
        TypedArray words = getResources().obtainTypedArray(R.array.arraywords);
        tags = getResources().getStringArray(R.array.tags);
        lettersimg = new int[letters.length()];
        wordsimg = new int[words.length()];
        for (int i = 0; i < letters.length(); i++) {
            lettersimg[i] = letters.getResourceId(i, 0);
        }
        letters.recycle();
        for (int i = 0; i < words.length(); i++) {
            wordsimg[i] = words.getResourceId(i, 0);
        }
        words.recycle();

        randomvalues();

        imgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgbtn1.getTag() == imgbtnmain.getTag()){
                    mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.correct_ans);
                    mediaPlayer.start();
                    addstar("star1", 1);
                    finish();
                    startActivity(getIntent());
                }
                else {
                    mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.wrong_ans);
                    mediaPlayer.start();
                }
            }
        });
        imgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgbtn2.getTag() == imgbtnmain.getTag()){
                    mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.correct_ans);
                    mediaPlayer.start();
                    addstar("star1", 1);
                    finish();
                    startActivity(getIntent());
                }
                else {
                    mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.wrong_ans);
                    mediaPlayer.start();
                }
            }
        });
        imgbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgbtn3.getTag() == imgbtnmain.getTag()){
                    mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.correct_ans);
                    mediaPlayer.start();
                    addstar("star1", 1);
                    finish();
                    startActivity(getIntent());
                }
                else {
                    mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.wrong_ans);
                    mediaPlayer.start();
                }
            }
        });
        imgbtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imgbtn4.getTag() == imgbtnmain.getTag()){
                    mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.correct_ans);
                    mediaPlayer.start();
                    addstar("star1", 1);
                    finish();
                    startActivity(getIntent());
                }
                else {
                    mediaPlayer = MediaPlayer.create(v.getContext(), R.raw.wrong_ans);
                    mediaPlayer.start();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("mainimg", imgbtnmain.getTag().toString());
        outState.putString("imgbtn1", imgbtn1.getTag().toString());
        outState.putString("imgbtn2", imgbtn2.getTag().toString());
        outState.putString("imgbtn3", imgbtn3.getTag().toString());
        outState.putString("imgbtn4", imgbtn4.getTag().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        imgbtnmain.setTag(savedInstanceState.getString("mainimg"));
        imgbtnmain.setImageResource(wordsimg[Arrays.asList(tags).indexOf(savedInstanceState.getString("mainimg"))]);

        imgbtn1.setTag(savedInstanceState.getString("imgbtn1"));
        imgbtn1.setImageResource(lettersimg[Arrays.asList(tags).indexOf(savedInstanceState.getString("imgbtn1"))]);

        imgbtn2.setTag(savedInstanceState.getString("imgbtn2"));
        imgbtn2.setImageResource(lettersimg[Arrays.asList(tags).indexOf(savedInstanceState.getString("imgbtn2"))]);

        imgbtn3.setTag(savedInstanceState.getString("imgbtn3"));
        imgbtn3.setImageResource(lettersimg[Arrays.asList(tags).indexOf(savedInstanceState.getString("imgbtn3"))]);

        imgbtn4.setTag(savedInstanceState.getString("imgbtn4"));
        imgbtn4.setImageResource(lettersimg[Arrays.asList(tags).indexOf(savedInstanceState.getString("imgbtn4"))]);
    }

    public void randomvalues() {
        int n = 0;
        ArrayList<Integer> arraynumb = new ArrayList<>();

        while (n != 4) {
            int RandomInd = new Random().nextInt(lettersimg.length);
            if (n == 0 && !arraynumb.contains(RandomInd)) {
                imgbtn1.setImageResource(lettersimg[RandomInd]);
                imgbtn1.setTag(tags[RandomInd]);
                arraynumb.add(RandomInd);
                n++;
            } else if (n == 1 && !arraynumb.contains(RandomInd)) {
                imgbtn2.setImageResource(lettersimg[RandomInd]);
                imgbtn2.setTag(tags[RandomInd]);
                arraynumb.add(RandomInd);
                n++;
            } else if (n == 2 && !arraynumb.contains(RandomInd)) {
                imgbtn3.setImageResource(lettersimg[RandomInd]);
                imgbtn3.setTag(tags[RandomInd]);
                arraynumb.add(RandomInd);
                n++;
            } else if (n == 3 && !arraynumb.contains(RandomInd)) {
                imgbtn4.setImageResource(lettersimg[RandomInd]);
                imgbtn4.setTag(tags[RandomInd]);
                arraynumb.add(RandomInd);
                n++;
            }
        }
        int RandomInd = arraynumb.get(new Random().nextInt(arraynumb.size()));
        imgbtnmain.setImageResource(wordsimg[RandomInd]);
        imgbtnmain.setTag(tags[RandomInd]);
    }
    public void addstar(String name_val, int value_sum_diff){
        dbManager.openDb();
        dbManager.update(name_val, value_sum_diff);
        dbManager.close();
    }

}
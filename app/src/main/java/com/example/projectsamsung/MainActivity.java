package com.example.projectsamsung;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectsamsung.db.DbManager;

public class MainActivity extends AppCompatActivity {
    ImageButton btn1;
    TextView text, text2, text3;
    TextView textView, textView2;
    DbManager dbManager;
    SharedPreferences val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.count_star_1);
        textView2 = findViewById(R.id.count_star_2);

        dbManager = new DbManager(this);


    }

    public void Alphabet(View view) {
        Intent intent = new Intent(MainActivity.this, AlphabetActivity.class);
        startActivity(intent);
    }

    public void Words(View view) {
        Intent intent = new Intent(MainActivity.this, WordsActivity.class);
        startActivity(intent);
    }

    public void Numbers(View view) {
        Intent intent = new Intent(MainActivity.this, NumbersActivity.class);
        startActivity(intent);
    }

    public void Coloring(View view) {
        Intent intent = new Intent(MainActivity.this, ColoringActivity.class);
        startActivity(intent);
    }

    public void Cartoons(View view) {
        Intent intent = new Intent(MainActivity.this, CartoonsActivity.class);
        startActivity(intent);
    }

    public void Info(View view) {
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setTitle("Результаты");
        dialog.setContentView(R.layout.dialog);
        text = dialog.findViewById(R.id.dialog_tv);
        text2 = dialog.findViewById(R.id.dialog_results);
        text3 = dialog.findViewById(R.id.dialog_results2);
        text.setText("О ПРИЛОЖЕНИИ");
        text2.setText(R.string.main_menu_about);
        text3.setText(R.string.main_menu_rules);
        dialog.show();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                dialog.cancel();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        dbManager.openDb();
        for (String id : dbManager.get().keySet()) {
            if (id.contains(textView.getTag().toString())) {
                textView.setText(String.valueOf((dbManager.get().get(id))));
            } else if (id.contains(textView2.getTag().toString())) {
                textView2.setText(String.valueOf((dbManager.get().get(id))));
            }
        }
        dbManager.close();
        val = getSharedPreferences("videos_list", Context.MODE_PRIVATE);
        boolean hasVisited = val.getBoolean("hasVisited", false);
        if (!hasVisited) {
            dbManager.openDb();
            dbManager.insert(0, "star1");
            dbManager.insert(0, "star2");
            dbManager.insert(0, "NjQ0z4YPDvM");
            dbManager.insert(0, "RLmNLNiNb8M");
            dbManager.insert(0, "sxMGknGySgg");
            dbManager.insert(0, "CZF4Iq3ObhY");
            dbManager.insert(0, "xsciYfRoIrk");
            SharedPreferences.Editor editor = val.edit();
            editor.putBoolean("hasVisited", true);
            editor.apply();
            dbManager.close();
        }
    }
}
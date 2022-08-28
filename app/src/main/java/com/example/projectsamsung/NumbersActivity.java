package com.example.projectsamsung;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectsamsung.db.DbManager;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6,
            btn7, btn8, btn9, btn10, btn11,
            btn12, btn13, btn14, btn15;
    TextView timer, text, results, results2;
    ArrayList<Button> btns = new ArrayList<>();
    int counter = 0;
    int mistakes = 0;
    int time = 31000;
    DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        int height = getResources().getDisplayMetrics().heightPixels;

        dbManager = new DbManager(this);
        timer = findViewById(R.id.timer);
        btn1 = findViewById(R.id.button);
        btns.add(btn1);
        btn2 = findViewById(R.id.button2);
        btns.add(btn2);
        btn3 = findViewById(R.id.button3);
        btns.add(btn3);
        btn4 = findViewById(R.id.button4);
        btns.add(btn4);
        btn5 = findViewById(R.id.button5);
        btns.add(btn5);
        btn6 = findViewById(R.id.button6);
        btns.add(btn6);
        btn7 = findViewById(R.id.button7);
        btns.add(btn7);
        btn8 = findViewById(R.id.button8);
        btns.add(btn8);
        btn9 = findViewById(R.id.button9);
        btns.add(btn9);
        btn10 = findViewById(R.id.button10);
        btns.add(btn10);
        btn11 = findViewById(R.id.button11);
        btns.add(btn11);
        btn12 = findViewById(R.id.button12);
        btns.add(btn12);
        btn13 = findViewById(R.id.button13);
        btns.add(btn13);
        btn14 = findViewById(R.id.button14);
        btns.add(btn14);
        btn15 = findViewById(R.id.button15);
        btns.add(btn15);
        randomvls(height);
        btn1.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn1.getText()) - counter == 1) {
                btn1.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn1.getText()) > counter) {
                btn1.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
        btn2.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn2.getText()) - counter == 1) {
                btn2.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn2.getText()) > counter) {
                btn2.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
        btn3.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn3.getText()) - counter == 1) {
                btn3.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn3.getText()) > counter) {
                btn3.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
        btn4.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn4.getText()) - counter == 1) {
                btn4.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn4.getText()) > counter) {
                btn4.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
        btn5.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn5.getText()) - counter == 1) {
                btn5.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn5.getText()) > counter) {
                btn5.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
        btn6.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn6.getText()) - counter == 1) {
                btn6.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn6.getText()) > counter) {
                btn6.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
        btn7.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn7.getText()) - counter == 1) {
                btn7.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn7.getText()) > counter) {
                btn7.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
        btn8.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn8.getText()) - counter == 1) {
                btn8.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn8.getText()) > counter) {
                btn8.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
        btn9.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn9.getText()) - counter == 1) {
                btn9.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn9.getText()) > counter) {
                btn9.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
        btn10.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn10.getText()) - counter == 1) {
                btn10.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn10.getText()) > counter) {
                btn10.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
        btn11.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn11.getText()) - counter == 1) {
                btn11.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn11.getText()) > counter) {
                btn11.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
        btn12.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn12.getText()) - counter == 1) {
                btn12.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn12.getText()) > counter) {
                btn12.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
        btn13.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn13.getText()) - counter == 1) {
                btn13.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn13.getText()) > counter) {
                btn13.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
        btn14.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn14.getText()) - counter == 1) {
                btn14.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn14.getText()) > counter)
                btn14.setBackgroundColor(getResources().getColor(R.color.pink));
        });
        btn15.setOnClickListener(v -> {
            if (Integer.parseInt((String) btn15.getText()) - counter == 1) {
                btn15.setBackgroundColor(getResources().getColor(R.color.green_salad));
                counter++;
                if (counter == 1) startTimer(time);
            } else if (Integer.parseInt((String) btn15.getText()) > counter) {
                btn15.setBackgroundColor(getResources().getColor(R.color.pink));
                mistakes++;
            }
        });
    }

    private void randomvls(int h) {
        int h1 = h / 5;
        int h2 = h / 15;
        int sizes = ((h1 + h2) / 4) + ((h1 + h2) / 16);
        int counter_random = btns.size() / 3;
        int flag = 0;
        int btn_steps = 0;
        ArrayList<Integer> btn_numb = new ArrayList<>();
        while (btn_numb.size() != 10){
            int num = (int) (Math.random() * 11);
            if (!btn_numb.contains(num) && num != 0){
                btn_numb.add(num);
            }
        }
        System.out.println(btn_numb);
        while (flag < counter_random) {
            int num = (int) (Math.random() * 15);
            if (btns.get(num).getText().toString().equals("")) {
                btns.get(num).setText("" + ((int) (Math.random() * 30) + 15));
                btns.get(num).setTextSize(TypedValue.COMPLEX_UNIT_PX, sizes);
                flag++;
            }
        }
        for (int i = 0; i < btns.size(); i++) {
            if (btns.get(i).getText().toString().equals("")) {
                System.out.println("123");
                System.out.println(btn_numb.get(btn_steps).toString());
                btns.get(i).setText(btn_numb.get(btn_steps).toString());
                btns.get(i).setTextSize(TypedValue.COMPLEX_UNIT_PX, sizes);
                btn_steps++;
            }
        }
    }

    private void startTimer(long time) {
        CountDownTimer countDownTimer = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                if (counter == 10) {
                    cancel();
                    onFinish();
                }
                if ((millisUntilFinished / 1000) - 1 >= 0) {
                    timer.setText((millisUntilFinished / 1000) - 1 + "");
                }
            }

            @Override
            public void onFinish() {
                if (getWindow().getDecorView().getRootView().isShown()) {
                    Dialog dialog = new Dialog(NumbersActivity.this);

                    dialog.setTitle("Результаты");
                    dialog.setContentView(R.layout.dialog);
                    text = dialog.findViewById(R.id.dialog_tv);
                    results = dialog.findViewById(R.id.dialog_results);
                    results2 = dialog.findViewById(R.id.dialog_results2);
                    if (counter == 10) {
                        text.setText("Победа!!!");
                        text.setTextColor(getResources().getColor(R.color.green_salad));
                        dbManager.openDb();
                        dbManager.update("star2", 1);
                        dbManager.close();
                    } else {
                        text.setText("Поражение!!!");
                        text.setTextColor(getResources().getColor(R.color.red));
                    }
                    results.setText("Затрачено " + (30 - Integer.parseInt(timer.getText().toString())) + " сек.");
                    results2.setText("Допущено " + mistakes + " неправильных отв.");
                    dialog.show();
                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            finish();
                            startActivity(getIntent());
                        }
                    });
                }
            }

        }.start();
    }
}
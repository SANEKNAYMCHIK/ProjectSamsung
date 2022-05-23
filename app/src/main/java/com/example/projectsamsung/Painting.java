package com.example.projectsamsung;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class Painting extends View {

    public Painting(Context context) {
        super(context);
    }

    Paint paint = new Paint();
    Paint paint2 = new Paint();
    Paint paint3 = new Paint();
    Paint mainpaint = new Paint();
    Paint draw_paint = new Paint();
    int sizes_height;
    int sizes_width;
    int koef = 35;
    float touchx, touchy;
    int color, color2, color3;
    int numb_amount;
    int step = 0;
    int counter;
    int result = 0;
    ArrayList<Integer> ind_fill_paints = new ArrayList<>();
    MediaPlayer mediaPlayer;
    ArrayList<Rect> rects = new ArrayList<>();
    ArrayList<Paint> paints = new ArrayList<>();


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (step == 1) {
            switch (numb_amount) {
                case 1:
                    for (int i = 0; i < rects.size(); i++) {
                        if (paints.get(i).getStyle().toString().equals("FILL") && !ind_fill_paints.contains(i)) {
                            ind_fill_paints.add(i);
                            result++;
                            System.out.println(result);
                        }
                        canvas.drawRect(rects.get(i), paints.get(i));
                    }
                    break;

            }
            if (result == 3 || result == 6) {
                canvas.drawColor(getResources().getColor(R.color.white));
                step = 0;
                result = 0;
            }
        }
        mainpaint.setStyle(Paint.Style.FILL);
        mainpaint.setColor(getResources().getColor(R.color.red));
        canvas.drawRect(getWidth() - getWidth() / 10, 0, getWidth(), getHeight() / 20, mainpaint);
        mainpaint.setColor(getResources().getColor(R.color.blue));
        canvas.drawRect(getWidth() - getWidth() / 10, getHeight() / 20 + 1, getWidth(), 2 * getHeight() / 20, mainpaint);
        mainpaint.setColor(getResources().getColor(R.color.green));
        canvas.drawRect(getWidth() - getWidth() / 10, getHeight() / 10 + 1, getWidth(), 3 * getHeight() / 20, mainpaint);
        mainpaint.setColor(getResources().getColor(R.color.bezh));
        mainpaint.setTextSize((float) Math.sqrt(getHeight() * getWidth()) / 27);
        canvas.drawText("Закрасьте фигуру тем же цветом,", 0, getHeight() - getHeight() / 10, mainpaint);
        canvas.drawText("что и её контур", getWidth() / 2, getHeight() - getHeight() / 20, mainpaint);
        if (step == 0) {
            numb_amount = 1;
            color = (int) (Math.random() * 3) + 1;
            color2 = (int) (Math.random() * 3) + 1;
            color3 = (int) (Math.random() * 3) + 1;
            paint_color(color, paint);
            paint_color(color2, paint2);
            paint_color(color3, paint3);
            sizes_height = getHeight() / 3;
            sizes_width = getWidth() / 3;

            if (numb_amount == 1) {
                if (getHeight() > getWidth()) {
                    canvas.drawRect(koef, koef, koef + sizes_width, koef + sizes_width, paint);
                    rects.add(new Rect(koef, koef, koef + sizes_width, koef + sizes_width));
                    canvas.drawRect(koef * 2 + sizes_width, koef * 2 + sizes_width,
                            koef * 2 + 2 * sizes_width, koef * 2 + 2 * sizes_width, paint2);
                    rects.add(new Rect(koef * 2 + sizes_width, koef * 2 + sizes_width,
                            koef * 2 + 2 * sizes_width, koef * 2 + 2 * sizes_width));
                    canvas.drawRect(koef, koef * 3 + 2 * sizes_width,
                            koef + sizes_width, koef * 3 + 3 * sizes_width, paint3);
                    rects.add(new Rect(koef, koef * 3 + 2 * sizes_width,
                            koef + sizes_width, koef * 3 + 3 * sizes_width));

                } else {
                    canvas.drawRect(koef, koef, koef + sizes_height, koef + sizes_height, paint);
                    canvas.drawRect(koef * 2 + sizes_height, koef * 2 + sizes_height,
                            koef * 2 + 2 * sizes_height, koef * 2 + 2 * sizes_height, paint2);
                    canvas.drawRect(koef, koef * 3 + 2 * sizes_height, koef + sizes_height,
                            koef * 3 + 3 * sizes_height, paint3);
                }
            }
        }
    }

    private void paint_color(int color, Paint paint) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(getWidth() * getHeight() / 100000);
        paints.add(paint);
        switch (color) {
            case 1:
                paint.setColor(getResources().getColor(R.color.red));
                break;
            case 2:
                paint.setColor(getResources().getColor(R.color.blue));
                break;
            case 3:
                paint.setColor(getResources().getColor(R.color.green));
                break;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchx = event.getX();
        touchy = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                if (touchx >= getWidth() - getWidth() / 10 & touchx <= getWidth() &
                        touchy >= 0 & touchy <= getHeight() / 20) {
                    draw_paint.setColor(getResources().getColor(R.color.red));
                } else if (touchx >= getWidth() - getWidth() / 10 & touchx <= getWidth() &
                        touchy >= getHeight() / 20 + 1 & touchy <= 2 * getHeight() / 20) {
                    draw_paint.setColor(getResources().getColor(R.color.blue));
                } else if (touchx >= getWidth() - getWidth() / 10 & touchx <= getWidth() &
                        touchy >= 2 * getHeight() / 20 + 1 & touchy <= 3 * getHeight() / 20) {
                    draw_paint.setColor(getResources().getColor(R.color.green));
                } else {
                    if (step == 0) step++;
                    switch (numb_amount) {
                        case 1:
                            for (int i = 0; i < rects.size(); i++) {
                                if (rects.get(i).contains((int) touchx, (int) touchy) & draw_paint.getColor() == paints.get(i).getColor()) {
                                    paints.get(i).setStyle(Paint.Style.FILL);
                                    invalidate();
                                } else if (rects.get(i).contains((int) touchx, (int) touchy) & draw_paint.getColor() != paints.get(i).getColor()) {
                                    mediaPlayer = MediaPlayer.create(getContext(), R.raw.wrong_ans);
                                    mediaPlayer.start();
                                }
                            }
                            break;
                    }
                }
            }
        }
        return true;
    }

}

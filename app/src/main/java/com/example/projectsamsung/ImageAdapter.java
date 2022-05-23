package com.example.projectsamsung;

import android.content.Context;
import android.content.res.TypedArray;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

public class ImageAdapter extends PagerAdapter {

    MediaPlayer mediaPlayer = new MediaPlayer();
    Context context;
    ArrayList<Integer> arrayList;
    ArrayList<Integer> arrayList2;
    LayoutInflater layoutInflater;

    public ImageAdapter(Context context, ArrayList<Integer> arrayList, ArrayList<Integer> arrayList2) {
        this.context = context;
        this.arrayList = arrayList;
        this.arrayList2 = arrayList2;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.item_file, container, false);
        View view2 = layoutInflater.inflate(R.layout.item_file, container, false);
        ImageView imageView = view.findViewById(R.id.img);
        ImageView imageView2 = view.findViewById(R.id.img2);
        imageView.setImageResource(arrayList.get(position));
        imageView2.setImageResource(arrayList2.get(position));
        container.addView(view);
        container.addView(view2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TypedArray typedArray = v.getResources().obtainTypedArray(R.array.arraysounds);
                int letter_sound = typedArray.getResourceId(position, 0);
                mediaPlayer = MediaPlayer.create(v.getContext(), letter_sound);
                mediaPlayer.start();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TypedArray typedArray = v.getResources().obtainTypedArray(R.array.arraysoundswords);
                int word_sound = typedArray.getResourceId(position, 0);
                mediaPlayer = MediaPlayer.create(v.getContext(), word_sound);
                mediaPlayer.start();
            }
        });
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}

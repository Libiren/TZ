package com.oleynikov.tz;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.pinxter.letters.Letters;

public class MainActivity extends AppCompatActivity {

    private List list = new ArrayList();
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] title = getResources().getStringArray(R.array.title);
        list = Arrays.asList(title);
        recyclerView = (RecyclerView)findViewById(R.id.rv) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Letters letters = new Letters(this, "name", new ArrayList<>(list));
        letters.setOnSelect(new Letters.OnSelect() {
            @Override
            public void onSelect(int index, String letter) {
               recyclerView.getLayoutManager().scrollToPosition(index);
            }
        });
        ((FrameLayout) findViewById(R.id.letters)).removeAllViews();
        ((FrameLayout) findViewById(R.id.letters)).addView(letters.getLetterLayout());



        recyclerView.setAdapter(new RecyclerViewAdapter(list,letters));









    }
}

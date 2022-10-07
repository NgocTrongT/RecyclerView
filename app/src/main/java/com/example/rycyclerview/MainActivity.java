package com.example.rycyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void initView(){
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        ArrayList<DataShop> arrayList = new ArrayList<>();
        arrayList.add(new DataShop(R.drawable.giay,"Giày đá banh"));
        arrayList.add(new DataShop(R.drawable.banh,"Banh World Cup 2022"));
        arrayList.add(new DataShop(R.drawable.ao,"Áo đấu Real Madrid"));
        arrayList.add(new DataShop(R.drawable.vot,"Vợt tennis"));
        arrayList.add(new DataShop(R.drawable.keo,"Băng keo thể thao"));

        ShopAdapter shopAdapter = new ShopAdapter(arrayList,getApplicationContext());
        recyclerView.setAdapter(shopAdapter);


    }
}
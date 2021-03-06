package com.example.termin19nacasu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRecyclerAdapter.OnElementClickListener {

    RecyclerView rvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        rvList = findViewById(R.id.rvList);
        rvList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvList.setLayoutManager(layoutManager);
        MyRecyclerAdapter adapter = new MyRecyclerAdapter(getData(), this);
        rvList.setAdapter(adapter);
    }

    private List<String> getData() {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            data.add("Element " + i);
        }
        return data;
    }

    @Override
    public void onElementClicked(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
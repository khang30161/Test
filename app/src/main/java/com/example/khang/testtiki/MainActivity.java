package com.example.khang.testtiki;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String json;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_list123);
        json = "[\n" +
                "\"xiaomi\",\n" +
                "\"bitis \n hunter\",\n" +
                "\"bts\",\n" +
                "\"balo\",\n" +
                "\"bitis \n hunter x\",\n" +
                "\"tai \n nghe\",\n" +
                "\"harry \n potter\",\n" +
                "\"anker\",\n" +
                "\"iphone\",\n" +
                "\"balo \n nữ\",\n" +
                "\"nguyễn \n nhật ánh\",\n" +
                "\"đắc nhân \n tâm\",\n" +
                "\"ipad\",\n" +
                "\"senka\",\n" +
                "\"tai nghe \n bluetooth\",\n" +
                "\"son\",\n" +
                "\"maybelline\",\n" +
                "\"laneige\",\n" +
                "\"kem chống \n nắng\",\n" +
                "\"anh chính là \n thanh xuân của em\"\n" +
                "]";
        setUpRv();
    }

    private void setUpRv() {
        Gson gson = new Gson();
        try {
            JSONArray jsonArray = new JSONArray(json);
            List<Tiki> list = new ArrayList<>();
            recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(new Tiki(jsonArray.getString(i)));
            }
            listAdapter = new ListAdapter(MainActivity.this, list);
            recyclerView.setAdapter(listAdapter);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


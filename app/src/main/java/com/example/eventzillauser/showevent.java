package com.example.eventzillauser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class showevent extends AppCompatActivity {
    RecyclerView recyclerView;
    productadapter adapter;

    List<product> productList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showevent);
        productList =new ArrayList<>();

        recyclerView=(RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        productList.add(
                new product(
                        1,
                        "Mudra",
                        "5 pm ",
                        "20/2/20",
                        "Kothrud",
                        R.drawable.mudra));

        productList.add(
                new product(
                        1,
                        "Comedy Night",
                        "7 pm",
                        "2/5/20",
                        "Warje",
                        R.drawable.comedy));

        productList.add(
                new product(
                        1,
                        "Run for peace",
                        "7 Am",
                        "6/1/20",
                        "Baner",
                        R.drawable.run));
        productList.add(
                new product(
                        1,
                        "Design Thinking",
                        "1 Pm",
                        "17/4/20",
                        "Aundh",
                        R.drawable.dtw));
        productList.add(
                new product(
                        1,
                        "Communication Design",
                        "3 pm",
                        "6/9/20",
                        "Vadgaon",
                        R.drawable.design));
        productList.add(
                new product(
                        1,
                        "Aarohan",
                        "7 Am",
                        "6/2/20",
                        "Kothrud",
                        R.drawable.aarohan));
        productList.add(
                new product(
                        1,
                        "Problem Solver",
                        "6 Pm",
                        "20/7/20",
                        "vadgaon",
                        R.drawable.prob));
        productList.add(
                new product(
                        1,
                        "Chem-E-Jeopardy",
                        "10 Pm",
                        "26/11/20",
                        "Warje",
                        R.drawable.chem));
        productList.add(
                new product(
                        1,
                        "FLEA market",
                        " 5 Pm",
                        "16/8/20",
                        "Kothrud",
                        R.drawable.flea));
        productList.add(
                new product(
                        1,
                        "Khayaalbaaz",
                        "4 Pm",
                        "8/11/20",
                        "Vadgaon",
                        R.drawable.rajat));

        productadapter adapter = new productadapter(this, productList);

        recyclerView.setAdapter(adapter);
    }
}


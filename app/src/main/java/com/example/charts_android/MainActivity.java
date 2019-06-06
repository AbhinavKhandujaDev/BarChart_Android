package com.example.charts_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.charts_android.bar_chart.BarChart;

public class MainActivity extends AppCompatActivity {

    BarChart barChartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barChartView = findViewById(R.id.bar_graph_view);


    }
}

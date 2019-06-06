package com.example.charts_android.bar_chart;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.example.charts_android.R;

import java.util.ArrayList;
import java.util.Arrays;

public class BarChart extends CardView {

    public BarChartAdapter adapter;

    public RecyclerView barRecyclerView;

    ArrayList<Double> values;

    public BarChart(@NonNull Context context) {
        super(context);
        initializeView();
    }

    public BarChart(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeView();
    }

    public BarChart(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }

    private void initializeView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bar_chart, null);
        barRecyclerView = view.findViewById(R.id.bar_recycler_view);
        barRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, true));

        values = new ArrayList<>();
        values.add(3.2);
        values.add(4.3);
        values.add(3.0);
        values.add(5.0);

        float scale = (int) getResources().getDisplayMetrics().density;
        int dpHeightInPx = (int) (150 * scale);

        adapter = new BarChartAdapter(values, dpHeightInPx);

        barRecyclerView.setAdapter(adapter);

        addView(view);
    }
}

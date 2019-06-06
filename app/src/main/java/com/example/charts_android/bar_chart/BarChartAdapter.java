package com.example.charts_android.bar_chart;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.Collections;


import com.example.charts_android.R;

import java.util.ArrayList;

public class BarChartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "BarChartAdapter";

    private ArrayList<Double> barValues;
    private int height;
    private Double maxHeight;

    public BarChartAdapter(ArrayList<Double> barValues, int height) {
        this.barValues = barValues;
        this.height = height;
        maxHeight = Collections.max(barValues);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater barChartViewInflater = LayoutInflater.from(viewGroup.getContext());
        View barChartView = barChartViewInflater.inflate(R.layout.bar_chart_recycler_view,viewGroup,false);

        return new BarViewHolder(barChartView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        BarViewHolder view = (BarViewHolder) viewHolder;

        view.setBarSize(barValues.get(i),height, maxHeight);
        view.valueLabel.setText(barValues.get(i).toString());

    }

    @Override
    public int getItemCount() {
        return barValues.size();
    }

    public class BarViewHolder extends RecyclerView.ViewHolder {
        private View bar;
        private TextView valueLabel;

        public BarViewHolder(@NonNull View itemView) {
            super(itemView);
            bar = itemView.findViewById(R.id.resizable_bar);
            valueLabel = itemView.findViewById(R.id.value_label);
        }

        public void setBarSize(Double value, int barHeight, Double maxVal) {

            ConstraintLayout.LayoutParams lp = (ConstraintLayout.LayoutParams) bar.getLayoutParams();
            Log.d(TAG, "bar height is "+lp.height);

            lp.topMargin = barHeight - (int) (value * barHeight/maxVal);
            bar.setLayoutParams(lp);
        }
    }
}

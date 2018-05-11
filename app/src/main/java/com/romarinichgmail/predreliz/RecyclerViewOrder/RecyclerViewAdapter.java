package com.romarinichgmail.predreliz.RecyclerViewOrder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.romarinichgmail.predreliz.Fragment.FragmentOrder;
import com.romarinichgmail.predreliz.R;

import java.util.ArrayList;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    FragmentOrder mFragmentOrder;
    ArrayList<OrderObject> mArrayList;

    public RecyclerViewAdapter(FragmentOrder mFragmentOrder, ArrayList<OrderObject> mArrayList) {
        this.mFragmentOrder=mFragmentOrder;
        this.mArrayList = mArrayList;
    }
    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(mFragmentOrder.getContext());
        View view =layoutInflater.inflate(R.layout.item_order,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.mCargoName.setText(mArrayList.get(position).getNameCargo());
        holder.mFinishPoint.setText(mArrayList.get(position).getFinishPoint());
        holder.mStartPoint.setText(mArrayList.get(position).getStartPoint());
        holder.mDistanseTo.setText(mArrayList.get(position).getDistanseTo());
        holder.mDistanseBetween.setText(mArrayList.get(position).getDistanseBetween());
        holder.mPrise.setText(mArrayList.get(position).getPrise());


    }



    @Override
    public int getItemCount() {
        return mArrayList.size();
    }
}

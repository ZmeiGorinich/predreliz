package com.romarinichgmail.predreliz.RecyclerViewOrder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.romarinichgmail.predreliz.R;


public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public TextView mCargoName,mFinishPoint,mStartPoint,mDistanseTo,mDistanseBetween,mPrise;


    public RecyclerViewHolder(View itemView) {
        super(itemView);

        mCargoName = itemView.findViewById(R.id.textViewNameCargo);
        mFinishPoint = itemView.findViewById(R.id.textViewFinishPoint);
        mStartPoint = itemView.findViewById(R.id.textViewStartPoint);
        mDistanseTo = itemView.findViewById(R.id.textViewDistanseTo);
        mDistanseBetween = itemView.findViewById(R.id.textViewDistanseBetween);
        mPrise = itemView.findViewById(R.id.textViewPrice);



    }
}

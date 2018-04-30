package com.romarinichgmail.predreliz.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.romarinichgmail.predreliz.Order;
import com.romarinichgmail.predreliz.R;
import com.romarinichgmail.predreliz.RecyclerViewOrder.RecyclerViewAdapter;

import java.util.ArrayList;

public class FragmentOrder extends Fragment {

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    RecyclerView mRecyclerView;
    ArrayList<Order> orderArrayList;
    RecyclerViewAdapter adapter;
    View v;
    private FirebaseAuth mAuth;
    private String userID;


    public FragmentOrder() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_order, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.order_recyclerview);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseFirestore.getInstance();
        orderArrayList= new ArrayList<>();
        mAuth = FirebaseAuth.getInstance();
        userID = mAuth.getCurrentUser().getUid();
        loadDataFormFirebase();
    }

    public void loadDataFormFirebase() {
        if(orderArrayList.size()>0)
            orderArrayList.clear();

        db.collection("order")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        for (DocumentSnapshot querySnapshot: task.getResult()){
                            Order order = new Order(
                                    querySnapshot.getString("start_point"),
                                    querySnapshot.getString("finish_point"),
                                    querySnapshot.getString("distanse"),
                                    querySnapshot.getString("name_cargo"));
                            orderArrayList.add(order);
                        }
                        adapter= new RecyclerViewAdapter(FragmentOrder.this,orderArrayList);
                        mRecyclerView.setAdapter(adapter);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Log.v("------------",e.getMessage());
                    }
                });
    }



}

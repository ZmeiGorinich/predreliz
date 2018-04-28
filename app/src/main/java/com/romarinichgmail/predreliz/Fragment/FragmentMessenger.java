package com.romarinichgmail.predreliz.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.romarinichgmail.predreliz.Messenger;
import com.romarinichgmail.predreliz.R;
import com.romarinichgmail.predreliz.RecyclerViewMessenger.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FragmentMessenger extends Fragment{
    View v;
    private RecyclerView myRecyclerView;
    private List<Messenger> lstMessager;

    public FragmentMessenger(){


    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v= inflater.inflate(R.layout.fragment_messenger,container,false);
        myRecyclerView = (RecyclerView) v.findViewById(R.id.messenger_recyclerview);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(),lstMessager);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myRecyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lstMessager = new ArrayList<>();
        lstMessager.add(new Messenger("Мостоцький","12112312", R.drawable.a1));
        lstMessager.add(new Messenger("Мосиенко","12312312312", R.drawable.a1));
        lstMessager.add(new Messenger("Маринич","124123123", R.drawable.a1));
        lstMessager.add(new Messenger("Кобренко","1231231", R.drawable.a1));
        lstMessager.add(new Messenger("Гончаренко","2131231", R.drawable.a1));
        lstMessager.add(new Messenger("Шапран","12312", R.drawable.a1));
        lstMessager.add(new Messenger("Ишак","123123", R.drawable.a1));
        lstMessager.add(new Messenger("Комарь","12313", R.drawable.a1));
    }
}

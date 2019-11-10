package com.letstravel.fragmentandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import adapter.PlayerAdapter;
import model.PlayerModel;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       


        recyclerView=findViewById(R.id.recyclerview);
        List<PlayerModel> playerModel=new ArrayList<>();
        playerModel.add(new PlayerModel("Neymar JR", "98664302070",R.drawable.neymar));
        playerModel.add(new PlayerModel("Coutinho", "98664302071",R.drawable.coutinho));
        playerModel.add(new PlayerModel("KaKa", "98664302072",R.drawable.kaka));
        playerModel.add(new PlayerModel("Morgan", "98664302073",R.drawable.morgan));
        playerModel.add(new PlayerModel("Solo", "98664302074",R.drawable.solo));
        playerModel.add(new PlayerModel("Messi", "98664302075",R.drawable.messi));


        PlayerAdapter playerAdapter=new PlayerAdapter(this, playerModel);
        recyclerView.setAdapter(playerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

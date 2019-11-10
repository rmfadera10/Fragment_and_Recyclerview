package com.letstravel.fragmentandrecyclerview.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.letstravel.fragmentandrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

import adapter.PlayerAdapter;
import model.PlayerModel;

public class SlideshowFragment extends Fragment {

    private RecyclerView recyclerView;
    private SlideshowViewModel slideshowViewModel;

    public SlideshowFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        recyclerView=root.findViewById(R.id.recyclerview);


        List<PlayerModel> playerModel=new ArrayList<>();
        playerModel.add(new PlayerModel("Neymar JR", "98664302070",R.drawable.neymar));
        playerModel.add(new PlayerModel("Coutinho", "98664302071",R.drawable.coutinho));
        playerModel.add(new PlayerModel("KaKa", "98664302072",R.drawable.kaka));
        playerModel.add(new PlayerModel("Morgan", "98664302073",R.drawable.morgan));
        playerModel.add(new PlayerModel("Solo", "98664302074",R.drawable.solo));
        playerModel.add(new PlayerModel("Messi", "98664302075",R.drawable.messi));


        //PlayerAdapter playerAdapter=new PlayerAdapter(this,playerModel);
        //recyclerView.setAdapter(playerAdapter);
        //recyclerView.setLayoutManager(new LinearLayoutManager);
        return root;

    }
}
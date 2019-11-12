package com.letstravel.fragmentandrecyclerview.ui.slideshow;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.letstravel.fragmentandrecyclerview.R;
import java.util.ArrayList;
import java.util.List;

import adapter.PlayerAdapter;
import model.PlayerModel;

public class SlideshowFragment extends Fragment implements View.OnClickListener{

    EditText etName,etAge;
    RadioButton rbMale, rbFemale, rbOthers;
    Spinner spinner;
    Button btnSave;
    RadioGroup rg;
    RecyclerView recyclerView;
    String gen;
    int img;
    List<PlayerModel> playerModelList = new ArrayList<>();

    public SlideshowFragment(){

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_slideshow, container, false);

        etName=view.findViewById(R.id.etName);
        etAge=view.findViewById(R.id.etAge);
        rbMale=view.findViewById(R.id.rbMale);
        rbFemale=view.findViewById(R.id.rbFemale);
        rbOthers=view.findViewById(R.id.rbOthers);
        btnSave=view.findViewById(R.id.btnSave);
        spinner=view.findViewById(R.id.spinner);
        rg=view.findViewById(R.id.rg);
        recyclerView = view.findViewById(R.id.recyclerView);
        btnSave.setOnClickListener(this);

        String[] images = {"Select Image", "neymar", "coutinho", "kaka", "Morgan", "Solo", "Messi"};
        final ArrayAdapter adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,
                images);
        spinner.setAdapter(adapter);
        return  view;

    }

    @Override
    public void onClick(View v) {
        if(TextUtils.equals(etName.getText().toString(),"")){
            return;
        }
        if(TextUtils.equals(etAge.getText().toString(),"")){
            return;
        }
        if(rbMale.isChecked()){
            gen="Male";
        }
        if(rbFemale.isChecked()){
            gen="Female";
        }
        if(rbOthers.isChecked()){
            gen="Others";
        }
        String image=spinner.getSelectedItem().toString();
        if(image=="neymar"){
            img=  R.drawable.neymar ;
        }
        if(image=="coutinho"){
            img=  R.drawable.coutinho ;
        }
        if(image=="kaka"){
            img=  R.drawable.kaka ;
        }
        if(image=="Morgan"){
            img=  R.drawable.morgan ;
        }
        if(image=="Solo"){
            img=  R.drawable.solo ;
        }
        if(image=="Messi"){
            img=  R.drawable.messi ;
        }


        int age=Integer.parseInt(etAge.getText().toString());

        playerModelList.add(new PlayerModel(etName.getText().toString(), age, gen, img));
        PlayerAdapter playerAdapter = new PlayerAdapter(this,playerModelList);
        recyclerView.setAdapter(playerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        etName.setText("");
        etAge.setText("");
        rbFemale.clearFocus();
        rbOthers.clearFocus();
        rbMale.clearFocus();
        spinner.clearFocus();
    }
}
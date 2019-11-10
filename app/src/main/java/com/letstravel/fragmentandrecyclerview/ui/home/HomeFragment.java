package com.letstravel.fragmentandrecyclerview.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.letstravel.fragmentandrecyclerview.R;

public class HomeFragment extends Fragment implements View.OnClickListener{
    private EditText txtradius;
    private Button btnArea;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        txtradius=root.findViewById(R.id.txtradius);
        btnArea=root.findViewById(R.id.btnArea);
        btnArea.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        int radiuss=Integer.parseInt(txtradius.getText().toString());
        float area=3.14f*radiuss*radiuss;
        Toast.makeText(getActivity(), "Area of Circle =" +area, Toast.LENGTH_SHORT).show();
    }
}
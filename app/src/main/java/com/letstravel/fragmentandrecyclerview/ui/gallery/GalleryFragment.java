package com.letstravel.fragmentandrecyclerview.ui.gallery;

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

public class GalleryFragment extends Fragment implements View.OnClickListener {

    private Button btncalculate;
    private EditText txtfirst, txtsecond;

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        txtfirst=root.findViewById(R.id.fistnumber);
        txtsecond=root.findViewById(R.id.secondnumber);

        btncalculate=root.findViewById(R.id.btncalculate);
        btncalculate.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        int first=Integer.parseInt(txtfirst.getText().toString());
        int second=Integer.parseInt(txtfirst.getText().toString());
        int result=first+second;
        Toast.makeText(getActivity(), "Sum of two number =" +result, Toast.LENGTH_SHORT).show();
    }
}
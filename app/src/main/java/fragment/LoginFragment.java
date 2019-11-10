package fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.letstravel.fragmentandrecyclerview.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText etusername,etpassword;
    private Button btnlogin;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);

        etusername=view.findViewById(R.id.etusername);
        etpassword=view.findViewById(R.id.etpassword);
        btnlogin=view.findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

    }
}

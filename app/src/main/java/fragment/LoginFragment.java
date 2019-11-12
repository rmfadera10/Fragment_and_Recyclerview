package fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.letstravel.fragmentandrecyclerview.Dashboard;
import com.letstravel.fragmentandrecyclerview.R;
import com.letstravel.fragmentandrecyclerview.ui.home.HomeFragment;

import CheckLogin.CheckLogin;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText etusername, etpassword;
    private Button btnlogin;
    private String Username, Password;
    boolean status;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        etusername = view.findViewById(R.id.etusername);
        etpassword = view.findViewById(R.id.etpassword);
        btnlogin = view.findViewById(R.id.btnLogin);

        btnlogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        Username = etusername.getText().toString().trim();

        Password = etpassword.getText().toString().trim();


        if (!TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Username)) {


            CheckLogin checkLogin = new CheckLogin();

            checkLogin.setUsername(Username);

            checkLogin.setPassword(Password);

            status = checkLogin.chkLogin();


            if (status) {

                Toast.makeText(getActivity(), "Login Successful, Welcome: " + Username, Toast.LENGTH_LONG).show();

                etusername.setText("");

                etpassword.setText("");


                /// new activcity


                Intent intent = new Intent(getActivity(), Dashboard.class);

                intent.putExtra(EXTRA_MESSAGE, Username);

                startActivity(intent);


            } else {

                Toast.makeText(getActivity(), "Username && Password did not match", Toast.LENGTH_LONG).show();

                etusername.setText("");

                etpassword.setText("");
            }
        }
    }
}

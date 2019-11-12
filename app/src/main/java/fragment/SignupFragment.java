package fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.letstravel.fragmentandrecyclerview.R;

import java.util.ArrayList;
import java.util.List;

import CheckLogin.CheckLogin;
import User.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment implements View.OnClickListener {

    private EditText etemail, etpass, etcpass;
    private Button btnsignup;
    private ListView listView;
//    ArrayList<String> arrayList;
//    ArrayAdapter<String> arrayAdapter;

    private String Username, Password, CPassword;
    static List<User> userList = new ArrayList<>();

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        etemail = view.findViewById(R.id.etEmail);
        etpass = view.findViewById(R.id.etPass);
        etcpass = view.findViewById(R.id.etCpass);
        listView = view.findViewById(R.id.listview);
        btnsignup = view.findViewById(R.id.btnSignup);
        btnsignup.setOnClickListener(this);

//        arrayList=new ArrayList<String>();
//        arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrayList);
//        listView.setAdapter(arrayAdapter);
            return view;
    }

    @Override
    public void onClick(View v) {
        Username = etemail.getText().toString().trim();

        Password = etpass.getText().toString().trim();

        CPassword = etcpass.getText().toString().trim();


        if (!TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Username)) {

            if (!Password.equals(CPassword)) {

                etcpass.setError("Password Do not match");

                Toast.makeText(getActivity(), "" + Password + " : another : " + CPassword, Toast.LENGTH_LONG).show();

                onStop();

            } else {


                User user = new User();

                user.setUser(Username);

                user.setPass(Password);

                userList.add(user);


                CheckLogin checkLogin = new CheckLogin();

                checkLogin.setUserList(userList);


                for (int i = 0; i < checkLogin.getUserList().size(); i++) {

                    final User userdetail = checkLogin.getUserList().get(i);

                    Toast.makeText(getActivity(), "" + userdetail.getUser(), Toast.LENGTH_SHORT).show();

                }
            }
        }

        Toast.makeText(getActivity(), "Signup Sucessful : " + Username, Toast.LENGTH_LONG).show();

        etemail.setText("");

        etpass.setText("");

        etcpass.setText("");
    }
}

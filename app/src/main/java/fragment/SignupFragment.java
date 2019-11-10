package fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.letstravel.fragmentandrecyclerview.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment implements View.OnClickListener {

    private EditText etemail, etpass, etcpass;
    private Button btnsignup;
    private ListView listView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_signup, container, false);

        etemail=view.findViewById(R.id.etEmail);
        etpass=view.findViewById(R.id.etPass);
        etcpass=view.findViewById(R.id.etCpass);
        listView=view.findViewById(R.id.listview);
        btnsignup=view.findViewById(R.id.btnSignup);
        btnsignup.setOnClickListener(this);

        arrayList=new ArrayList<String>();
        arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);
        return view;
    }

    @Override
    public void onClick(View v) {
        String email=etemail.getText().toString();
        String password=etpass.getText().toString();
        String cpassword=etcpass.getText().toString();
        arrayList.add("Your Email : - "+email);
        arrayList.add("Your Password : -"+password);
       // arrayList.add(cpassword);

        arrayAdapter.notifyDataSetChanged();

    }
}

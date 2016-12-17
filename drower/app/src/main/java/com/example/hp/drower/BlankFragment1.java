package com.example.hp.drower;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment1 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String TAG = "SignupActivity";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText _nameText;
    EditText _emailText;
    EditText _passwordText;
    EditText _confirmPassword;

    Button _signupButton;
    TextView _loginLink;
    EditText _number;



    public BlankFragment1() {
    }


    public static BlankFragment1 newInstance() {
        BlankFragment1 fragment = new BlankFragment1();
        return fragment;
    }
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank_fragment3, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        _nameText = (EditText) view.findViewById(R.id.input_name);
        _emailText = (EditText) view.findViewById(R.id.input_email);
        _passwordText = (EditText) view.findViewById(R.id.input_password);
        _number = (EditText) view.findViewById(R.id.mobilenumber) ;
        _confirmPassword = (EditText) view.findViewById(R.id.input_confirmpassword);


        _signupButton = (Button) view.findViewById(R.id.btn_signup);
        _loginLink = (TextView) view.findViewById(R.id.link_login);
        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                ((MainActivity)getActivity()).calllogin();

            }
        });

        loginDataBaseAdapter=new LoginDataBaseAdapter(getActivity());
        loginDataBaseAdapter=loginDataBaseAdapter.open();

    }
    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }


        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String confirmpassword = _confirmPassword.getText().toString();
        String number = _number.getText().toString();

        // TODO: Implement your own signup logic here.


    }

    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        getActivity().setResult(RESULT_OK, null);

    }

    public void onSignupFailed() {
        Toast.makeText(getActivity(),"Login failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();
        String confirmpassword = _confirmPassword.getText().toString();
        String number = _number.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        if(!password.equals(confirmpassword))
        {
            Toast.makeText(getActivity(), "Password Does Not Matches", Toast.LENGTH_LONG).show();
            valid = false;
        }
        else
        {
            // Save the Data in Database
            loginDataBaseAdapter.insertEntry(email, password, number);
            Toast.makeText(getActivity(), "Account Successfully Created ", Toast.LENGTH_LONG).show();

            _nameText.setText(null);
            _passwordText.setText(null);
            _number.setText(null);
            _confirmPassword.setText(null);
            _emailText.setText(null);
        }


        return valid;
    }
    }




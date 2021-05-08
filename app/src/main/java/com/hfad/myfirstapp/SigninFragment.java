package com.hfad.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.hfad.myfirstapp.dialogs.CheckDialogFragment;
import com.hfad.myfirstapp.model.User;
import com.hfad.myfirstapp.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SigninFragment extends Fragment {
    private TextInputEditText email;
    private TextInputEditText password;
    private List<TextInputEditText> listOfet = new ArrayList<TextInputEditText>();
    private Callback activity;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SigninFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SigninFragment newInstance(String param1, String param2) {
        SigninFragment fragment = new SigninFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

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
        return inflater.inflate(R.layout.fragment_signin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        email   = view.findViewById(R.id.et_email);
        password = view.findViewById(R.id.et_password);
        listOfet.add(email);
        listOfet.add(password);

        TextView toRegistration = (TextView) view.findViewById(R.id.tv_to_registration);
        toRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onRegistrationClick();
            }
        });
        Button signinButton = view.findViewById(R.id.button_enter);
        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailStr = email.getText().toString();
                String passwordStr = password.getText().toString();
                /*Map<String, String> map = new HashMap<>();
                map.put("email", emailStr);
                map.put("password", passwordStr);*/
                List<String> list = Utils.checkFields(listOfet);
                if (list.isEmpty()) {
                    User user = new User(emailStr, passwordStr);
                    String message = requireActivity().getString(R.string.greetings_message);
                    activity.startMainMenuActivity(user, message);
                }
                else {
                    String message = Utils.convertList(list);
                    activity.showDialog(message, getString(R.string.check_dialog_title));
                }
            }
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Callback) context;
    }

    public interface Callback {
        void onRegistrationClick();
        void startMainMenuActivity(User user,String message);
        void showDialog(String message, String title);
    }
}



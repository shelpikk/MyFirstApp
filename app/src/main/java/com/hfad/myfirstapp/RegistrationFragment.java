package com.hfad.myfirstapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.hfad.myfirstapp.model.User;
import com.hfad.myfirstapp.util.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RegistrationFragment extends Fragment {
    private TextInputEditText email;
    private TextInputEditText password;
    private TextInputEditText firstName;
    private TextInputEditText secondName;
    private TextInputEditText confirmedPassword;
    private List<TextInputEditText> listOfet = new ArrayList<TextInputEditText>();
    private Callback activity;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RegistrationFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static RegistrationFragment newInstance(String param1, String param2) {
        RegistrationFragment fragment = new RegistrationFragment();
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
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);
        listOfet.add(email);
        listOfet.add(password);
        listOfet.add(firstName);
        listOfet.add(secondName);
        listOfet.add(confirmedPassword);
        TextView toSignin = (TextView) view.findViewById(R.id.tv_to_signin);
        toSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onSigninClick();
            }
        });

        Button registrationButton = view.findViewById(R.id.button_registration);
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailstr = email.getText().toString();
                String passwordstr = password.getText().toString();
                String firstNamestr = firstName.getText().toString();
                String secondNamestr = secondName.getText().toString();
                String confirmedPasswordstr = confirmedPassword.getText().toString();

                List<String> list = Utils.checkFields(listOfet);

                if (list.isEmpty()) {
                    if (passwordstr.length() > 7 && passwordstr.equals(confirmedPasswordstr)) {
                        User user = new User(emailstr, passwordstr, firstNamestr, secondNamestr);
                        String message = requireActivity().getString(R.string.successful_registration);
                        activity.startMainMenuActivity(user, message);
                    }
                    else {
                        activity.showDialog("Проверьте пароль","Ошибки ввода пароля");
                    }

                }else {
                    String message = Utils.convertList(list);
                    activity.showDialog(message, getString(R.string.check_dialog_title));
                }
            }
        });
    }

    private void bindViews(View view) {
        email = view.findViewById(R.id.et_email);
        password = view.findViewById(R.id.et_password);
        firstName = view.findViewById(R.id.et_firstName);
        secondName = view.findViewById(R.id.et_secondName);
        confirmedPassword = view.findViewById(R.id.et_confPassword);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (Callback) context;
    }

    public interface Callback {
        void onSigninClick();
        void startMainMenuActivity(User user, String message);
        void showDialog(String message, String title);
    }
}
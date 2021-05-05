package com.hfad.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.hfad.myfirstapp.model.User;

public class MainMenuActivity extends AppCompatActivity {
    public static final String USER_KEY = "User";
    public static final String MESSAGE_KEY = "Message";


    private TextView tvUser;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        tvUser = findViewById(R.id.tv_user);
        tvMessage = findViewById(R.id.tv_message);



        Bundle bundle = getIntent().getExtras();
        if (bundle.getParcelable(USER_KEY) != null){
            User user = bundle.getParcelable(USER_KEY);
            tvUser.setText(user.getEmail()+ "\n" + user.getPassword());
        }
        if (bundle.getString(MESSAGE_KEY) != null){
            String message = bundle.getString(MESSAGE_KEY);
            tvMessage.setText(message);
        }
    }
}
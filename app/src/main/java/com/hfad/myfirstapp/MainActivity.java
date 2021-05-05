package com.hfad.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;

import com.hfad.myfirstapp.dialogs.CheckDialogFragment;
import com.hfad.myfirstapp.model.User;

public class MainActivity extends AppCompatActivity implements SigninFragment.Callback, RegistrationFragment.Callback{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container_fragment, new SigninFragment())
                .commit();
    }
    @Override
    public void onRegistrationClick(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new RegistrationFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void startMainMenuActivity(User user, String message) {
        Intent intent = new Intent(this, MainMenuActivity.class);
        intent.putExtra(MainMenuActivity.USER_KEY, user);
        intent.putExtra(MainMenuActivity.MESSAGE_KEY, message);
        startActivity(intent);
    }

    @Override
    public void showDialog(String message, String title) {
        new CheckDialogFragment(message, title).show(getSupportFragmentManager(),CheckDialogFragment.TAG);
    }

    @Override
    public void onSigninClick(){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_fragment, new SigninFragment())
                .addToBackStack(null)
                .commit();
    }
}
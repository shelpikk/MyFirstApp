package com.hfad.myfirstapp.dialogs;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.hfad.myfirstapp.MainActivity;
import com.hfad.myfirstapp.R;

public class CheckDialogFragment extends DialogFragment {

    private String message = "";
    private String title = "";

    public CheckDialogFragment(String message, String title) {
        this.message = message;
        this.title = title;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(requireContext());
        return dialog.setTitle(title)
                .setPositiveButton(R.string.possitive_answer, (d, which) -> { })
                .setMessage(message)
                .create();
    }

    public static String TAG = "CheckDialog";

}


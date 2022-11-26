package com.ruhul.localstorage;

import android.content.Context;
import android.view.View;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class Validation {

    public static boolean editTextValidation(TextInputEditText editText, ConstraintLayout layout, Context context, String s) {

        if (Objects.requireNonNull(editText.getText()).toString().isEmpty()) {
            layout.setBackgroundColor(context.getResources().getColor(R.color.gray,null));
            editText.setError("Required Field");
            return false;
        } else if (!editText.getText().toString().isEmpty() && editText.getText().toString().trim().length() < 3) {
            layout.setBackgroundColor(context.getResources().getColor(R.color.gray,null));
            editText.setError("enter character should be 3 character");
            return false;
        } else {
            layout.setBackgroundColor(context.getResources().getColor(R.color.white,null));
            return true;
        }
    }

}

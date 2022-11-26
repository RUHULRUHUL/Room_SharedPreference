package com.ruhul.localstorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import com.ruhul.localstorage.databinding.ActivityMainBinding;
import com.ruhul.localstorage.room.TodoDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements TodoITemSelectCallback {

    ActivityMainBinding binding;
    private TodoDatabase todoDatabase;

    private TodoAdapter todoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        todoDatabase = TodoDatabase.getInstance(this);
        getTodoList();

        binding.editFlatBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, SecondActivity.class)));
    }

    private void getTodoList() {
        todoDatabase.todoDao().getAllCartData().observe(this, todos -> {

            Toast.makeText(this, "list Size: "+todos.size(), Toast.LENGTH_SHORT).show();

            todoAdapter = new TodoAdapter(todos, MainActivity.this);
            binding.todoRV.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
            binding.todoRV.setAdapter(todoAdapter);

        });
    }

    @Override
    public void itemSelect(Todo todo) {
        Toast.makeText(this, "Select: " + todo.getTodoTitle() + "Description: " + todo.getTodoDescription(), Toast.LENGTH_SHORT).show();
    }

/*    private void displayAge(int year, int monthOfYear, int dayOfMonth) {
        Date dateOfBirthFormat = new Date();
        Date currentDate = new Date();

        String dateOfBirth = Objects.requireNonNull(binding.editText.getText()).toString().trim();

        Log.d("BirthDate", "year: " + year);
        Log.d("BirthDate", "month: " + monthOfYear);
        Log.d("BirthDate", "date : " + dayOfMonth);

        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            dateOfBirthFormat = simpleDateFormat.parse(dateOfBirth);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        assert dateOfBirthFormat != null;
        long diff = currentDate.getTime() - dateOfBirthFormat.getTime();

        int totalDay = (int) (diff / (1000 * 60 * 60 * 24));

        //get total  Year
        int numOfYear = totalDay / 365;
        int day = totalDay - (numOfYear * 365);

        //get total Month
        int month = day / 30;
        int moreDay = day  - month*30;

        //get total Hours minutes second
        int hour = currentDate.getHours();
        int minutes = (int) currentDate.getMinutes();
        int second = (int) currentDate.getSeconds();


        Log.d("BirthDate", "totalDay: " + totalDay);
        Log.d("BirthDate", "year: " + numOfYear);
         Log.d("BirthDate", "month: " + month);
        Log.d("BirthDate", "date : " + moreDay);
        Log.d("BirthDate", "hours : " + hour);
        Log.d("BirthDate", "minutes : " + minutes);
        Log.d("BirthDate", "second : " + second);

    }


    public class LiveValidation implements TextWatcher {

        private final View view;

        public LiveValidation(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            switch (view.getId()) {
                case R.id.editText:
                    Validation.editTextValidation(binding.editText, binding.layout, context, "");
                    break;
                case R.id.submitBtn:
                default:
                    break;
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }*/
}
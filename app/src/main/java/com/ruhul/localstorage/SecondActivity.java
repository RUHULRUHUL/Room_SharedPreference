package com.ruhul.localstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.ruhul.localstorage.databinding.ActivityMainBinding;
import com.ruhul.localstorage.databinding.ActivitySecondBinding;
import com.ruhul.localstorage.room.TodoDatabase;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

import javax.xml.validation.Validator;

public class SecondActivity extends AppCompatActivity {
    ActivitySecondBinding binding;
    public static TodoDatabase todoDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        todoDatabase = TodoDatabase.getInstance(this);

        binding.title.addTextChangedListener(new LiveValidation(binding.title));
        binding.description.addTextChangedListener(new LiveValidation(binding.description));


        binding.submitBtn.setOnClickListener(view -> {

            if (Validation.editTextValidation(binding.title, binding.titleLayout, SecondActivity.this, "required field")
                    && Validation.editTextValidation(binding.description, binding.descriptionLayout, SecondActivity.this, "required field")) {

                Todo todo = new Todo(Objects.requireNonNull(binding.title.getText()).toString(), Objects.requireNonNull(binding.description.getText()).toString());

                new InsertTodo().execute(todo);

            }
        });

    }

    private static class InsertTodo extends AsyncTask<Todo, Void, Void> {
        @Override
        protected Void doInBackground(Todo... todos) {
            todoDatabase.todoDao().insertTodo(todos[0]);
            return null;
        }
    }


    public class LiveValidation implements TextWatcher {

        private View view;

        public LiveValidation(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            switch (view.getId()) {
                case R.id.title: {
                    Validation.editTextValidation(binding.title, binding.titleLayout, SecondActivity.this, "required field");
                    break;
                }
                case R.id.description: {
                    Validation.editTextValidation(binding.description, binding.descriptionLayout, SecondActivity.this, "required field");
                    break;
                }
                default: {
                    break;
                }
            }

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
}
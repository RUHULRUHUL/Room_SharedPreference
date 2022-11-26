package com.ruhul.localstorage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ruhul.localstorage.databinding.TodoRowitemBinding;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private List<Todo> todoList;
    private TodoITemSelectCallback callback;

    public TodoAdapter(List<Todo> todoList, TodoITemSelectCallback iTemSelectCallback) {
        this.todoList = todoList;
        this.callback = iTemSelectCallback;
    }

    @NonNull
    @Override
    public TodoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(TodoRowitemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.ViewHolder holder, int position) {
        holder.binding.todoTitle.setText(todoList.get(holder.getAdapterPosition()).getTodoTitle());
        holder.binding.todoDescription.setText(todoList.get(holder.getAdapterPosition()).getTodoDescription());

        holder.binding.rootLayout.setOnClickListener(view -> {
            callback.itemSelect(todoList.get(holder.getAdapterPosition()));
        });
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TodoRowitemBinding binding;

        public ViewHolder(TodoRowitemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

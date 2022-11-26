package com.ruhul.localstorage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "TodoTable")
public class Todo {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("title")
    @ColumnInfo(name = "title")
    private String todoTitle;

    @SerializedName("description")
    @ColumnInfo(name = "description")
    private String todoDescription;

    public Todo(String todoTitle, String todoDescription) {
        this.todoTitle = todoTitle;
        this.todoDescription = todoDescription;
    }

    public String getTodoTitle() {
        return todoTitle;
    }

    public void setTodoTitle(String todoTitle) {
        this.todoTitle = todoTitle;
    }

    public String getTodoDescription() {
        return todoDescription;
    }

    public void setTodoDescription(String todoDescription) {
        this.todoDescription = todoDescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

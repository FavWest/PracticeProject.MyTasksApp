package com.favwest.mytasksapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Task> tasks = new ArrayList<>();
    ListView listView;
    TaskAdapter<Task> taskAdapter;
    EditText enterTask;
    EditText enterPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tasks.add(new Task ("Dishes", "high"));
        tasks.add(new Task("Clean kitchen", "high"));

        //TODO fix - ArrayAdapter -> TaskAdapter
        /*TODO after I did this, it no longer works correctly:
        *  clicking "Save Task" causes all tasks in the list to disappear*/
        //Display a checkbox for each item from the tasks ArrayList
        TaskAdapter<Task> taskAdapter = new TaskAdapter<Task>(this, tasks);
        listView = findViewById(R.id.tasksList);
        listView.setAdapter(taskAdapter);

        //Get the enterTask EditText and the enterPriority EditText
        enterTask = findViewById(R.id.enterTask);
        enterPriority = findViewById(R.id.enterPriority);
    }

    //The saveTasks Button updates the tasks ArrayList and displays the updated list
    public void updateTasks(View view) {
        tasks.add(new Task(enterTask.getText().toString(), enterPriority.getText().toString()));
        listView.setAdapter(new TaskAdapter<Task>(this, tasks));
        enterTask.setText("");
        enterPriority.setText("");
    }



}
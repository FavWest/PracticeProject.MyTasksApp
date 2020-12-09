package com.favwest.mytasksapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import com.favwest.mytasksapp.Task;

public class TaskAdapter<T> extends ArrayAdapter<Task> {
    public TaskAdapter(Activity context, ArrayList<Task> tasks){
        super(context, 0, tasks);
    }

    // Check if the existing view is being reused, otherwise inflate the view
    // Copied from Udacity (https://github.com/udacity/ud839_CustomAdapter_Example)
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.checkbox_item_list, parent, false);
        }

        Task currentTask = getItem(position);

        TextView displayTask = listItemView.findViewById(R.id.displayTask);
        displayTask.setText(currentTask.getTask());

        TextView displayPriority = listItemView.findViewById(R.id.displayPriority);
        displayPriority.setText("Priority: " + currentTask.getPriority());
        return listItemView;

    }
}

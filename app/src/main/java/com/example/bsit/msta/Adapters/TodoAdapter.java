package com.example.bsit.msta.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.example.bsit.msta.Entities.ToDo;
import com.example.bsit.msta.R;

import java.util.ArrayList;

/**
 * Created by BSIT on 3/30/2016.
 */
public class TodoAdapter extends ArrayAdapter<ToDo>{

    public TodoAdapter(Context context,ArrayList<ToDo> todo) {
        super(context, 0, todo);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ToDo todo = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_teacher_home, parent, false);
        }
        // Lookup view for data population
        EditText etNewItem = (EditText) convertView.findViewById(R.id.etNewItem);

        // Populate the data into the template view using the data object
//        tvName.setText(user.name);
//        tvHome.setText(user.hometown);
        // Return the completed view to render on screen
        return convertView;
    }



}

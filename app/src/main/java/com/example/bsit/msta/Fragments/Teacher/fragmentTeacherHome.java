package com.example.bsit.msta.Fragments.Teacher;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.bsit.msta.R;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by BSIT on 3/10/2016.
 */
public class fragmentTeacherHome extends Fragment implements AdapterView.OnItemClickListener{

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;
    EditText etNewItem;
    Button mAdd;
    public int pos;

    public fragmentTeacherHome() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //to Inflate fragment
        RelativeLayout inflates = (RelativeLayout) inflater.inflate(R.layout.fragment_teacher_home, container, false);

        readItems();
        etNewItem = (EditText) inflates.findViewById(R.id.etNewItem);
        lvItems = (ListView) inflates.findViewById(R.id.lvItems);
        mAdd = (Button) inflates.findViewById(R.id.btnAddItem);
        mAdd.setOnClickListener(onAddItem);

        lvItems.setOnItemClickListener(onDeleteItem);

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        setupListViewListener();

        return inflates;

    }

    private View.OnClickListener onAddItem = new View.OnClickListener() {
        public void onClick(View v){
        addItem();
        }
    };

    private AdapterView.OnItemClickListener onDeleteItem = new AdapterView.OnItemClickListener(){
        public void onItemClick(AdapterView<?> a, View v, int position, long id) {

            pos = position;
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
            alertDialog.setTitle("Confirm Delete...");
            alertDialog.setMessage("Are you sure you want delete this?");
            alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog,int which) {

                    // Write your code here to invoke YES event
                    items.remove(pos);
                    itemsAdapter.notifyDataSetChanged();
                    itemsAdapter.notifyDataSetInvalidated();
                }
            });

            // Setting Negative "NO" Button
            alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to invoke NO event
                    dialog.cancel();
                }
            });

            alertDialog.show();
        }
    };

    public void addItem() {
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
        Toast.makeText(getContext(),"To Do Added",Toast.LENGTH_SHORT).show();
        writeItems();
    }



    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        items.remove(pos);
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        writeItems();
                        return true;
                    }

                });
    }

    private void readItems() {
        File filesDir = getActivity().getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todoFile));
        } catch (IOException e) {
            items = new ArrayList<String>();
        }
    }

    private void writeItems() {
        File filesDir = getActivity().getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        pos = position;

        items.remove(pos);
        itemsAdapter.notifyDataSetChanged();
        itemsAdapter.notifyDataSetInvalidated();
        Toast.makeText(getContext(), "To Do Finish... Deleted", Toast.LENGTH_SHORT).show();

    }
}

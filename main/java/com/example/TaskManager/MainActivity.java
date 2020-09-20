package com.example.TaskManager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.TaskManager.R.id.*;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private EditText itemET;

    private ArrayList<String> items;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); itemET = findViewById(edit_text); Button btn = findViewById(add_button);
        ArrayList<String> itemsList= new ArrayList<>();
        itemsList.add("one");
        itemsList.add("two");
        itemsList.add("three");
        itemsList.add("four");







        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemsList);

        btn.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case add_button:
                String itemEntered = itemET.getText().toString();
                adapter.add(itemEntered);
                itemET.setText("");

                Toast.makeText(this, "Task added", Toast.LENGTH_SHORT).show();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + v.getId());
        }

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        items.remove(position);
        adapter.notifyDataSetChanged();
        FileHelper.writeData(this);
        Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();

    }
}
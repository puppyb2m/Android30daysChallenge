package com.example.shunzhang.day1;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<TaskModel> modelList = new ArrayList<>();
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // floating button
        FloatingActionButton floatingButton = (FloatingActionButton) findViewById(R.id.fab_add_task);
        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivity(intent);
            }
        });

        // listview
        RecyclerView listView = (RecyclerView) findViewById(R.id.task_listview);

        // laoutmanager
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        listView.setItemAnimator(new DefaultItemAnimator());
        listView.setLayoutManager(manager);

        // adapter
        adapter = new TaskAdapter(modelList);
        listView.setAdapter(adapter);

        initModel();
    }

    private void initModel(){
        // model
        TaskModel model = new TaskModel("title 1 ",true);
        TaskModel model2 = new TaskModel("title 2 ",true);
        TaskModel model3 = new TaskModel("title 3 ",true);

        modelList.add(model);
        modelList.add(model2);
        modelList.add(model3);

        adapter.notifyDataSetChanged();
    }
}

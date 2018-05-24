package com.example.shunzhang.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<TaskModel> modelList = new ArrayList<>();
    private TaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

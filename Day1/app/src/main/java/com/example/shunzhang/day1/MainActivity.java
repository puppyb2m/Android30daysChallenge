package com.example.shunzhang.day1;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.shunzhang.day1.API.APIInterface;
import com.example.shunzhang.day1.API.ApiClient;
import com.example.shunzhang.day1.Model.MovieModel;
import com.example.shunzhang.day1.Model.MovieResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<TaskModel> modelList = new ArrayList<>();
    private List<MovieModel> movies = new ArrayList<>();
    private TaskAdapter adapter;
    private final static String API_KEY = "15d347a71dd5bbb5315dad6dcc269815";
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Navigator.INSTANCE.navigateToAddTask(this);
        // floating button
        FloatingActionButton floatingButton = (FloatingActionButton) findViewById(R.id.fab_add_task);
        floatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // basic move activity
//                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
//                startActivity(intent);

                // advanced move activity
//                Navigator.INSTANCE.navigateToAddTask(MainActivity.this);
                Navigator.INSTANCE.navigateToDemo(MainActivity.this);
            }
        });

        // listview
        RecyclerView listView = (RecyclerView) findViewById(R.id.task_listview);

        // laoutmanager
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getApplicationContext());
        listView.setItemAnimator(new DefaultItemAnimator());
        listView.setLayoutManager(manager);

        // adapter
        adapter = new TaskAdapter(movies);
        adapter.setOnItemClickLitener(new TaskAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, "这是条目"+modelList.get(position).getTitle(), Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(adapter);

        // FIRST REQUEST
        firstRequest();
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

    private void firstRequest(){
        if (API_KEY.isEmpty()) {
            Toast.makeText(this.getApplicationContext(), "No API key", Toast.LENGTH_LONG).show();
            return ;
        }


        // create api Client
        APIInterface client = ApiClient.getClient().create(APIInterface.class);

        // use which request
        Call<MovieResponse> call = client.getTopRatedMovie(API_KEY);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                adapter.updateModel(response.body().getResults());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });

    }
}

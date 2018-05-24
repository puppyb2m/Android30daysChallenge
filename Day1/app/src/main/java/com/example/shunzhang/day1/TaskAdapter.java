package com.example.shunzhang.day1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by shunzhang on 23/05/2018.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.title.setText("this is text");

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public TaskViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.task_title);
        }
    }
}

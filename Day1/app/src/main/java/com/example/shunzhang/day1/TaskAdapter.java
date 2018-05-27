package com.example.shunzhang.day1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by shunzhang on 23/05/2018.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    List<TaskModel> model;
    private OnItemClickLitener   mOnItemClickLitener;

    public interface OnItemClickLitener{
        void onItemClick(View view, int position);
    }

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener){
        this.mOnItemClickLitener = mOnItemClickLitener;
    }

    public TaskAdapter(List<TaskModel> model){
        this.model = model;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item,parent,false);
        return new TaskViewHolder(viewHolder);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, final int position) {

        holder.title.setText(model.get(position).getTitle());

        if (mOnItemClickLitener != null) {
            holder.title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickLitener.onItemClick(view, position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public TaskViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.task_title);
        }
    }
}

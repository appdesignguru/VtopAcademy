package com.vtopacademy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.vtopacademy.R;
import com.vtopacademy.core.OnItemClickListener;
import com.vtopacademy.entities.Topic;
import java.util.List;

public class TopicAdapter extends RecyclerView.Adapter<TopicAdapter.TopicHolder> {

    private final List<Topic> topics;
    private final OnItemClickListener<Topic> onItemClickListener;

    public TopicAdapter(List<Topic> topics, OnItemClickListener<Topic> onItemClickListener){
        this.topics = topics;
        this.onItemClickListener = onItemClickListener;
    }

    protected static class TopicHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private Topic topic;
        private OnItemClickListener<Topic> onItemClickListener;

        public TopicHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(CLickedView -> onItemClickListener.onItemClick(topic));
            textView = itemView.findViewById(R.id.name_text_view);
        }

        public void bind(Topic topic, OnItemClickListener<Topic> onItemClickListener){
            this.topic = topic;
            textView.setText(topic.getName());
            this.onItemClickListener = onItemClickListener;
        }
    }

    @NonNull
    @Override
    public TopicAdapter.TopicHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_topic, viewGroup, false);
        return new TopicAdapter.TopicHolder(view);
    }

    @Override
    public void onBindViewHolder(TopicAdapter.TopicHolder holder, final int position) {
        holder.bind(topics.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return topics.size();
    }
}
package com.vtopacademy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.vtopacademy.R;
import com.vtopacademy.core.OnItemClickListener;
import com.vtopacademy.entities.Video;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoHolder> {

    private final List<Video> videos;
    private final OnItemClickListener<Video> onItemClickListener;

    public VideoAdapter(List<Video> videos, OnItemClickListener<Video> onItemClickListener){
        this.videos = videos;
        this.onItemClickListener = onItemClickListener;
    }

    protected static class VideoHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private Video video;
        private OnItemClickListener<Video> onItemClickListener;

        public VideoHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(CLickedView -> onItemClickListener.onItemClick(video));
            textView = itemView.findViewById(R.id.title_text_view);
        }

        public void bind(Video video, OnItemClickListener<Video> onItemClickListener){
            this.video = video;
            textView.setText(video.getTitle());
            this.onItemClickListener = onItemClickListener;
        }
    }

    @NonNull
    @Override
    public VideoAdapter.VideoHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_video, viewGroup, false);
        return new VideoAdapter.VideoHolder(view);
    }

    @Override
    public void onBindViewHolder(VideoAdapter.VideoHolder holder, final int position) {
        holder.bind(videos.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }
}
package com.vtopacademy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.vtopacademy.R;
import com.vtopacademy.core.OnItemClickListener;
import com.vtopacademy.entities.Subject;
import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectHolder> {

    private final List<Subject> subjects;
    private final OnItemClickListener<Subject> onItemClickListener;

    public SubjectAdapter(List<Subject> subjects, OnItemClickListener<Subject> onItemClickListener){
        this.subjects = subjects;
        this.onItemClickListener = onItemClickListener;
    }

    protected static class SubjectHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private Subject subject;
        private OnItemClickListener<Subject> onItemClickListener;

        public SubjectHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(CLickedView -> onItemClickListener.onItemClick(subject));
            textView = itemView.findViewById(R.id.text_view);
        }

        public void bind(Subject subject, OnItemClickListener<Subject> onItemClickListener){
            this.subject = subject;
            textView.setText(subject.getName());
            this.onItemClickListener = onItemClickListener;
        }
    }

    @NonNull
    @Override
    public SubjectAdapter.SubjectHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_subject, viewGroup, false);
        return new SubjectAdapter.SubjectHolder(view);
    }

    @Override
    public void onBindViewHolder(SubjectAdapter.SubjectHolder holder, final int position) {
        holder.bind(subjects.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }
}
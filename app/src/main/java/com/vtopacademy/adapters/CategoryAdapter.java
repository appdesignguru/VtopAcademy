package com.vtopacademy.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.vtopacademy.R;
import com.vtopacademy.core.OnItemClickListener;
import com.vtopacademy.entities.Category;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {

    private final List<Category> categories;
    private final OnItemClickListener<Category> onItemClickListener;

    public CategoryAdapter(List<Category> categories, OnItemClickListener<Category> onItemClickListener){
        this.categories = categories;
        this.onItemClickListener = onItemClickListener;
    }

    protected static class CategoryHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private Category category;
        private OnItemClickListener<Category> onItemClickListener;

        public CategoryHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(CLickedView -> onItemClickListener.onItemClick(category));
            textView = itemView.findViewById(R.id.text_view);
        }

        public void bind(Category category, OnItemClickListener<Category> onItemClickListener){
            this.category = category;
            textView.setText(category.getName());
            this.onItemClickListener = onItemClickListener;
        }
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_category, viewGroup, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(CategoryHolder holder, final int position) {
        holder.bind(categories.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}


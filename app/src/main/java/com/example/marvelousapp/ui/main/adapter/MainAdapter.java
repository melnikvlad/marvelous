package com.example.marvelousapp.ui.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvelousapp.R;
import com.example.marvelousapp.ui.main.adapter.items.ComicsListItem;
import com.example.marvelousapp.ui.main.adapter.items.HeaderListItem;
import com.example.marvelousapp.ui.main.adapter.items.ParentListItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<ParentListItem> items = new ArrayList<>();

    public MainAdapter(Context context) {
        this.context = context;
    }

    public void add(@NonNull ParentListItem... listItemArgs) {
        int position = items.size();
        items.addAll(Arrays.asList(listItemArgs));
        notifyItemRangeInserted(position, listItemArgs.length);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final RecyclerView.ViewHolder viewHolder;
        if (viewType == ParentListItem.Category.HEADER.getId()) {
            viewHolder = new HeaderViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.card_inner_rv_header, parent, false));
        } else {
            viewHolder = new GroupViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.card_inner_rv_item, parent, false));
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == ParentListItem.Category.HEADER.getId()) {
            ((HeaderViewHolder) holder).bind((HeaderListItem) items.get(position));
        } else {
            ((GroupViewHolder) holder).bind(items.get(position));
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getCategory().getId();
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView tvHeader;

        HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHeader = itemView.findViewById(R.id.tvHeader);
        }

        void bind(@NonNull HeaderListItem item) {
            tvHeader.setText(item.getResId());
        }
    }

    class GroupViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerView);
            recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false));
        }

        void bind(@NonNull ParentListItem item) {
            if (item.getData() != null) {
                if (item.getData().size() > 0) {
                    BaseChildAdapter childAdapter = item instanceof ComicsListItem
                            ? new ComicsAdapter()
                            : new CharacterAdapter();
                    childAdapter.setData(item.getData());
                    childAdapter.addMoreButton();
                    recyclerView.setAdapter(childAdapter);
                }
            }
        }
    }
}

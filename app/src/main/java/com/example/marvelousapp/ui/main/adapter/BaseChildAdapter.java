package com.example.marvelousapp.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvelousapp.R;
import com.example.marvelousapp.data.models.BaseItem;
import com.example.marvelousapp.data.models.characters.CharacterItem;
import com.example.marvelousapp.data.models.comics.ComicsItem;
import com.example.marvelousapp.internals.enums.ImageSizeType;
import com.example.marvelousapp.internals.utils.ImageUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseChildAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull
    protected List<BaseItem> list = new ArrayList<>();

    @LayoutRes
    protected abstract int getMoreButtonLayoutId();

    void setData(@NonNull List<BaseItem> newList) {
        list.clear();
        list.addAll(newList);
    }

    void addMoreButton() {
        list.add(new BaseItem(BaseItem.ListItemType.MORE));
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MoreViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(getMoreButtonLayoutId(), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == BaseItem.ListItemType.MORE.getId()) {
            ((MoreViewHolder) holder).itemView.setOnClickListener((v) -> { /* do nothing now */});
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType().getId();
    }

    class MoreViewHolder extends RecyclerView.ViewHolder {
        MoreViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}

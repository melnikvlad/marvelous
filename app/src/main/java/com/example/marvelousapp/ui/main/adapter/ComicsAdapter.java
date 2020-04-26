package com.example.marvelousapp.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvelousapp.R;
import com.example.marvelousapp.data.models.BaseItem;

public final class ComicsAdapter extends BaseChildAdapter {

    @Override
    protected int getMoreButtonLayoutId() {
        return R.layout.card_comics_more_button;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == BaseItem.ListItemType.CHARACTER.getId()) {
            return new MoreViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(getMoreButtonLayoutId(), parent, false));
        } else {
            return super.onCreateViewHolder(parent, viewType);
        }
    }
}

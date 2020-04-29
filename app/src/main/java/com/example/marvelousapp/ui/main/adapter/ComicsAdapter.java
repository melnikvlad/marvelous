package com.example.marvelousapp.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvelousapp.R;
import com.example.marvelousapp.data.models.BaseItem;
import com.example.marvelousapp.data.models.comics.ComicsItem;
import com.example.marvelousapp.internals.enums.ImageSizeType;
import com.example.marvelousapp.internals.utils.ImageUtils;
import com.squareup.picasso.Picasso;

import rx.functions.Action1;

public final class ComicsAdapter extends BaseChildAdapter {

    ComicsAdapter(@NonNull Action1<BaseItem> onComicsClickAction) {
        onCardClickAction = onComicsClickAction;
    }

    @Override
    protected int getMoreButtonLayoutId() {
        return R.layout.card_comics_more_button;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == BaseItem.ListItemType.COMICS.getId()) {
            return new ComicsViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.comics_list_card, parent, false));
        }
        return super.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == BaseItem.ListItemType.COMICS.getId()) {
            if (list.size() > 0) {
                final ComicsItem item = (ComicsItem) list.get(holder.getAdapterPosition());
                ((ComicsViewHolder) holder).bind(item);
                ((ComicsViewHolder) holder).itemView.setOnClickListener((v) -> onCardClickAction.call(item));
            }
        } else {
            super.onBindViewHolder(holder, position);
        }
    }

    private class ComicsViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView icon;
        private TextView tvTitle;
        private TextView tvDescription;

        ComicsViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.image);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }

        void bind(@NonNull ComicsItem item) {
            if (item.getImages().get(0) != null) {
                Picasso.get()
                        .load(ImageUtils.createImagePath(item.getImages().get(0), ImageSizeType.PORTRAIT_XLARGE))
                        .into(icon);
            }
            tvTitle.setText(item.getTitle());
            tvDescription.setText(item.getDescription());
        }
    }
}

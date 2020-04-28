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
import com.example.marvelousapp.data.models.characters.CharacterItem;
import com.example.marvelousapp.internals.enums.ImageSizeType;
import com.example.marvelousapp.internals.utils.ImageUtils;
import com.squareup.picasso.Picasso;

public final class CharacterAdapter extends BaseChildAdapter {
    @Override
    protected int getMoreButtonLayoutId() {
        return R.layout.card_characters_more_button;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == BaseItem.ListItemType.CHARACTER.getId()) {
            return new CharacterViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.character_list_card, parent, false));
        }  else {
            return super.onCreateViewHolder(parent, viewType);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == BaseItem.ListItemType.CHARACTER.getId()) {
            if (list.size() > 0) {
                final CharacterItem item = (CharacterItem) list.get(holder.getAdapterPosition());
                ((CharacterViewHolder) holder).bind(item);
                ((CharacterViewHolder) holder).itemView.setOnClickListener((v) -> { /* do nothing now */ });
            }
        } else {
            super.onBindViewHolder(holder, position);
        }
    }

    private class CharacterViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView icon;
        private TextView tvName;

        CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.image);
            tvName = itemView.findViewById(R.id.tvName);
        }

        void bind(@NonNull CharacterItem item) {
            if (item.getImage() != null) {
                Picasso.get()
                        .load(ImageUtils.createImagePath(item.getImage(), ImageSizeType.PORTRAIT_SMALL))
                        .into(icon);
            }
            tvName.setText(item.getName());
        }
    }
}

package com.example.marvelousapp.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.marvelousapp.R;
import com.example.marvelousapp.data.models.characters.CharacterItem;
import com.example.marvelousapp.internals.enums.ImageSizeType;
import com.example.marvelousapp.internals.utils.ImageUtils;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public final class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NonNull
    private List<CharacterItem> list = new ArrayList<>();

    public void setData(@NonNull List<CharacterItem> newList) {
        list.clear();
        list.addAll(newList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BaseViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (list.size() > 0) {
            final CharacterItem item = list.get(holder.getAdapterPosition());
            ((BaseViewHolder) holder).bind(item);
            ((BaseViewHolder) holder).cardView.setOnClickListener((v) -> {
            });
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BaseViewHolder extends RecyclerView.ViewHolder {
        private CardView cardView;
        private AppCompatImageView icon;
        private TextView tvName;

        BaseViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
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

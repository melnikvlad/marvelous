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
    private List<BaseItem> list = new ArrayList<>();

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
        RecyclerView.ViewHolder viewHolder;
        if (viewType == BaseItem.ListItemType.CHARACTER.getId()) {
            viewHolder = new CharacterViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card, parent, false));
        } else {
            viewHolder = new ComicsViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(R.layout.comics_list_card, parent, false));
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == BaseItem.ListItemType.CHARACTER.getId()) {
            if (list.size() > 0) {
                final CharacterItem item = (CharacterItem) list.get(holder.getAdapterPosition());
                ((CharacterViewHolder) holder).bind(item);
                ((CharacterViewHolder) holder).itemView.setOnClickListener((v) -> {
                });
            }
        } else if (holder.getItemViewType() == BaseItem.ListItemType.COMICS.getId()) {
            if (list.size() > 0) {
                final ComicsItem item = (ComicsItem) list.get(holder.getAdapterPosition());
                ((ComicsViewHolder) holder).bind(item);
                ((ComicsViewHolder) holder).itemView.setOnClickListener((v) -> {
                });
            }
        } else {
            ((MoreViewHolder) holder).itemView.setOnClickListener((v) -> {
            });
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

    class CharacterViewHolder extends RecyclerView.ViewHolder {
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

    class ComicsViewHolder extends RecyclerView.ViewHolder {
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

package com.example.marvelousapp.data.models.comics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.BaseItem;
import com.example.marvelousapp.data.models.ReferenceData;
import com.example.marvelousapp.data.models.common.ImageData;
import com.example.marvelousapp.data.models.common.ReferenceInfo;

import java.util.List;

public final class ComicsItem extends BaseItem {

    private int id;
    @NonNull
    private String title;
    @NonNull
    private String description;
    @NonNull
    private List<String> creators;
    private int issueNumber;
    @NonNull
    private List<String> prices;
    @NonNull
    private List<ReferenceData> series;
    @NonNull
    private List<ImageData> images;

    public ComicsItem(int id, @NonNull String title, @NonNull String description,
                      @NonNull List<String> creators, int issueNumber, @NonNull List<String> prices, @NonNull List<ReferenceData> series,
                      @NonNull List<ImageData> images) {
        super(ListItemType.COMICS);
        this.id = id;
        this.title = title;
        this.description = description;
        this.creators = creators;
        this.issueNumber = issueNumber;
        this.prices = prices;
        this.series = series;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    @NonNull
    public List<String> getCreators() {
        return creators;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @NonNull
    public List<String> getPrices() {
        return prices;
    }

    @NonNull
    public List<ReferenceData> getSeries() {
        return series;
    }

    @NonNull
    public List<ImageData> getImages() {
        return images;
    }
}

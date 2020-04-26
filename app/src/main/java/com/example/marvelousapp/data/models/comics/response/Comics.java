package com.example.marvelousapp.data.models.comics.response;

import androidx.annotation.Nullable;

import com.example.marvelousapp.data.models.ReferenceData;
import com.example.marvelousapp.data.models.common.Creators;
import com.example.marvelousapp.data.models.common.ImageData;
import com.example.marvelousapp.data.models.common.ReferenceInfo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class Comics {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    @Nullable
    private String title;
    @SerializedName("issueNumber")
    private int issueNumber;
    @SerializedName("variantDescription")
    @Nullable
    private String variantDescription;
    @SerializedName("description")
    @Nullable
    private String description;
    @SerializedName("images")
    @Nullable
    private List<ImageData> imageList;
    @SerializedName("prices")
    @Nullable
    private List<ComicsPrice> priceList;
    @SerializedName("series")
    @Nullable
    private ReferenceInfo series;
    @SerializedName("creators")
    @Nullable
    private Creators creators;

    public boolean isValid() {
        return title != null
                && description != null
                && imageList != null && imageList.size() > 0
                && series != null;
    }

    public int getId() {
        return id;
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Nullable
    public String getVariantDescription() {
        return variantDescription;
    }

    @Nullable
    public String getDescription() {
        return description;
    }

    @Nullable
    public List<ImageData> getImageList() {
        return imageList;
    }

    @Nullable
    public List<ComicsPrice> getPriceList() {
        return priceList;
    }

    @Nullable
    public ReferenceInfo getSeries() {
        return series;
    }

    @Nullable
    public Creators getCreators() {
        return creators;
    }
}

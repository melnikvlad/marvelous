package com.example.marvelousapp.ui.main.adapter;

import androidx.annotation.StringRes;

public final class HeaderListItem extends ParentListItem {
    @StringRes
    private int resId;

    public HeaderListItem(@StringRes int resId) {
        super(Category.HEADER);
        this.resId = resId;
    }

    int getResId() {
        return resId;
    }
}

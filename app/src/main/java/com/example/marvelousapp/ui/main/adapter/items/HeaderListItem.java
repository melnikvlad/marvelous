package com.example.marvelousapp.ui.main.adapter.items;

import androidx.annotation.StringRes;

public final class HeaderListItem extends ParentListItem {
    @StringRes
    private int resId;

    public HeaderListItem(@StringRes int resId) {
        super(Category.HEADER);
        this.resId = resId;
    }

    public int getResId() {
        return resId;
    }
}

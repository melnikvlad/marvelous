package com.example.marvelousapp.data.models;

import androidx.annotation.NonNull;

public class BaseItem {
    @NonNull
    protected ListItemType type;

    public BaseItem(@NonNull ListItemType type) {
        this.type = type;
    }

    @NonNull
    public ListItemType getType() {
        return type;
    }

    public enum ListItemType {
        CHARACTER(0),
        COMICS(1),
        TITLE(2),
        MORE(3);

        private int id;

        ListItemType(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}

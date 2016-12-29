package com.github.shaigem.linkgem.model.item;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created on 2016-12-21.
 */
public class BookmarkItem extends Item {

    private StringProperty location;

    public BookmarkItem(String name, String description, String location) {
        super(name, description);
        this.location = new SimpleStringProperty(location);
    }

    public StringProperty locationProperty() {
        return location;
    }

    public String getLocation() {
        return location.get();
    }
}

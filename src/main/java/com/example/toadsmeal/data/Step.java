package com.example.toadsmeal.data;

import javafx.scene.image.Image;
import java.util.ArrayList;
import java.util.List;

public class Step {
    private String description;
    public final List<Image> images = new ArrayList<>();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

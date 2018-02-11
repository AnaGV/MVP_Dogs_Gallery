package com.dogapi.something.data.entity;

import java.util.List;

/**
 * Created by ana on 08-02-18.
 */

public class ImageBreedEntity {
    public String status;
    public List<String> message;

    public ImageBreedEntity(String status, List<String> message) {
        this.status = status;
        this.message = message;
    }
}

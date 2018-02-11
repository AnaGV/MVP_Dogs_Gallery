package com.dogapi.something.data.repository.mapper;

import com.dogapi.core.data.repository.mapper.Mapper;
import com.dogapi.something.data.entity.ImageBreedEntity;
import com.dogapi.something.domain.model.ImageBreedModel;

import javax.inject.Inject;

/**
 * Created by ana on 08-02-18.
 */

public class ImageBreedEntityToMapper extends Mapper<ImageBreedModel, String> {

    @Inject public ImageBreedEntityToMapper() {}

    @Override
    public String map(ImageBreedModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ImageBreedModel reverseMap(String value) {
        return new ImageBreedModel(value);
    }
}

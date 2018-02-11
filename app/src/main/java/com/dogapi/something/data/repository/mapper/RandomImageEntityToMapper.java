package com.dogapi.something.data.repository.mapper;

import com.dogapi.core.data.repository.mapper.Mapper;
import com.dogapi.something.data.entity.RandomImageBreedEntity;
import com.dogapi.something.domain.model.RandomImageBreedModel;

import javax.inject.Inject;

/**
 * Created by ana on 15-01-18.
 */

public class RandomImageEntityToMapper extends Mapper<RandomImageBreedEntity, RandomImageBreedModel> {

    @Inject public RandomImageEntityToMapper() {}

    @Override
    public RandomImageBreedModel map(RandomImageBreedEntity value) {
        RandomImageBreedModel randomImage = new RandomImageBreedModel();
        randomImage.image = value.message;
        return randomImage;
    }

    @Override
    public RandomImageBreedEntity reverseMap(RandomImageBreedModel value) {
        throw new UnsupportedOperationException();
    }
}

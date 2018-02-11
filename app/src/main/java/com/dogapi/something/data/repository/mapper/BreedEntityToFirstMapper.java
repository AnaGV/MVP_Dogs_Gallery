package com.dogapi.something.data.repository.mapper;

import com.dogapi.core.data.repository.mapper.Mapper;
import com.dogapi.something.domain.model.BreedModel;

import javax.inject.Inject;

/**
 * Created by ana on 15-01-18.
 */

public class BreedEntityToFirstMapper extends Mapper <BreedModel, String>{

   @Inject public BreedEntityToFirstMapper() {}

    @Override
    public String map(BreedModel value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public BreedModel reverseMap(String value) {
        BreedModel breedModel = new BreedModel();
        breedModel.name = value;
        return breedModel;
    }
}

package com.dogapi.something.data.repository;

import com.dogapi.something.data.entity.BreedEntity;
import com.dogapi.something.data.entity.ImageBreedEntity;
import com.dogapi.something.data.entity.RandomImageBreedEntity;
import com.dogapi.something.data.remote.ApiServiceFactory;
import com.dogapi.something.data.repository.mapper.BreedEntityToFirstMapper;
import com.dogapi.something.data.repository.mapper.ImageBreedEntityToMapper;
import com.dogapi.something.data.repository.mapper.RandomImageEntityToMapper;
import com.dogapi.something.domain.Repository;
import com.dogapi.something.domain.model.BreedModel;
import com.dogapi.something.domain.model.ImageBreedModel;
import com.dogapi.something.domain.model.RandomImageBreedModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Function;

/**
 * Created by ana on 21-10-17.
 */

public class RepositoryImpl implements Repository {
    private final ApiServiceFactory apiServiceFactory;
    private final BreedEntityToFirstMapper mapper;
    private final RandomImageEntityToMapper randomImageMapper;
    private final ImageBreedEntityToMapper imageBreedMapper;

    @Inject
    public RepositoryImpl(ApiServiceFactory apiServiceFactory, BreedEntityToFirstMapper breedEntityToFirstMapper,
                          RandomImageEntityToMapper randomImageEntityToMapper,
                          ImageBreedEntityToMapper imageToMapper) {
        this.apiServiceFactory = apiServiceFactory;
        this.mapper = breedEntityToFirstMapper;
        this.randomImageMapper = randomImageEntityToMapper;
        this.imageBreedMapper = imageToMapper;
    }


    @Override
    public Observable<List<BreedModel>> getAllBreed() {
        return apiServiceFactory.get().getAll().map(new Function<BreedEntity, List<BreedModel>>() {
            @Override
            public List<BreedModel> apply(BreedEntity breedEntity) throws Exception {
                return mapper.reverseMap(breedEntity.message);
            }
        });
    }

    @Override
    public Observable<RandomImageBreedModel> getRandomImage(String name) {
        return apiServiceFactory.get().getRandomImage(name).map(new Function<RandomImageBreedEntity, RandomImageBreedModel>() {
            @Override
            public RandomImageBreedModel apply(RandomImageBreedEntity randomImageBreedEntity) throws Exception {
                return randomImageMapper.map(randomImageBreedEntity);
            }
        });
    }

    @Override
    public Observable<List<ImageBreedModel>> getAllImage(String name) {
        return apiServiceFactory.get().getAllImage(name).map(new Function<ImageBreedEntity, List<ImageBreedModel>>() {
            @Override
            public List<ImageBreedModel> apply(ImageBreedEntity imageBreedEntity) throws Exception {
                return imageBreedMapper.reverseMap(imageBreedEntity.message);
            }
        });
    }
}

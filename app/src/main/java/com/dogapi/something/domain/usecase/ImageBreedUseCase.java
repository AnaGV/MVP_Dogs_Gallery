package com.dogapi.something.domain.usecase;

import com.dogapi.core.domain.usecase.UseCase;
import com.dogapi.something.domain.Repository;
import com.dogapi.something.domain.model.ImageBreedModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by ana on 08-02-18.
 */

public class ImageBreedUseCase extends UseCase<List<ImageBreedModel>> {
    private Repository repository;
    private String imageBreed;


    @Inject public ImageBreedUseCase(Repository repository) {
        this.repository = repository;
    }

    public ImageBreedUseCase setData(String image) {
        this.imageBreed = image;
        return this;
    }

    @Override
    protected Observable<List<ImageBreedModel>> createObservableUseCase() {
        return repository.getAllImage(imageBreed);
    }
}

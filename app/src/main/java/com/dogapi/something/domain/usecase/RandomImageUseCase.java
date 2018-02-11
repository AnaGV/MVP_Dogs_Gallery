package com.dogapi.something.domain.usecase;

import com.dogapi.core.domain.usecase.UseCase;
import com.dogapi.something.domain.Repository;
import com.dogapi.something.domain.model.RandomImageBreedModel;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by 15-01-18.
 */

public class RandomImageUseCase extends UseCase<RandomImageBreedModel> {
    private Repository repository;
    private String breedName;

    @Inject public RandomImageUseCase(Repository repository) {
        this.repository = repository;
    }

    public RandomImageUseCase setData(String name) {
        this.breedName = name;
        return this;
    }

    @Override
    protected Observable<RandomImageBreedModel> createObservableUseCase() {
        return repository.getRandomImage(breedName);
    }
}

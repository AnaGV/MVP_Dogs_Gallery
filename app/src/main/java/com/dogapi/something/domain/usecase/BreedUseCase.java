package com.dogapi.something.domain.usecase;

import com.dogapi.core.domain.usecase.UseCase;
import com.dogapi.something.domain.Repository;
import com.dogapi.something.domain.model.BreedModel;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by ana on 21-10-17.
 */

public class BreedUseCase extends UseCase<List<BreedModel>>{

    private Repository repository;
    @Inject
    public BreedUseCase(Repository repository) {
        super();
        this.repository = repository;
    }

    @Override
    protected Observable<List<BreedModel>> createObservableUseCase() {
        return repository.getAllBreed();
    }
}

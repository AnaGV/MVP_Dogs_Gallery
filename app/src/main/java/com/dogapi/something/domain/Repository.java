package com.dogapi.something.domain;

import com.dogapi.something.domain.model.BreedModel;
import com.dogapi.something.domain.model.ImageBreedModel;
import com.dogapi.something.domain.model.RandomImageBreedModel;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by ana on 21-10-17.
 */

public interface Repository {

    Observable<List<BreedModel>> getAllBreed();

    Observable<RandomImageBreedModel> getRandomImage(String name);

    Observable<List<ImageBreedModel>> getAllImage(String name);
}

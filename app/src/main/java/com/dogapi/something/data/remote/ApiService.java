package com.dogapi.something.data.remote;

import com.dogapi.something.data.entity.BreedEntity;
import com.dogapi.something.data.entity.ImageBreedEntity;
import com.dogapi.something.data.entity.RandomImageBreedEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by ana on 21-10-17.
 */

public interface ApiService {
    @GET("/api/breeds/list")
    Observable<BreedEntity> getAll();

    @GET("/api/breed/{name}/images/random")
    Observable<RandomImageBreedEntity> getRandomImage(@Path("name") String name);

    @GET("/api/breed/{name}/images")
    Observable<ImageBreedEntity> getAllImage(@Path("name") String name);

}

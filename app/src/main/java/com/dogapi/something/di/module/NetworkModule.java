package com.dogapi.something.di.module;

import com.dogapi.something.data.remote.ApiServiceFactory;
import com.dogapi.something.data.repository.RepositoryImpl;
import com.dogapi.something.data.repository.mapper.ImageBreedEntityToMapper;
import com.dogapi.something.data.repository.mapper.RandomImageEntityToMapper;
import com.dogapi.something.domain.Repository;
import com.dogapi.something.data.repository.mapper.BreedEntityToFirstMapper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import okhttp3.OkHttpClient;

/**
 * Created by ana on 21-10-17
 */

@Module
public class NetworkModule {
    @Provides
    @Singleton
    public ApiServiceFactory provideApiFactory(OkHttpClient okHttpClient){
        return new ApiServiceFactory(okHttpClient);
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(){
        return new OkHttpClient();
    }

    @Provides
    @Singleton
    public Repository providePPNApiRepository(ApiServiceFactory apiServiceFactory, BreedEntityToFirstMapper mapper,
                                              RandomImageEntityToMapper randomImageMapper,
                                              ImageBreedEntityToMapper imageBreedMapper){
        return new RepositoryImpl(apiServiceFactory, mapper, randomImageMapper, imageBreedMapper);
    }
}
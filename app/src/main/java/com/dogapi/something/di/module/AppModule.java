package com.dogapi.something.di.module;

import android.content.Context;


import com.dogapi.something.DogApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ana on 21-10-17
 */


@Module
public class AppModule {
    private DogApp application;

    public AppModule(DogApp application){
        this.application=application;
    }
    
    @Provides
    @Singleton
    public Context provideContext(){
        return  application;
    }

}
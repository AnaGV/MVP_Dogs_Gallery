package com.dogapi.something.di.module;

import com.dogapi.something.domain.usecase.ImageBreedUseCase;
import com.dogapi.something.presentation.contract.DetailBreedContract;
import com.dogapi.something.presentation.presenter.DetailBreedPresenter;
import com.dogapi.something.presentation.ui.adapter.PagerAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ana on 08-02-18.
 */
@Module
public class DetailBreedModule {
    @Provides @Singleton
    public DetailBreedContract.Presenter providePresenter(ImageBreedUseCase randomImageUseCase){
        return new DetailBreedPresenter(randomImageUseCase);
    }

    @Provides @Singleton
    public PagerAdapter provideAdapter(){
        return new PagerAdapter();
    }
}

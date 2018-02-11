package com.dogapi.something.di.module;

import com.dogapi.something.domain.usecase.BreedUseCase;
import com.dogapi.something.domain.usecase.RandomImageUseCase;
import com.dogapi.something.presentation.contract.BreedContract;
import com.dogapi.something.presentation.presenter.BreedPresenter;
import com.dogapi.something.presentation.ui.adapter.BreedAdapter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ana on 22-10-17.
 */
@Module
public class BreedModule {
    @Provides @Singleton
    public BreedContract.Presenter providePresenter(BreedUseCase getUseCase, RandomImageUseCase randomImageUseCase){
        return new BreedPresenter(getUseCase, randomImageUseCase);
    }

    @Provides @Singleton
    public BreedAdapter provideAdapter(){
        return new BreedAdapter();
    }
}

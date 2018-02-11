package com.dogapi.something.di.component;

import com.dogapi.something.di.module.DetailBreedModule;
import com.dogapi.something.di.module.NetworkModule;
import com.dogapi.something.presentation.ui.fragment.DetailBreedFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ana on 08-02-18.
 */

@Singleton @Component(modules ={NetworkModule.class, DetailBreedModule.class})
public interface DetailComponent {
    void inject(DetailBreedFragment target);
}

package com.dogapi.something.di.component;

/**
 * Created by ana on 21-10-17
 */

import com.dogapi.something.di.module.BreedModule;
import com.dogapi.something.di.module.NetworkModule;
import com.dogapi.something.presentation.ui.fragment.BreedFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules ={NetworkModule.class, BreedModule.class})

public interface AppComponent {
    /**
     * Indica que Activity o Fragment requiere inyección desde este componente
     * @param target Activity
     * @param target Fragment
     */
    //void inject(MainActivity target);
    void inject(BreedFragment target);
}
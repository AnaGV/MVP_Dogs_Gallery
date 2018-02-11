package com.dogapi.something.presentation.presenter;

import android.util.Log;

import com.dogapi.core.domain.usecase.UseCaseObserver;
import com.dogapi.core.presentation.presenter.Presenter;
import com.dogapi.something.domain.model.Breed;
import com.dogapi.something.domain.model.BreedModel;
import com.dogapi.something.domain.model.RandomImageBreedModel;
import com.dogapi.something.domain.usecase.BreedUseCase;
import com.dogapi.something.domain.usecase.RandomImageUseCase;
import com.dogapi.something.presentation.contract.BreedContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by ana on 21-10-17.
 */

public class BreedPresenter implements BreedContract.Presenter {

    private BreedUseCase breedUseCase;
    private RandomImageUseCase randomImageUseCase;
    private List<Breed> breeds;
    private BreedContract.View view;

    @Inject
    public BreedPresenter(BreedUseCase breedUseCase, RandomImageUseCase randomImageUseCase) {
        this.breedUseCase = breedUseCase;
        this.randomImageUseCase = randomImageUseCase;
    }
    @Override
    public void initialize(BreedContract.View view) {
        this.view = view;
        breeds = new ArrayList<>();
        getAllBreed();
    }

    public void getAllBreed(){
        view.showProgress(true);
        breedUseCase.execute(new UseCaseObserver<List<BreedModel>>() {
            @Override
            public void onError(Throwable e) {
                super.onError(e);
                view.showProgress(false);
                e.printStackTrace();
            }

            @Override
            public void onNext(final List<BreedModel> breedModels) {
                super.onNext(breedModels);

                if (breedModels.size() > 0) {
                    for (int i = 0; i < breedModels.size(); i++) {
                        if (breedModels.get(i).name != null){
                            requestImageBreed(breedModels.get(i).name);
                        }
                    }
                }
            }
        });
    }

    public void requestImageBreed(final String nameBreed){

        randomImageUseCase.setData(nameBreed).execute(new UseCaseObserver<RandomImageBreedModel>() {
            @Override
            public void onError(Throwable e) {
                view.showProgress(false);
                e.printStackTrace();
            }

            @Override
            public void onNext(RandomImageBreedModel randomImageBreed) {
                breeds.add(new Breed(nameBreed, randomImageBreed.image));
                view.setBreeds(breeds);
                view.showProgress(false);
            }
        });
    }
}

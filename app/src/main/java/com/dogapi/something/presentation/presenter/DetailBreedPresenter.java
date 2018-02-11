package com.dogapi.something.presentation.presenter;

import com.dogapi.core.domain.usecase.UseCaseObserver;
import com.dogapi.something.domain.model.ImageBreedModel;
import com.dogapi.something.domain.usecase.ImageBreedUseCase;
import com.dogapi.something.presentation.contract.DetailBreedContract;

import java.util.List;

/**
 * Created by ana on 08-02-18.
 */

public class DetailBreedPresenter implements DetailBreedContract.Presenter {

    private DetailBreedContract.View view;
    private ImageBreedUseCase imageBreedUseCase;

    public DetailBreedPresenter(ImageBreedUseCase imageBreedUseCase) {
        this.imageBreedUseCase = imageBreedUseCase;
    }

    @Override
    public void initialize(DetailBreedContract.View view) {
        this.view = view;
    }

    @Override
    public void setAllImage(String name) {
        if (name != null && !name.isEmpty()){
            view.showProgress(true);
            imageBreedUseCase.setData(name).execute(new UseCaseObserver<List<ImageBreedModel>>() {
                @Override
                public void onError(Throwable e) {super.onError(e);e.printStackTrace();}

                @Override
                public void onNext(List<ImageBreedModel> imageBreedModels) {
                    if (imageBreedModels != null){
                        view.showProgress(false);
                        view.setImage(imageBreedModels);
                    }
                }
            });
        }
    }
}

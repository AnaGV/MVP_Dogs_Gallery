package com.dogapi.something.presentation.contract;

import com.dogapi.core.presentation.contract.BaseViewPresenter;
import com.dogapi.core.presentation.contract.IProgressView;
import com.dogapi.something.domain.model.Breed;

import java.util.List;

/**
 * Created by ana on 08-02-18.
 */

public interface BreedContract {

    interface View extends IProgressView {
        void setBreeds(List<Breed> breeds);
    }

    interface Presenter extends BaseViewPresenter<View> {

    }
}

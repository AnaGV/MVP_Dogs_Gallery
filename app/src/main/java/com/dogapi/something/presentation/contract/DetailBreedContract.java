package com.dogapi.something.presentation.contract;

import com.dogapi.core.presentation.contract.BaseViewPresenter;
import com.dogapi.core.presentation.contract.IProgressView;
import com.dogapi.something.domain.model.ImageBreedModel;

import java.util.List;

/**
 * Created by ana on 08-02-18.
 */

public interface DetailBreedContract {

    interface View extends IProgressView {
        void setImage(List<ImageBreedModel> image);
    }

    interface Presenter extends BaseViewPresenter<View> {
        void setAllImage(String name);
    }
}

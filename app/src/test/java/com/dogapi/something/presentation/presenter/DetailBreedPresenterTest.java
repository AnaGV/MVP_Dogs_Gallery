package com.dogapi.something.presentation.presenter;

import com.dogapi.core.domain.usecase.UseCaseObserver;
import com.dogapi.something.domain.model.ImageBreedModel;
import com.dogapi.something.domain.usecase.ImageBreedUseCase;
import com.dogapi.something.presentation.contract.DetailBreedContract;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

/**
 * Created by ana on 10-02-18.
 */
@RunWith(MockitoJUnitRunner.class)
public class DetailBreedPresenterTest {

    @Mock DetailBreedContract.View view;
    @Mock DetailBreedContract.Presenter presenter;
    @Mock ImageBreedUseCase imageBreedUseCase;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new DetailBreedPresenter(imageBreedUseCase);
        presenter.initialize(view);
    }

    @Test
    public void setAllImages_nullString(){
        presenter.setAllImage(null);
        verify(view, never()).setImage(getImageBreedModels());
    }

    @Test
    public void setAllImages_emptyString(){
        presenter.setAllImage("");
        verify(view, never()).setImage(getImageBreedModels());
    }

    public List<ImageBreedModel> getImageBreedModels(){
        List<ImageBreedModel> list = new ArrayList<>();
        list.add(new ImageBreedModel("1"));
        list.add(new ImageBreedModel("2"));
        return list;
    }
}
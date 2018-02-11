package com.dogapi.core.presentation.contract;

/**
 * Created by Jhonny Barrios
 */

public interface IProgressView {
    void showProgress(boolean show);
    void showMessage(String message);
}
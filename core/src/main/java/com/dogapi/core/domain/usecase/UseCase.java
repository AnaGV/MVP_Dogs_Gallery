package com.dogapi.core.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ana on 21-10-17.
 */

public abstract class UseCase <T> {
    private final CompositeDisposable compositeDisposable;

    public UseCase() {
        compositeDisposable = new CompositeDisposable();
    }

    public void execute(UseCaseObserver<T> disposableObserver){
        if (disposableObserver == null) {
            throw new IllegalArgumentException("disposableObserver must not be null");
        }
        final Observable<T> observable = this.createObservableUseCase().subscribeOn(getSubscribeOn()).observeOn(getObserveOn());

        UseCaseObserver observer = observable.subscribeWith(disposableObserver);
        compositeDisposable.add(observer);
    }

    protected Scheduler getSubscribeOn() {
        return Schedulers.io();
    }

    protected Scheduler getObserveOn() {
        return AndroidSchedulers.mainThread();
    }

    public void dispose() {
        if (!compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
        }
    }

    protected abstract Observable<T> createObservableUseCase();
}

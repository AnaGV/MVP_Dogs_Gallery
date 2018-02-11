package com.dogapi.core.domain.usecase;

import io.reactivex.observers.DisposableObserver;

/**
 * Created by ana on 21-10-17.
 */

public abstract class UseCaseObserver<T> extends DisposableObserver<T> {

    @Override public void onComplete() {}

    @Override public void onError(Throwable e) {}

    @Override public void onNext(T t) {}
}

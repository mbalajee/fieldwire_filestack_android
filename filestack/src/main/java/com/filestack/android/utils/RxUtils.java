package com.filestack.android.utils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.functions.BiFunction;

public class RxUtils {

    /**
     * Zip the input observable with a timer.
     * This will return an observable that only emits items from the input observable
     * once BOTH an item is emitted from the input observable AND the timer expires.
     */
    public static <T> Single<T> zipWithTimer(Single<T> observable, Long timer) {
        return Single.zip(observable,
                Single.timer(timer, TimeUnit.MILLISECONDS), new BiFunction<T, Long, T>() {
                    @io.reactivex.annotations.NonNull
                    @Override
                    public T apply(@io.reactivex.annotations.NonNull T t, @io.reactivex.annotations.NonNull Long timerValue) throws Exception {
                        return t;
                    }
                });
    }
}

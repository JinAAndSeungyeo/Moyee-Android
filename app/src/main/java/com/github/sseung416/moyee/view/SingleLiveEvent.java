package com.github.sseung416.moyee.view;

import android.util.Log;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import java.util.concurrent.atomic.AtomicBoolean;

public class SingleLiveEvent<T> extends MutableLiveData<T> {

    public SingleLiveEvent() {
        super();
    }

    public SingleLiveEvent(T value) {
        super(value);
    }

    private static final String TAG = "SingleLiveEvent";

    private AtomicBoolean pending = new AtomicBoolean(false);

    @MainThread
    @Override
    public void observe(@NonNull LifecycleOwner owner, @NonNull Observer<? super T> observer) {
        if (hasActiveObservers()) {
            Log.w(TAG, "Multiple observers registered but only one will be notified of changes.");
        }

        super.observe(owner, (t -> {
            if (pending.compareAndSet(true, false)) {
                observer.onChanged(t);
            }
        }));
    }

    @MainThread
    @Override
    public void setValue(T value) {
        pending.set(true);
        super.setValue(value);
    }

    @MainThread
    public void call() {
        this.setValue(null);
    }
}

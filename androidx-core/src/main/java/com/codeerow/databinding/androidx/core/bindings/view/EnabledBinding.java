package com.codeerow.databinding.androidx.core.bindings.view;

import android.view.View;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.codeerow.databinding.Binding;

import java.lang.ref.WeakReference;


public class EnabledBinding extends Binding {

    private WeakReference<View> viewRef;

    private LiveData<Boolean> value;
    private LifecycleOwner lifecycleOwner;


    public EnabledBinding(View view, LifecycleOwner lifecycleOwner, MutableLiveData<Boolean> value) {
        this.viewRef = new WeakReference<>(view);
        this.value = value;
        this.lifecycleOwner = lifecycleOwner;
    }

    public EnabledBinding(View view, LifecycleOwner lifecycleOwner, MutableLiveData<Boolean> value, boolean goneWhenInvisible) {
        this.viewRef = new WeakReference<>(view);
        this.value = value;
        this.lifecycleOwner = lifecycleOwner;
    }


    @Override
    public void execute() {
        value.observe(lifecycleOwner, new Observer<Boolean>() {
            View view = viewRef.get();

            @Override
            public void onChanged(Boolean isEnabled) {
                view.setEnabled(isEnabled);
            }
        });
    }
}

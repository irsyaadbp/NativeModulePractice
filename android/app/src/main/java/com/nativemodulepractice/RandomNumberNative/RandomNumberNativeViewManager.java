package com.nativemodulepractice.RandomNumberNative;

import android.content.Context;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.nativemodulepractice.R;

import java.util.Map;

public class RandomNumberNativeViewManager extends SimpleViewManager<RandomNumberNativeView> {
    public static final String REACT_COMPONENT = "RandomNumberNative";
    @NonNull
    @Override
    public String getName() {
        return REACT_COMPONENT;
    }

    @NonNull
    @Override
    protected RandomNumberNativeView createViewInstance(@NonNull ThemedReactContext reactContext) {
        LayoutInflater inflater = (LayoutInflater)
                reactContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        return (RandomNumberNativeView) inflater.inflate(R.layout.random_number_layout, null);
    }

    @ReactProp(name="initialNumber")
    public void setInitialNumber(RandomNumberNativeView view, int status) {
        view.setInitialNumber(status);
    }

    @Nullable
    @Override
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onNumberChange", MapBuilder.of("registrationName", "onNumberChange"));
    }
}

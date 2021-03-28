package com.nativemodulepractice.randomnumberkotlin

import android.content.Context
import android.view.LayoutInflater
import com.facebook.react.common.MapBuilder
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.nativemodulepractice.R

class RandomNumberKotlinViewManager : SimpleViewManager<RandomNumberKotlinView>() {
    private val REACT_COMPONENT = "RandomNumberKotlin"
    override fun getName(): String {
        return REACT_COMPONENT
    }

    override fun createViewInstance(reactContext: ThemedReactContext): RandomNumberKotlinView {
        return RandomNumberKotlinView(reactContext)
    }

    @ReactProp(name = "initialNumber")
    fun setInitialNumber(view: RandomNumberKotlinView, status: Int) {
        view.setInitialNumber(status)
    }

    override fun getExportedCustomDirectEventTypeConstants(): Map<String, Any?>? {
        return MapBuilder.of<String, Any?>("onNumberChange", MapBuilder.of("registrationName", "onNumberChange"))
    }
}
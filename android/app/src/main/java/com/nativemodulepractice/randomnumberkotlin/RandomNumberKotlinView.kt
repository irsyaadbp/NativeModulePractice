package com.nativemodulepractice.randomnumberkotlin

import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.facebook.react.bridge.Arguments
import com.facebook.react.bridge.ReactContext
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.events.RCTEventEmitter
import com.nativemodulepractice.R
import java.util.*

class RandomNumberKotlinView(context: ThemedReactContext) : LinearLayout(context) {
    var randomNumber: TextView? = null
    private var myContext: ThemedReactContext = context
    var number: Int = 0

    init {
        initLayout()
    }

    private fun generateNumber(): Int {
        val rand = Random()
        return rand.nextInt(100)
    }

    private fun updateNumber() {
        val number = "" + number
        randomNumber?.text = number
    }

    fun setInitialNumber(n: Int) {
        number = n
        updateNumber()
    }

    private fun onNumberChange() {
        val event = Arguments.createMap()
        event.putInt("number", number)
        val reactContext = context as ReactContext
        reactContext.getJSModule(RCTEventEmitter::class.java).receiveEvent(
                id,
                "onNumberChange",
                event)
    }

    fun initLayout() {
        inflate(myContext, R.layout.random_number_kotlin, this)

        val randomButton = findViewById<Button>(R.id.randomButton)
        randomNumber = findViewById(R.id.randomNumber)

        randomButton.setOnClickListener {
            number = generateNumber()
            updateNumber()
            onNumberChange()
        }
    }
}
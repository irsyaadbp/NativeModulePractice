package com.nativemodulepractice.RandomNumberNative;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.nativemodulepractice.R;

import java.util.Random;

public class RandomNumberNativeView extends LinearLayout {
    TextView randomNumber;
    int number = 0;

    public RandomNumberNativeView(Context context) {
        super(context);
    }

    public RandomNumberNativeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    public RandomNumberNativeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void onFinishInflate(){
        super.onFinishInflate();

        Button randomButton = findViewById(R.id.randomButton);
        randomNumber = findViewById(R.id.randomNumber);

        randomButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                number = generateNumber();
                updateNumber();
                onNumberChange();
            }
        });
    }

    private int generateNumber(){
        Random rand = new Random();
        return rand.nextInt(100);
    }

    private void updateNumber(){
        String number = "" + this.number;
        randomNumber.setText(number);
    }

    public void setInitialNumber(int n){
        this.number = n;
        this.updateNumber();
    }

    public void onNumberChange(){
        WritableMap event = Arguments.createMap();
        event.putInt("number", this.number);
        ReactContext reactContext = (ReactContext)getContext();
        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
                getId(),
                "onNumberChange",
                event);
    }
}

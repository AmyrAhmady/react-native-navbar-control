// NavbarControl

package com.iamir.navbarcontrol;

import android.view.View;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;

import java.util.HashMap;
import java.util.Map;



public class NavbarControlModule extends ReactContextBaseJavaModule {
    public static final String REACT_CLASS = "NavbarControl";
    private static ReactApplicationContext reactContext = null;
    private static final int UI_FLAG_HIDE_NAV_BAR = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

    public NavbarControlModule(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @ReactMethod
    public void HideNavigationBar(Promise promise) {
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (getCurrentActivity() != null) {
                        View decorView = getCurrentActivity().getWindow().getDecorView();
                        decorView.setSystemUiVisibility(UI_FLAG_HIDE_NAV_BAR);
                    }
                }
            });
        } catch (IllegalViewOperationException e) {
            WritableMap map = Arguments.createMap();
            map.putBoolean("success", false);
            promise.reject("error", e);
        }
    }

    @ReactMethod
    public void ShowNavigationBar(Promise promise) {
        try {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (getCurrentActivity() != null) {
                        View decorView = getCurrentActivity().getWindow().getDecorView();

                        int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;

                        decorView.setSystemUiVisibility(uiOptions);
                    }
                }
            });
        } catch (IllegalViewOperationException e) {
            WritableMap map = Arguments.createMap();
            map.putBoolean("success", false);
            promise.reject("error", e);
        }
    }
}

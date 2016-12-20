package com.ferdinandsilva.android;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SimpleToastPlugin extends CordovaPlugin {
    public static final String TAG = "SimpleToastPlugin";
    public static Context thisContext;

    public SimpleToastPlugin() {
    }

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        SimpleToastPlugin.thisContext = cordova.getActivity().getApplicationContext();
    }
    

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if ("show".equals(action)) {
            int toastDuration = 0;

            if(args.getInt(1) == 1) {
                toastDuration = Toast.LENGTH_LONG;
            } else {
                toastDuration = Toast.LENGTH_SHORT;
            }
            Toast.makeText(SimpleToastPlugin.thisContext,args.get(0).toString(), toastDuration).show();
            callbackContext.success(args.get(0).toString());
        } else {
            return false;
        }

        return true;    
    }
}
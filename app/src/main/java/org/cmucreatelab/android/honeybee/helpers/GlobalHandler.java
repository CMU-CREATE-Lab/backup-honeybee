package org.cmucreatelab.android.honeybee.helpers;

import android.app.Activity;
import android.content.Context;

import org.cmucreatelab.android.honeybee.helpers.melodysmart.HoneybeeDeviceHandler;

/**
 * Created by mike on 2/9/17.
 */

public class GlobalHandler {

    public Context appContext;
    public HoneybeeDeviceHandler melodySmartDeviceHandler;
    public Activity currentActivity;


    // Singleton Implementation


    private static GlobalHandler classInstance;


    public static synchronized GlobalHandler getInstance(Context context) {
        if (classInstance == null) {
            classInstance = new GlobalHandler(context);
        }
        return classInstance;
    }


    private GlobalHandler(Context context) {
        this.appContext = context;
        this.melodySmartDeviceHandler = new HoneybeeDeviceHandler(this);
    }

}

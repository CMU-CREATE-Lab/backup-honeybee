package org.cmucreatelab.android.honeybee.helpers.melodysmart;

import android.content.Intent;
import android.util.Log;
import com.bluecreation.melodysmart.BLEError;

import org.cmucreatelab.android.honeybee.activities.HoneybeeShowActivity;
import org.cmucreatelab.android.honeybee.activities.MainActivity;
import org.cmucreatelab.android.honeybee.helpers.GlobalHandler;
import org.cmucreatelab.android.honeybee.helpers.static_classes.Constants;
import org.cmucreatelab.android.melodysmart.listeners.DeviceListener;

/**
 * Created by mike on 2/9/17.
 */

public class HoneybeeDeviceListener extends DeviceListener {

    private GlobalHandler globalHandler;


    public HoneybeeDeviceListener(GlobalHandler globalHandler) {
        this.globalHandler = globalHandler;
    }


    @Override
    public void onConnected() {
        Log.v(Constants.LOG_TAG, "HoneybeeDeviceListener.onConnected");
        //Intent intent = new Intent(globalHandler.appContext, MainActivity.class);
        Intent intent = new Intent(globalHandler.currentActivity, HoneybeeShowActivity.class);
        globalHandler.currentActivity.startActivity(intent);
    }


    @Override
    public void onDisconnected(BLEError bleError) {
        Log.v(Constants.LOG_TAG, "HoneybeeDeviceListener.onDisconnected");
    }

}

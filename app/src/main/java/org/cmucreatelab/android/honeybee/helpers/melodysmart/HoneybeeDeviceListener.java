package org.cmucreatelab.android.honeybee.helpers.melodysmart;

import android.util.Log;
import com.bluecreation.melodysmart.BLEError;
import org.cmucreatelab.android.honeybee.helpers.static_classes.Constants;
import org.cmucreatelab.android.melodysmart.listeners.DeviceListener;

/**
 * Created by mike on 2/9/17.
 */

public class HoneybeeDeviceListener extends DeviceListener {


    @Override
    public void onConnected() {
        Log.v(Constants.LOG_TAG, "HoneybeeDeviceListener.onConnected");
    }


    @Override
    public void onDisconnected(BLEError bleError) {
        Log.v(Constants.LOG_TAG, "HoneybeeDeviceListener.onDisconnected");
    }

}

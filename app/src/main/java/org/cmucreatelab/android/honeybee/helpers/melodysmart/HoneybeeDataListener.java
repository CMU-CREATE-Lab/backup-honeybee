package org.cmucreatelab.android.honeybee.helpers.melodysmart;

import android.util.Log;
import org.cmucreatelab.android.honeybee.helpers.static_classes.Constants;
import org.cmucreatelab.android.melodysmart.DeviceHandler;
import org.cmucreatelab.android.melodysmart.MessageQueue;
import org.cmucreatelab.android.melodysmart.listeners.DataListener;
import org.cmucreatelab.android.melodysmart.models.MelodySmartMessage;

/**
 * Created by mike on 2/9/17.
 */

public class HoneybeeDataListener extends DataListener<MessageQueue> {


    private DeviceHandler parent;


    HoneybeeDataListener(DeviceHandler parent) {
        super();
        this.parent = parent;
    }


    @Override
    public void onConnected() {
        Log.v(Constants.LOG_TAG, "HoneybeeDataListener.onConnected");
        parent.getDataService().enableNotifications(true);
    }


    @Override
    public void onMessageReceived(MelodySmartMessage request, String response) {
        Log.v(Constants.LOG_TAG, "HoneybeeDataListener.onMessageReceived");
        Log.v(Constants.LOG_TAG, "request="+request.getRequest()+", response="+response);
    }

}

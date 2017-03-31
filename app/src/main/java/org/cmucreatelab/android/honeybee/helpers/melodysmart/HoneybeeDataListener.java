package org.cmucreatelab.android.honeybee.helpers.melodysmart;

import android.util.Log;

import org.cmucreatelab.android.honeybee.classes.HoneybeeMessage;
import org.cmucreatelab.android.honeybee.helpers.static_classes.Constants;
import org.cmucreatelab.android.honeybee.helpers.static_classes.PacketManager;
import org.cmucreatelab.android.melodysmart.DeviceHandler;
import org.cmucreatelab.android.melodysmart.MessageQueue;
import org.cmucreatelab.android.melodysmart.listeners.DataListener;

/**
 * Created by mike on 2/9/17.
 */

public class HoneybeeDataListener extends DataListener<HoneybeeMessage, MessageQueue<HoneybeeMessage>> {


    HoneybeeDataListener(DeviceHandler parent) {
        super(parent);
    }


    @Override
    public void onConnected() {
        Log.v(Constants.LOG_TAG, "HoneybeeDataListener.onConnected");
    }


    @Override
    public void onMessageReceived(HoneybeeMessage request) {
        if (request.hasReceivedExpectedResponses()) {
            Log.v(Constants.LOG_TAG, "HoneybeeDataListener.onMessageReceived: Finished receiving responses");
            for (String response: request.getResponses()) {
                Log.v(Constants.LOG_TAG, "HoneybeeDataListener.onMessageReceived: > " + response);
            }
            if (request.getExpectedResponseSize() > 1) {
                Log.v(Constants.LOG_TAG, "HoneybeeDataListener.onMessageReceived (parsed): " + PacketManager.concatResponsePackets(request));
            }
        }
    }

}

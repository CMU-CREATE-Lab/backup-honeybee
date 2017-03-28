package org.cmucreatelab.android.honeybee.helpers.melodysmart;

import org.cmucreatelab.android.honeybee.helpers.GlobalHandler;
import org.cmucreatelab.android.melodysmart.DeviceHandler;
import org.cmucreatelab.android.melodysmart.MessageQueue;
import org.cmucreatelab.android.melodysmart.listeners.DataListener;
import org.cmucreatelab.android.melodysmart.listeners.DeviceListener;

/**
 * Created by mike on 2/9/17.
 */

public class HoneybeeDeviceHandler extends DeviceHandler {

    private GlobalHandler globalHandler;


    public HoneybeeDeviceHandler(GlobalHandler globalHandler) {
        super(globalHandler.appContext);
        this.globalHandler = globalHandler;
    }


    @Override
    public MessageQueue initializeMessageQueue() {
        return new MessageQueue(getDataService());
    }


    @Override
    public DeviceListener initializeDeviceListener() {
        return new HoneybeeDeviceListener(globalHandler);
    }


    @Override
    public DataListener initializeDataListener() {
        return new HoneybeeDataListener();
    }

}

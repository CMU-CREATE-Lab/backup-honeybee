package org.cmucreatelab.android.honeybee.classes;

import android.util.Log;

import org.cmucreatelab.android.honeybee.helpers.static_classes.Constants;
import org.cmucreatelab.android.melodysmart.models.MelodySmartMessage;

import java.util.List;

/**
 * Created by mike on 3/29/17.
 */

public class HoneybeeMessage extends MelodySmartMessage {


    public HoneybeeMessage(String request) {
        super(request);
    }


    public HoneybeeMessage(List<String> requests) {
        super(requests);
    }


    @Override
    public void addResponse(String response) {
        super.addResponse(response);
        // change expected response size
        try {
            Integer numberOfPackets = Integer.parseInt(response.substring(2, 3));
            this.setExpectedResponseSize(numberOfPackets);
        } catch (NumberFormatException e) {
            Log.e(Constants.LOG_TAG, "could not set expected response size from response="+response);
        }
    }

}

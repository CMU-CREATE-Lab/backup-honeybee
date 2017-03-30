package org.cmucreatelab.android.honeybee.classes;

import org.cmucreatelab.android.melodysmart.models.MelodySmartMessage;

/**
 * Created by mike on 3/29/17.
 */

public class HoneybeeMessage extends MelodySmartMessage {


    public HoneybeeMessage(String request) {
        super(request);
        this.setExpectedResponseSize(2);
    }


    @Override
    public void addResponse(String response) {
        super.addResponse(response);
        // change expected response size
        Integer numberOfPackets = Integer.parseInt(response.substring(2,3));
        this.setExpectedResponseSize(numberOfPackets);
    }

}

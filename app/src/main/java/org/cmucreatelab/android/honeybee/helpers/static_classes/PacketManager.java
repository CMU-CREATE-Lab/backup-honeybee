package org.cmucreatelab.android.honeybee.helpers.static_classes;

import org.cmucreatelab.android.honeybee.classes.HoneybeeMessage;

/**
 * Created by mike on 3/30/17.
 */

public class PacketManager {


    public static HoneybeeMessage constructMessage(String prefix, String payload) {
        // TODO given a prefix and the intended payload, construct the message with multiple request packets
        return null;
    }


    public static String parseResponse(HoneybeeMessage message) {
        String result = "";

        // TODO confirm the responses are in order
        for (String response: message.getResponses()) {
            String temp = response.substring(4);
            result = result.concat(temp);
        }

        return result;
    }

}

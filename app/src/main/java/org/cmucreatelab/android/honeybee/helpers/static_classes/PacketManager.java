package org.cmucreatelab.android.honeybee.helpers.static_classes;

import org.cmucreatelab.android.honeybee.classes.HoneybeeMessage;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by mike on 3/30/17.
 */

public class PacketManager {


    public static HoneybeeMessage constructMessage(String prefix, String payload) {
        ArrayList<String> intermediatePackets, packets;
        String first,second;
        int currentPacket,totalPacket;

        second = payload;
        intermediatePackets = new ArrayList<>();

        // create intermediate packets of length 16
        while (second.length() > 16) {
            first = second.substring(0,16);
            second = second.substring(16);
            intermediatePackets.add(first);
        }
        // be sure to add what remains of the payload afterwards
        intermediatePackets.add(second);

        currentPacket = 0;
        totalPacket = intermediatePackets.size();
        packets = new ArrayList<>();

        // now, prepend the prefix and packet numbering scheme (4 bytes long, so each packet becomes 20 bytes long max)
        for (String packet: intermediatePackets) {
            String message = String.format(Locale.US, "%s%d%d,", prefix, currentPacket, totalPacket).concat(packet);
            packets.add(message);
            currentPacket++;
        }

        return new HoneybeeMessage(packets);
    }


    public static String concatResponsePackets(HoneybeeMessage message) {
        String result = "";

        // TODO confirm the responses are in order
        for (String response: message.getResponses()) {
            String temp = response.substring(4);
            result = result.concat(temp);
        }

        return result;
    }

}

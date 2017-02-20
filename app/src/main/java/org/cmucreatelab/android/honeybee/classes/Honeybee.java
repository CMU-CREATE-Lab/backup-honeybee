package org.cmucreatelab.android.honeybee.classes;

import android.bluetooth.BluetoothDevice;

/**
 * Created by mike on 2/20/17.
 */

public class Honeybee {

    private BluetoothDevice bluetoothDevice;

    public BluetoothDevice getBluetoothDevice() { return bluetoothDevice; }
    public String getName() { return bluetoothDevice.getName(); }


    public Honeybee(BluetoothDevice device) {
        this.bluetoothDevice = device;
    }

}

package org.cmucreatelab.android.honeybee.activities;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.cmucreatelab.android.honeybee.R;
import org.cmucreatelab.android.honeybee.classes.Honeybee;
import org.cmucreatelab.android.honeybee.helpers.GlobalHandler;
import org.cmucreatelab.android.honeybee.helpers.static_classes.Constants;

public class MainActivity extends AppCompatActivity {

    private Menu menu;
    private LeDeviceListAdapter leDeviceAdapter;
    private final BluetoothAdapter.LeScanCallback leScanCallBack = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(final BluetoothDevice device, int rssi, final byte[] scanRecord) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0; i<leDeviceAdapter.getCount(); i++) {
                        Honeybee result = (Honeybee)leDeviceAdapter.getItem(i);
                        if (result.getBluetoothDevice().equals(device)) {
                            return;
                        }
                    }
                    // Check if the device is a honeybee or not
                    String address = device.getAddress();
                    address = address.substring(0,8);
                    if (address.equals(Constants.HONEYBEE_MAC_ADDRESS)) {
                        Honeybee endResult = new Honeybee(device);
                        leDeviceAdapter.addDevice(endResult);
                    }
                }
            });
        }
    };


    private void scanForDevice(boolean isScanning) {
        GlobalHandler.getInstance(getApplicationContext()).melodySmartDeviceHandler.setDeviceScanning(isScanning, leScanCallBack);

        if (isScanning) {
            menu.findItem(R.id.action_scan).setVisible(false);
            menu.findItem(R.id.action_stop_scan).setVisible(true);
        } else {
            menu.findItem(R.id.action_scan).setVisible(true);
            menu.findItem(R.id.action_stop_scan).setVisible(false);
        }
        leDeviceAdapter.clearDevices();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leDeviceAdapter = new LeDeviceListAdapter(getLayoutInflater());
        ListView list = (ListView) findViewById(R.id.scan_list);
        list.setAdapter(leDeviceAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Honeybee honeybee = (Honeybee)leDeviceAdapter.getItem(i);
                Log.i(Constants.LOG_TAG,"got honeybee addr="+honeybee.getName());
                scanForDevice(false);
                GlobalHandler.getInstance(getApplicationContext()).melodySmartDeviceHandler.connect(honeybee.getBluetoothDevice());
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        GlobalHandler.getInstance(getApplicationContext()).currentActivity = this;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        this.menu = menu;
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_scan:
                Log.v(Constants.LOG_TAG, "onOptionsItemSelected: SCAN selected.");
                scanForDevice(true);
                return true;
            case R.id.action_stop_scan:
                Log.v(Constants.LOG_TAG, "onOptionsItemSelected: STOP SCAN selected.");
                scanForDevice(false);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

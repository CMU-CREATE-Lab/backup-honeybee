package org.cmucreatelab.android.honeybee.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import org.cmucreatelab.android.honeybee.R;
import org.cmucreatelab.android.honeybee.classes.HoneybeeMessage;
import org.cmucreatelab.android.honeybee.helpers.GlobalHandler;
import org.cmucreatelab.android.honeybee.helpers.static_classes.Constants;
import org.cmucreatelab.android.honeybee.helpers.static_classes.PacketManager;

public class HoneybeeShowActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(Constants.LOG_TAG, "HoneybeeShowActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honeybee_show);

        // button listeners
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoneybeeMessage m = new HoneybeeMessage("I01");
                GlobalHandler.getInstance(getApplicationContext()).melodySmartDeviceHandler.addMessage(m);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoneybeeMessage m = new HoneybeeMessage("W01");
                GlobalHandler.getInstance(getApplicationContext()).melodySmartDeviceHandler.addMessage(m);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HoneybeeMessage m = new HoneybeeMessage("R01");
                GlobalHandler.getInstance(getApplicationContext()).melodySmartDeviceHandler.addMessage(m);
            }
        });
        // join network
        findViewById(R.id.buttonJoinNetwork).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String securityType,ssid,key;
                securityType = ((EditText)findViewById(R.id.textInputSecurityType)).getText().toString();
                ssid = ((EditText)findViewById(R.id.textInputSsid)).getText().toString();
                key = ((EditText)findViewById(R.id.textInputSecurityKey)).getText().toString();

                String payload = String.format("%s,%s,%s", securityType, ssid, key);
                HoneybeeMessage m = PacketManager.constructMessage("J", payload);
                GlobalHandler.getInstance(getApplicationContext()).melodySmartDeviceHandler.addMessage(m);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        GlobalHandler.getInstance(getApplicationContext()).currentActivity = this;
    }


    @Override
    protected void onDestroy() {
        Log.v(Constants.LOG_TAG, "HoneybeeShowActivity.onDestroy");
        super.onDestroy();
        GlobalHandler.getInstance(getApplicationContext()).melodySmartDeviceHandler.disconnect();
    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        this.menu = menu;
//        return true;
//    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        switch (id) {
//            case R.id.action_scan:
//                Log.v(Constants.LOG_TAG, "onOptionsItemSelected: SCAN selected.");
//                scanForDevice(true);
//                return true;
//            case R.id.action_stop_scan:
//                Log.v(Constants.LOG_TAG, "onOptionsItemSelected: STOP SCAN selected.");
//                scanForDevice(false);
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}

package org.cmucreatelab.android.honeybee.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.cmucreatelab.android.honeybee.R;
import org.cmucreatelab.android.honeybee.helpers.GlobalHandler;
import org.cmucreatelab.android.honeybee.helpers.static_classes.Constants;

public class HoneybeeShowActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(Constants.LOG_TAG, "HoneybeeShowActivity.onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_honeybee_show);
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

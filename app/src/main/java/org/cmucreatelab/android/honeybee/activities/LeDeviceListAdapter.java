package org.cmucreatelab.android.honeybee.activities;

import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.cmucreatelab.android.honeybee.R;
import org.cmucreatelab.android.honeybee.classes.Honeybee;
import org.cmucreatelab.android.honeybee.helpers.static_classes.Constants;

import java.util.ArrayList;

/**
 * Created by Steve on 5/26/2016.
 *
 * LeDeviceListAdapter
 *
 * An adapter that handles displaying a various amount of flutters to the AppLandingActivity.
 *
 */
public class LeDeviceListAdapter extends BaseAdapter {

    private ArrayList<Honeybee> honeybees;
    private LayoutInflater mInflater;

    private static class ViewHolder {
        public TextView deviceName;
    }


    public LeDeviceListAdapter(LayoutInflater inflater) {
        super();
        honeybees = new ArrayList<>();
        mInflater = inflater;
    }


    public void addDevice(Honeybee honeybee) {
        Log.d(Constants.LOG_TAG, "Found device " + honeybee.getName());
        honeybees.add(honeybee);
        notifyDataSetChanged();
    }


    public void clearDevices() {
        honeybees.clear();
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return honeybees.size();
    }

    @Override
    public Object getItem(int position) {
        return honeybees.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_device, null);
            viewHolder = new ViewHolder();
            viewHolder.deviceName = (TextView) convertView.findViewById(R.id.device_name);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Honeybee honeybee = honeybees.get(position);

        final String deviceName = honeybee.getName();
        if (deviceName != null && deviceName.length() > 0) {
            viewHolder.deviceName.setText(deviceName);
        } else {
            viewHolder.deviceName.setText("???");
        }

        return convertView;
    }
}

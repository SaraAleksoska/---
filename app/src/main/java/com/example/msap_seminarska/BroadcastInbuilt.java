package com.example.msap_seminarska;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BroadcastInbuilt extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Battery is low. Please charge", Toast.LENGTH_SHORT).show();
    }
}
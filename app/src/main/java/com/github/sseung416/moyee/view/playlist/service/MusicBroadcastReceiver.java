package com.github.sseung416.moyee.view.playlist.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MusicBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "MusicBroadcastReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "onReceive: " );
        final MusicPlayerAction action = MusicPlayerAction.valueOf(intent.getAction());

        switch (action) {
            case PREVIOUS:
                Log.e(TAG, "onReceive: clicked Previous");
                break;
            case NEXT:
                Log.e(TAG, "onReceive: clicked Next");
                break;
            case PAUSE:
                Log.e(TAG, "onReceive: clicked Pause");
                break;
            case PLAY:
                Log.e(TAG, "onReceive: clicked Play");
                break;
        }
    }
}

package com.github.sseung416.moyee.view.playlist.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.IBinder;
import android.os.PowerManager;
import android.util.Log;

import androidx.annotation.Nullable;

public final class MusicPlayerService extends Service {

    private MediaPlayer mediaPlayer = null;
    private Notification notification;

    private WifiManager.WifiLock wifiLock;

    @Override
    public void onCreate() {
        super.onCreate();

//        wifiLock = ((WifiManager) getSystemService(Context.WIFI_SERVICE))
//                .createWifiLock(getWifiTypeByVersion(), "wifiLog");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e("TAG", "onStartCommand: ??");
        notification = new MusicNotification().createNotification(getApplicationContext());
        startForeground(1, notification);

//        final MusicPlayerAction action = MusicPlayerAction.valueOf(intent.getAction());
//
//        switch (action) {
//            case PREVIOUS:
//                break;
//            case NEXT:
//                break;
//            case PLAY:
//                break;
//            case PAUSE:
//        }

        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private void createMediaPlayerIfNeed() {
        if (mediaPlayer == null) {
            mediaPlayer = new MediaPlayer();

            // 절전 모드에도 중단되지 않게 WakeLock 설정
            mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
        } else {
            mediaPlayer.reset();
        }
    }

    /**
     * API 29부터 WIFI_MODE_FULL deprecated 됨
     * 참고 (https://stackoverflow.com/questions/70336178/how-to-set-wi-fi-in-lock-mode-in-api-29)
     */
    private int getWifiTypeByVersion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            return WifiManager.WIFI_MODE_FULL_LOW_LATENCY;
        } else {
            return WifiManager.WIFI_MODE_FULL;
        }
    }
}

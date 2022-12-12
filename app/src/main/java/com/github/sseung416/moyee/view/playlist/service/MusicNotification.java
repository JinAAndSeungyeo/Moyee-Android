package com.github.sseung416.moyee.view.playlist.service;

import static com.github.sseung416.moyee.view.playlist.service.MusicPlayerAction.*;
import static com.github.sseung416.moyee.view.playlist.service.MusicPlayerAction.PAUSE;
import static com.github.sseung416.moyee.view.playlist.service.MusicPlayerAction.PLAY;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.widget.RemoteViews;

import androidx.core.app.NotificationCompat;

import com.github.sseung416.moyee.R;

import java.net.URI;

public final class MusicNotification {

    private static final String CHANNEL_ID = "test";

    private Context context;

    public Notification createNotification(Context context) {
        this.context = context;

        final RemoteViews customView = createCustomNotification(
                "Tokyo Flash",
                "Vaundy",
                "https://image.bugsm.co.kr/album/images/500/202913/20291332.jpg",
                "3:20"
        );

        NotificationManager manager = context.getSystemService(NotificationManager.class);
        Notification notification = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentText("안녕하세요")
                .setContentTitle("타이ㅡㅌㄹ")
                .setOngoing(true)
                .setCustomBigContentView(customView)
                .build();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "무식 is my life", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(channel);
        }

        manager.notify(1, notification);

        return notification;
    }

    private PendingIntent createPendingIntentByAction(MusicPlayerAction action) {
        final Intent intent = new Intent(context, MusicNotification.class);
        intent.setAction(action.name());
        return PendingIntent.getService(context, 0, intent, PendingIntent.FLAG_IMMUTABLE);
    }

    private RemoteViews createCustomNotification(String title, String singer, String uri, String musicLength) {
        final PendingIntent previousPendingIntent = createPendingIntentByAction(PREVIOUS);
        final PendingIntent nextPendingIntent = createPendingIntentByAction(NEXT);
        final PendingIntent pausePendingIntent = createPendingIntentByAction(PAUSE);

        final RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.layout_music_player);

        remoteViews.setTextViewText(R.id.titleTextView, title);
        remoteViews.setTextViewText(R.id.singerTextView, singer);

        remoteViews.setOnClickPendingIntent(R.id.skipPreviousButton, previousPendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.skipNextButton, nextPendingIntent);
        remoteViews.setOnClickPendingIntent(R.id.pauseButton, pausePendingIntent);

        return remoteViews;
    }

    // 대충 브로드캐스트 리시버 연결해서 처리하라는 뜻임
    // 그럼 service 에 mediaPlayer 넣을게 아니라 클래스로 빼야할 듯
    // 프래그먼트 클릭 이벤트를 서비스에서 처리하고,
    // notification 에서 발생한 클릭 이벤트를 broadcastReceiver 에서 처리해주어야 할듯 ㅎ
    // 때려칠게요!
}

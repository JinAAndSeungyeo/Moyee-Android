package com.github.sseung416.moyee.view.chatlist;

import androidx.annotation.Nullable;

// 임시 데이터 클래스
public class Chat {
    private int id;
    private String name;
    private String message;
    private String time;
    private Boolean isNotification;

    public Chat(int id, String name, String message, String time, Boolean isNotification) {
        this.id = id;
        this.name = name;
        this.message = message;
        this.time = time;
        this.isNotification = isNotification;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public Boolean getIsNotification() {
        return isNotification;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}

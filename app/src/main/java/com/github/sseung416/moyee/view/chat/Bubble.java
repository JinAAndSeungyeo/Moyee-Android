package com.github.sseung416.moyee.view.chat;

import androidx.annotation.Nullable;

public class Bubble {
    // 임시 데이터
    public static final int TYPE_SENDER = 0;
    public static final int TYPE_RECEIVER = 1;

    private int id;
    private String content;

    public Bubble(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}

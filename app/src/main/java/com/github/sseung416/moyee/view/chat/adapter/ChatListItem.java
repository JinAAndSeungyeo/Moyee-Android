package com.github.sseung416.moyee.view.chat.adapter;

import com.github.sseung416.moyee.view.chat.Bubble;

import java.util.Objects;

public class ChatListItem {

    protected Bubble bubble;

    // todo check
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatListItem that = (ChatListItem) o;
        return Objects.equals(bubble, that.bubble);
    }

    public ChatListItem(Bubble bubble) {
        this.bubble = bubble;
    }

    public static final class Sender extends ChatListItem {

        public Sender(Bubble bubble) {
            super(bubble);
        }
    }

    public static final class Receiver extends ChatListItem {

        public Receiver(Bubble bubble) {
            super(bubble);
        }
    }
}

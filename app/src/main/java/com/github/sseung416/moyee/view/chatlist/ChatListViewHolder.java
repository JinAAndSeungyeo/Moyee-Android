package com.github.sseung416.moyee.view.chatlist;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sseung416.moyee.databinding.ItemChatBinding;

class ChatListViewHolder extends RecyclerView.ViewHolder {

    private ItemChatBinding binding;

    public ChatListViewHolder(@NonNull ItemChatBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Chat chat) {
        binding.setData(chat);
    }
}
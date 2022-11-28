package com.github.sseung416.moyee.view.chat;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sseung416.moyee.databinding.ItemBubbleReceiverBinding;
import com.github.sseung416.moyee.databinding.ItemBubbleSenderBinding;

public class ChatViewHolder extends RecyclerView.ViewHolder {

    public ChatViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public static final class ReceiverViewHolder extends ChatViewHolder {

        private final ItemBubbleReceiverBinding binding;

        public ReceiverViewHolder(@NonNull ItemBubbleReceiverBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String content) {
            binding.button.setText(content);
        }
    }

    public static final class SenderViewHolder extends ChatViewHolder {

        private final ItemBubbleSenderBinding binding;

        public SenderViewHolder(@NonNull ItemBubbleSenderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(String content) {
            binding.button2.setText(content);
        }
    }
}

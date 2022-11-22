package com.github.sseung416.moyee.view.chat;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sseung416.moyee.databinding.ItemBubbleReceiverBinding;

public class ReceiverViewHolder extends RecyclerView.ViewHolder {

    private final ItemBubbleReceiverBinding binding;

    public ReceiverViewHolder(@NonNull ItemBubbleReceiverBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String content) {
        binding.button.setText(content);
    }
}

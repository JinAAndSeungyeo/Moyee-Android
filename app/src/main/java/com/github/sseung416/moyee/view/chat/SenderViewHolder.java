package com.github.sseung416.moyee.view.chat;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sseung416.moyee.databinding.ItemBubbleSenderBinding;

public class SenderViewHolder extends RecyclerView.ViewHolder {

    private final ItemBubbleSenderBinding binding;

    public SenderViewHolder(@NonNull ItemBubbleSenderBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(String content) {
        binding.button2.setText(content);
    }
}

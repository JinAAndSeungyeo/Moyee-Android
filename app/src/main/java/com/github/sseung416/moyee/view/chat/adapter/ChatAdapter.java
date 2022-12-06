package com.github.sseung416.moyee.view.chat.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.github.sseung416.moyee.R;
import com.github.sseung416.moyee.databinding.ItemBubbleReceiverBinding;
import com.github.sseung416.moyee.databinding.ItemBubbleSenderBinding;

public class ChatAdapter extends ListAdapter<ChatListItem, ChatViewHolder> {

    public ChatAdapter() {
        super(DIFF_CALLBACK);
    }

    @Override
    public int getItemViewType(int position) {
        final ChatListItem item = getItem(position);

        if (item instanceof ChatListItem.Receiver) {
            return R.layout.item_bubble_receiver;
        } else if (item instanceof ChatListItem.Sender) {
            return R.layout.item_bubble_sender;
        }

        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        if (viewType == R.layout.item_bubble_sender) {
            return new ChatViewHolder.SenderViewHolder(
                    ItemBubbleSenderBinding.inflate(inflater, parent, false)
            );
        }

        return new ChatViewHolder.ReceiverViewHolder(
                ItemBubbleReceiverBinding.inflate(inflater, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        String content = getItem(position).bubble.getContent();

        if (holder instanceof ChatViewHolder.ReceiverViewHolder) {
            ((ChatViewHolder.ReceiverViewHolder) holder).bind(content);
        } else if (holder instanceof ChatViewHolder.SenderViewHolder) {
            ((ChatViewHolder.SenderViewHolder) holder).bind(content);
        }
    }

    public static final DiffUtil.ItemCallback<ChatListItem> DIFF_CALLBACK = new DiffUtil.ItemCallback<>() {
        @Override
        public boolean areItemsTheSame(@NonNull ChatListItem oldItem, @NonNull ChatListItem newItem) {
            Boolean isSameReceiverData = oldItem instanceof ChatListItem.Receiver
                    && newItem instanceof ChatListItem.Receiver
                    && oldItem.bubble.getId() == newItem.bubble.getId();

            Boolean isSameSenderData = oldItem instanceof ChatListItem.Sender
                    && newItem instanceof ChatListItem.Receiver
                    && oldItem.bubble.getId() == newItem.bubble.getId();

            return isSameReceiverData || isSameSenderData;

        }

        @Override
        public boolean areContentsTheSame(@NonNull ChatListItem oldItem, @NonNull ChatListItem newItem) {
            return oldItem.equals(newItem);
        }
    };
}


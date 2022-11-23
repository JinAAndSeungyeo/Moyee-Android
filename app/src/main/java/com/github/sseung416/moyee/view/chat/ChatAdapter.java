package com.github.sseung416.moyee.view.chat;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sseung416.moyee.R;
import com.github.sseung416.moyee.databinding.ItemBubbleReceiverBinding;
import com.github.sseung416.moyee.databinding.ItemBubbleSenderBinding;

public class ChatAdapter extends ListAdapter<Bubble, RecyclerView.ViewHolder> {

    public ChatAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case R.layout.item_bubble_sender:
                return new SenderViewHolder(ItemBubbleSenderBinding.inflate(inflater, parent, false));
            default:
                return new ReceiverViewHolder(ItemBubbleReceiverBinding.inflate(inflater, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        String content = getItem(position).getContent();

        if (holder instanceof SenderViewHolder) {
            ((SenderViewHolder) holder).bind(content);
        } else if (holder instanceof ReceiverViewHolder) {
            ((ReceiverViewHolder) holder).bind(content);
        }
    }

    @Override
    public int getItemViewType(int position) {
        switch (getItem(position).getId()) {
            case Bubble.TYPE_SENDER:
                return R.layout.item_bubble_sender;
            case Bubble.TYPE_RECEIVER:
                return R.layout.item_bubble_receiver;
            default:
                return super.getItemViewType(position);
        }
    }

    public static final DiffUtil.ItemCallback<Bubble> DIFF_CALLBACK = new DiffUtil.ItemCallback<Bubble>() {
        @Override
        public boolean areItemsTheSame(@NonNull Bubble oldItem, @NonNull Bubble newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Bubble oldItem, @NonNull Bubble newItem) {
            return oldItem.equals(newItem);
        }
    };
}


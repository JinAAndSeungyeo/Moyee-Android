package com.github.sseung416.moyee.view.chatlist;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.github.sseung416.moyee.databinding.ItemChatBinding;

public class ChatListAdapter extends ListAdapter<Chat, ChatViewHolder> {

    protected ChatListAdapter() {
        super(DIFF_UTIL);
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemChatBinding binding = ItemChatBinding.inflate(LayoutInflater.from(parent.getContext()));
        binding.getRoot().setLayoutParams(new RecyclerView.LayoutParams(MATCH_PARENT, WRAP_CONTENT));
        return new ChatViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public final static DiffUtil.ItemCallback<Chat> DIFF_UTIL = new DiffUtil.ItemCallback<>() {
        @Override
        public boolean areItemsTheSame(@NonNull Chat oldItem, @NonNull Chat newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Chat oldItem, @NonNull Chat newItem) {
            return oldItem.equals(newItem);
        }
    };
}

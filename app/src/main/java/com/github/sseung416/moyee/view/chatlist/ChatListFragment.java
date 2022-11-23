package com.github.sseung416.moyee.view.chatlist;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.sseung416.moyee.R;
import com.github.sseung416.moyee.databinding.FragmentChatListBinding;
import com.github.sseung416.moyee.view.BindingFragment;
import com.github.sseung416.moyee.view.chatlist.ChatListViewModel;

import java.util.ArrayList;
import java.util.LinkedList;

public class ChatListFragment extends BindingFragment<FragmentChatListBinding> {

    private ChatListViewModel viewModel;
    private final ChatListAdapter adapter = new ChatListAdapter();

    public ChatListFragment() {
        super(R.layout.fragment_chat_list);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ChatListViewModel.class);
        binding.setVm(viewModel);

        binding.rvChatList.setAdapter(adapter);
        setDummy();
    }

    private void setDummy() {
        adapter.submitList(new LinkedList<>(){{
            add(new Chat(1, "박지나", "승연아 일 안 해?", "오후 03:24", true));
            add(new Chat(2, "박지나", "승연아 일 안 해?", "오후 03:24", true));
            add(new Chat(3, "박지나", "승연아 일 안 해?", "오후 03:24", false));
            add(new Chat(4, "박지나", "승연아 일 안 해?", "오후 03:24", false));
            add(new Chat(5, "박지나", "승연아 일 안 해?", "오후 03:24", true));
        }});
    }
}
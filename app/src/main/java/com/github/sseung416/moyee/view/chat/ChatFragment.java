package com.github.sseung416.moyee.view.chat;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.github.sseung416.moyee.R;
import com.github.sseung416.moyee.databinding.FragmentChatBinding;
import com.github.sseung416.moyee.view.BindingFragment;

import java.util.LinkedList;

public class ChatFragment extends BindingFragment<FragmentChatBinding> {

    private ChatViewModel viewModel;
    private final ChatAdapter adapter = new ChatAdapter();

    public ChatFragment() {
        super(R.layout.fragment_chat);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(ChatViewModel.class);
        binding.setVm(viewModel);

        binding.rvChat.setAdapter(adapter);
        setDummy();

        binding.etInput.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                binding.rvChat.smoothScrollToPosition(adapter.getItemCount() - 1);
            }
        });
    }

    private void setDummy() {
        adapter.submitList(new LinkedList<>() {{
            add(new Bubble(Bubble.TYPE_SENDER, "야 ㅋdsfsdfsdkfhsdkjfjsdkfhsdkjfhjsdkfkjhsadkfdfasdjkfhhjkdsfjhsdfhjkfdskjjkdfsjkhfdhjkdfsjkhdfshjkdsfjhkdsjkfhsdjkfhkasdjfhsdajhfkhjkㅏㅁㄴㅇ롸ㅘㅇ러ㅏㄴ오ㅓㅏ라ㅗㅓㄴㅇ로ㅓㅏㅏㄴ오ㅓ라ㅗㅓㄴ아로ㅓㄴㅇㄹ"));
            add(new Bubble(Bubble.TYPE_SENDER, "야 ㅋ"));
            add(new Bubble(Bubble.TYPE_SENDER, "야 ㅋ"));
            add(new Bubble(Bubble.TYPE_RECEIVER, "왜 ㅠㅠ"));
        }});
    }
}
package com.github.sseung416.moyee.view.register;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.sseung416.moyee.databinding.FragmentRegisterItemIdBinding;

public class RegisterItemIdFragment extends Fragment {

    RegisterViewModel viewModel;
    FragmentRegisterItemIdBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRegisterItemIdBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(requireActivity()).get(RegisterViewModel.class);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        binding.setVm(viewModel);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextWatcher watcher = new ErrorTextWatcher(() -> viewModel.errorMsg.setValue(""));

        binding.etId.addTextChangedListener(watcher);
        binding.etPassword.addTextChangedListener(watcher);
        binding.etPasswordCheck.addTextChangedListener(watcher);
    }
}
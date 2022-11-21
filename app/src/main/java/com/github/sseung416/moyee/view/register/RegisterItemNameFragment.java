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

import com.github.sseung416.moyee.databinding.FragmentRegisterItemNameBinding;

public class RegisterItemNameFragment extends Fragment {

    private RegisterViewModel viewModel;
    private FragmentRegisterItemNameBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRegisterItemNameBinding.inflate(inflater);
        viewModel = new ViewModelProvider(requireActivity()).get(RegisterViewModel.class);
        binding.setVm(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextWatcher watcher = new ErrorTextWatcher(() -> viewModel.errorMsg.setValue(""));

        binding.etNmae.addTextChangedListener(watcher);
        binding.etNickname.addTextChangedListener(watcher);
    }
}
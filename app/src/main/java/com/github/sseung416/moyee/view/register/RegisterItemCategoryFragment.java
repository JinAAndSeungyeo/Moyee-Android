package com.github.sseung416.moyee.view.register;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.github.sseung416.moyee.databinding.FragmentRegisterItemCategoryBinding;

public class RegisterItemCategoryFragment extends Fragment {

    private RegisterViewModel viewModel;
    private FragmentRegisterItemCategoryBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRegisterItemCategoryBinding.inflate(inflater);
        viewModel = new ViewModelProvider(requireActivity()).get(RegisterViewModel.class);
        binding.setVm(viewModel);
        binding.setLifecycleOwner(getViewLifecycleOwner());
        return binding.getRoot();
    }
}
package com.github.sseung416.moyee.view.register;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.github.sseung416.moyee.R;
import com.github.sseung416.moyee.databinding.FragmentRegisterBinding;
import com.github.sseung416.moyee.view.BindingFragment;
import com.zhpan.indicator.enums.IndicatorSlideMode;
import com.zhpan.indicator.enums.IndicatorStyle;

public class RegisterFragment extends BindingFragment<FragmentRegisterBinding> {

    // todo(옮기기)
    public static final int ID = 0;
    public static final int NAME = 1;
    public static final int KEYWORD = 2;

    private RegisterViewModel viewModel;

    public RegisterFragment() {
        super(R.layout.fragment_register);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(RegisterViewModel.class);
        binding.setVm(viewModel);

        initViewPager2();
        observe();

        binding.btnNext.setOnClickListener(v -> viewModel.verify(binding.viewPager.getCurrentItem()));
    }

    private void initViewPager2() {
        binding.viewPager.setAdapter(new RegisterAdapter(requireActivity()));
        binding.viewPager.setUserInputEnabled(false);
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                binding.indicator.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 1) {
                    super.onPageSelected(position);
                    binding.linearLayout.setVisibility(View.INVISIBLE);
                    binding.indicator.onPageSelected(position);
                }
            }
        });

        binding.indicator.setSlideMode(IndicatorSlideMode.SMOOTH);
        binding.indicator.setIndicatorStyle(IndicatorStyle.CIRCLE);
        binding.indicator.setPageSize(3);
        binding.indicator.setSliderColor(
                ContextCompat.getColor(requireContext(), R.color.white),
                ContextCompat.getColor(requireContext(), R.color.main)
        );
        binding.indicator.setSliderWidth(10f);
        binding.indicator.setSliderHeight(5f);
        binding.indicator.notifyDataChanged();
    }

    private void observe() {
        final LifecycleOwner owner = getViewLifecycleOwner();

        viewModel.next.observe(owner, pos -> {
            switch (pos) {
                case KEYWORD:
                    Toast.makeText(requireContext(), "회원가입에 성공했습니다!", Toast.LENGTH_LONG).show();
                    break;
                case NAME:
                    binding.linearLayout.setVisibility(View.INVISIBLE);
                default:
                    binding.viewPager.setCurrentItem(pos);
            }
        });
    }
}
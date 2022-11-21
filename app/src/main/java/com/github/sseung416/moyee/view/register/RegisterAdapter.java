package com.github.sseung416.moyee.view.register;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class RegisterAdapter extends FragmentStateAdapter {

    public RegisterAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public RegisterAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public RegisterAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case RegisterFragment.ID:
                return new RegisterItemIdFragment();
            case RegisterFragment.NAME:
                return new RegisterItemNameFragment();
            default:
                return new RegisterItemCategoryFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

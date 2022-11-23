package com.github.sseung416.moyee.view;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.BindingAdapter;

import java.util.Objects;

public class BindingAdapters {

    @BindingAdapter("navigationIconTint")
    public static void setNavigationIconTint(@NonNull Toolbar toolbar, @ColorInt int color) {
        Objects.requireNonNull(toolbar.getNavigationIcon()).setTint(color);
    }
}
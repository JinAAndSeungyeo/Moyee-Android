package com.github.sseung416.moyee.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.github.sseung416.moyee.R;

public class CircleImageView extends LinearLayout {

    private ImageView imageView;

    public CircleImageView(@NonNull Context context) {
        super(context);
        inflate(context);
    }

    public CircleImageView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        getAttrs(context, attrs);
        inflate(context);
    }

    private void inflate(Context context) {
        inflate(context, R.layout.layout_circle_image_view, this);
        imageView = findViewById(R.id.civ_img);
    }

    private void getAttrs(Context context, AttributeSet attributeSet) {
        final TypedArray typedArray =
                this.getContext().obtainStyledAttributes(attributeSet, R.styleable.CircleImageView);
        final int drawableRes =
                typedArray.getResourceId(R.styleable.CircleImageView_android_src, R.drawable.background_bubble_receiver);
//        imageView.setImageDrawable(ContextCompat.getDrawable(context, drawableRes));
        typedArray.recycle();
    }
}

package com.github.sseung416.moyee.view.register;

import android.text.Editable;
import android.text.TextWatcher;

public class ErrorTextWatcher implements TextWatcher {

    private Runnable event;

    public ErrorTextWatcher(Runnable event) {
        this.event = event;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        event.run();
    }

    @Override
    public void afterTextChanged(Editable editable) {}
}

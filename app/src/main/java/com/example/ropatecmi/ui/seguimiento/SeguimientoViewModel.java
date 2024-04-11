package com.example.ropatecmi.ui.seguimiento;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SeguimientoViewModel extends ViewModel  {

    private final MutableLiveData<String> mText;

    public SeguimientoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Cuando Compres un producto aqui aparecera el seguimiento del envio :) ");
    }

    public LiveData<String> getText() {
        return mText;
    }

}

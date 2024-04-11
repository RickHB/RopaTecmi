package com.example.ropatecmi.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ropatecmi.ui.home.Producto;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<Producto> productoLiveData;

    public GalleryViewModel() {
        productoLiveData = new MutableLiveData<>();
    }

    public LiveData<Producto> getProductoLiveData() {
        return productoLiveData;
    }

    public void setProducto(Producto producto) {
        productoLiveData.postValue(producto);
    }
}

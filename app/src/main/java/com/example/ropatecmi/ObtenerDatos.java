package com.example.ropatecmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.example.ropatecmi.ui.home.Producto;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;

import com.example.ropatecmi.ui.gallery.GalleryViewModel;
import com.example.ropatecmi.ui.home.Producto;

public class ObtenerDatos extends AppCompatActivity {

    private GalleryViewModel galleryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicializar GalleryViewModel
        galleryViewModel = new ViewModelProvider(this).get(GalleryViewModel.class);

        // Obtener el objeto Producto del intent
        Producto producto = (Producto) getIntent().getSerializableExtra("producto");



        // Puedes finalizar la actividad si ya has completado la comunicación con GalleryViewModel
         finish();
    }
}



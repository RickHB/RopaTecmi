package com.example.ropatecmi.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.ropatecmi.ui.home.Producto;
import com.example.ropatecmi.R;
import com.example.ropatecmi.databinding.FragmentGalleryBinding;

import androidx.lifecycle.ViewModelProvider;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private TextView textViewNombre;
    private TextView textViewPrecio;
    private TextView textViewTalla;
    private TextView textViewMensajeSinProducto;
    private ImageView imageViewIzquierda;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        galleryViewModel = new ViewModelProvider(requireActivity()).get(GalleryViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener referencias a los TextViews
        textViewNombre = view.findViewById(R.id.textViewNombre);
        textViewPrecio = view.findViewById(R.id.textViewPrecio);
        textViewTalla = view.findViewById(R.id.textViewTalla);
        textViewMensajeSinProducto = view.findViewById(R.id.textViewMensajeSinProducto);
        imageViewIzquierda = view.findViewById(R.id.imageViewIzquierda);

        // Observar el LiveData para mostrar los datos del producto
        galleryViewModel.getProductoLiveData().observe(getViewLifecycleOwner(), producto -> {
            if (producto != null && !producto.getNombre().isEmpty()) {
                // Mostrar los TextViews y actualizar los datos del producto
                textViewNombre.setVisibility(View.VISIBLE);
                textViewNombre.setText("Nombre: " + producto.getNombre());
                textViewPrecio.setVisibility(View.VISIBLE);
                textViewPrecio.setText("Precio: " + producto.getPrecio());
                textViewTalla.setVisibility(View.VISIBLE);
                textViewTalla.setText("Talla: " + producto.getTalla());
                imageViewIzquierda.setVisibility(View.VISIBLE);
            } else {
                // Ocultar los TextViews y mostrar mensaje predeterminado
                textViewNombre.setVisibility(View.GONE);
                textViewPrecio.setVisibility(View.GONE);
                textViewTalla.setVisibility(View.GONE);
                imageViewIzquierda.setVisibility(View.GONE);
                textViewMensajeSinProducto.setVisibility(View.VISIBLE);
            }
        });

        // Si el LiveData no ha sido actualizado aún (por ejemplo, al iniciar la vista), actualizarlo con un producto vacío
        if (galleryViewModel.getProductoLiveData().getValue() == null) {
            galleryViewModel.setProducto(new Producto("", "", ""));
        }
    }


}





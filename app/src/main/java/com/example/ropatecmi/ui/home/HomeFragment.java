package com.example.ropatecmi.ui.home;

import android.view.animation.Animation;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.ropatecmi.ObtenerDatos;
import com.example.ropatecmi.R;
import com.example.ropatecmi.databinding.FragmentHomeBinding;
import com.example.ropatecmi.ui.gallery.GalleryFragment;
import com.example.ropatecmi.ui.gallery.GalleryViewModel;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private GalleryViewModel galleryViewModel;

    private boolean isHeartFilled = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.scale_animation);
                binding.fab.startAnimation(anim);

                if (isHeartFilled) {
                    binding.fab.setImageResource(R.drawable.heart); // Cambiar a corazón vacío
                } else {
                    binding.fab.setImageResource(R.drawable.heartliked); // Cambiar a corazón lleno
                }
                isHeartFilled = !isHeartFilled;

                // Obtener nombre, precio y talla
                String nombre = binding.textHome.getText().toString();
                String precio = binding.priceTextView.getText().toString();
                String talla = binding.sizeSpinner.getSelectedItem().toString();

                // Crear un objeto para almacenar los datos
                Producto producto = new Producto(nombre, precio, talla);

                // Obtener el ViewModel y establecer el producto
                galleryViewModel = new ViewModelProvider(requireActivity()).get(GalleryViewModel.class);
                galleryViewModel.setProducto(producto);

                // Navegar a la siguiente actividad
                Intent intent = new Intent(getActivity(), ObtenerDatos.class);
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

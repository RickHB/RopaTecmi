package com.example.ropatecmi;

// Importaciones necesarias
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ropatecmi.databinding.ActivityHeaderBinding;

// Definición de la clase Header
public class Header extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration; // Configuración de la barra de aplicación
    private ActivityHeaderBinding binding; // Variable para la vinculación de vistas

    // Método onCreate, llamado al iniciar la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHeaderBinding.inflate(getLayoutInflater()); // Inflar la vista de la actividad
        setContentView(binding.getRoot()); // Establecer la vista raíz

        setSupportActionBar(binding.appBarHeader.toolbar); // Establecer la barra de herramientas como la barra de aplicación

        // Configuración del cajón de navegación
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.nav_seguimiento)
                .setOpenableLayout(drawer)
                .build();

        // Configuración del controlador de navegación y la barra de aplicación
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_header);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    // Método onCreateOptionsMenu, para crear el menú de opciones en la barra de aplicación
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.header, menu); // Inflar el menú de opciones
        return true;
    }

    // Método onSupportNavigateUp, llamado cuando se presiona el botón de navegación hacia arriba
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_header);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

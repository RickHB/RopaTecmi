package com.example.ropatecmi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button btnLogin;
    private EditText etUsername;
    private EditText etPassword;
    private List<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);
        btnLogin = findViewById(R.id.btn_login);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        btnLogin.setEnabled(false);

        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Hola", "Contraseña1"));
        usuarios.add(new Usuario("Hola2", "Contraseña2"));
        usuarios.add(new Usuario("h", "h"));


        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Verificar si ambos campos están llenos para habilitar el botón
                if (!etUsername.getText().toString().isEmpty() && !etPassword.getText().toString().isEmpty()) {
                    btnLogin.setEnabled(true);
                } else {
                    btnLogin.setEnabled(false);
                }
            }
        };

        etUsername.addTextChangedListener(textWatcher);
        etPassword.addTextChangedListener(textWatcher);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mostrar la animación
                progressBar.setVisibility(View.VISIBLE);
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.scale_animation);
                btnLogin.startAnimation(anim);
                btnLogin.setEnabled(false);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String username = etUsername.getText().toString();
                        String password = etPassword.getText().toString();

                        boolean credencialesCorrectas = false;
                        for (Usuario usuario : usuarios) {
                            if (usuario.getUsername().equals(username) && usuario.getPassword().equals(password)) {
                                credencialesCorrectas = true;
                                break;
                            }
                        }

                        if (credencialesCorrectas) {
                            // Si las credenciales son correctas, iniciar la nueva actividad
                            Intent intent = new Intent(MainActivity.this, Header.class);
                            startActivity(intent);
                        } else {
                            // Si las credenciales no son correctas, mostrar un mensaje de error
                            Toast.makeText(MainActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                        }

                        // Ocultar la animación y habilitar el botón
                        progressBar.setVisibility(View.GONE);
                        btnLogin.setEnabled(true);
                    }
                }, 2000);
            }
        });
    }
}
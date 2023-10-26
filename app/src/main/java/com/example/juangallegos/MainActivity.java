package com.example.juangallegos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import com.example.juangallegos.R;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Simula una carga de 5 segundos
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Cambia a la clase Maps después de 5 segundos
                Intent intent = new Intent(MainActivity.this, Mapas.class);
                startActivity(intent);

                // Finaliza la actividad actual para que no se pueda volver a ella desde Maps
                finish();
            }
        }, 5000); // (5 segundos)
    }
}
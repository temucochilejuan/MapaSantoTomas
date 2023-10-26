package com.example.juangallegos;

import androidx.annotation.NonNull;
import android.widget.VideoView;
import android.widget.MediaController;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.List;

public class Mapas extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener{

    EditText txtlatitud, txtlongitud;
    GoogleMap mMap;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);

        // Inicializa el VideoView
        videoView = findViewById(R.id.videoView);

        // Establece la ruta del video (asegúrate de tener el video en la carpeta res/raw/)
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video);
        // Configura los controles multimedia (reproducir, pausar, etc.)
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

        // Inicia la reproducción automática del video
        videoView.start();
    }


    @Override
    public void onMapClick(@NonNull LatLng latLng) {

    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        this.mMap.setOnMapClickListener(this);
        this.mMap.setOnMapLongClickListener(this::onMapClick);
        LatLng southAmericaCenter = new LatLng(-20, -60);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(southAmericaCenter, 4));  // Puedes ajustar el nivel de zoom según tus necesidades


        List<LocationMarker> locations = new ArrayList<>();
        locations.add(new LocationMarker (new LatLng(-18.483212600790978, -70.31041831879779), "Arica. 18 de Septiembre 1191"));
        locations.add(new LocationMarker (new LatLng(-20.23965540359343, -70.144867971164), "Iquique. Av. Héroes de la Concepción 2885"));
        locations.add(new LocationMarker (new LatLng(-23.634584045169706, -70.39406333217275),"Antofagasta. Av. Iquique 3991"));
        locations.add(new LocationMarker (new LatLng(-29.76411241547793, -71.29267048003398), "La Serena. Ruta 5 Norte 1068"));
        locations.add(new LocationMarker (new LatLng(-33.03754230094441, -71.52212563304559), "Viña del Mar. 1 Nte. 3041"));
        locations.add(new LocationMarker (new LatLng(-33.44840576169196, -70.66073063978168), "Santiago. Av. Ejército Libertador 146"));
        locations.add(new LocationMarker (new LatLng(-35.42864771613577, -71.67291721942158), "Talca. Av. Carlos Schorr 255"));
        locations.add(new LocationMarker (new LatLng(-36.82623459381613, -73.06162837963693), "Concepción. Arturo Prat 879"));
        locations.add(new LocationMarker (new LatLng(-37.47192844782211, -72.35396271638434), "Los Ángeles. Manuel Rodríguez 140"));
        locations.add(new LocationMarker (new LatLng(-38.734579690924974, -72.60200312536959), "Temuco. Manuel Rodriguez 060"));
        locations.add(new LocationMarker (new LatLng(-39.81728323455412, -73.23311686702574), "Valdivia. Av. Ramón Picarte 1160"));
        locations.add(new LocationMarker (new LatLng(-40.5716847536876, -73.13769376099003), "Osorno. Los Carrera 753"));
        locations.add(new LocationMarker (new LatLng(-41.47268505043663, -72.92884273156733), "Puerto Montt. Buena Vecindad 91"));


        for (LocationMarker  direcciones : locations){
            LatLng location = direcciones.getLocation();
            String tittle = direcciones.getTitle();

            mMap.addMarker(new MarkerOptions().position(location).title(tittle));
        }
    }

}
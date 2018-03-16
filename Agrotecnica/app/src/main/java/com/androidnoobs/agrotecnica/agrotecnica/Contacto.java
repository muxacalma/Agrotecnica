package com.androidnoobs.agrotecnica.agrotecnica;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;

//<meta-data android:name="com.google.android.geo.API_KEY" android:value="your API key"/>

public class Contacto extends FragmentActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }
}

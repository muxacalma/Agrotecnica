package com.androidnoobs.agrotecnica.agrotecnica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.facebook.login.LoginManager;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;

//<meta-data android:name="com.google.android.geo.API_KEY" android:value="your API key"/>

public class Contacto extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        FragmentManager fm=this.getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
               .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_poweroff:
                //logout
                LoginManager.getInstance().logOut();

                FirebaseAuth.getInstance().signOut();
                //intent a login
                Intent in=new Intent(this,Login.class);
                startActivity(in);
                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mMap.getUiSettings().setZoomControlsEnabled(true);

        LatLng agrotecnica = new LatLng(38.869874, -1.096996);
        mMap.addMarker(new MarkerOptions().position(agrotecnica).title("Marker in agrotecnica"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(agrotecnica));
    }
}

package com.androidnoobs.agrotecnica.agrotecnica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DetalleProducto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);
    }


    public void realizarCompra(View v){

        Toast.makeText(getApplicationContext(), "ENTRA EN COMPRAR", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, Gracias.class);
        startActivity(i);
    }
}

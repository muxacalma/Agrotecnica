package com.androidnoobs.agrotecnica.agrotecnica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleProducto extends AppCompatActivity {

    TextView nombre, precio, stock, descripciónProducto;
    ImageView Imagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_producto);

        nombre = findViewById(R.id.dpNombreProducto);
        precio = findViewById(R.id.dpPrecio);
        stock = findViewById(R.id.dpStock);
        descripciónProducto = findViewById(R.id.dpDescricionProducto);

        Imagen = findViewById(R.id.dpImagen);

    }


    public void realizarCompra(View v){


        Intent i = new Intent(this, Gracias.class);
        startActivity(i);
    }
}

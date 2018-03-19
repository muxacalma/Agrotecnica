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

        Intent i = getIntent();
        Producto p = i.getParcelableExtra("producto");

        nombre = findViewById(R.id.dpNombreProducto);
        nombre.setText(p.getNombre().toString());

        precio = findViewById(R.id.dpPrecio);
        precio.setText(p.getPrecio().toString());

        stock = findViewById(R.id.dpStock);
        stock.setText("" + p.getStock());

        descripciónProducto = findViewById(R.id.dpDescricionProducto);
        descripciónProducto.setText(p.getDescripcion().toString());

        Imagen = findViewById(R.id.dpImagen);

    }


    public void realizarCompra(View v){


        Intent i = new Intent(this, Gracias.class);
        startActivity(i);
    }
}

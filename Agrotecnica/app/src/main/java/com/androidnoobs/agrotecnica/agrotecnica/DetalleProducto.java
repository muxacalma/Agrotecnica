package com.androidnoobs.agrotecnica.agrotecnica;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class DetalleProducto extends AppCompatActivity {

    TextView nombre, precio, stock, descripciónProducto;
    ImageView im;


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

        im = findViewById(R.id.dpImagen);
        Picasso.with(getApplicationContext()).load(p.getImagen()).into(im);


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


    public void realizarCompra(View v){


        Intent i = new Intent(this, Gracias.class);
        startActivity(i);
    }
}

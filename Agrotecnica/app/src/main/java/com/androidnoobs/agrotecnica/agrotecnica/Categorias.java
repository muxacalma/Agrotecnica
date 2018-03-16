package com.androidnoobs.agrotecnica.agrotecnica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class Categorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
    }

    public void entrarEnProductos(View v){
        String producto;
        producto="";
        switch(v.getId()){
            case R.id.button:
                producto="Semillas";
            case R.id.button2:
                producto="Tratamientos";
            case R.id.button3:
                producto="Herramientas";
            case R.id.button4:
                producto="Maquinaria";
        }
        Intent intent=new Intent(this, ListaProductos.class);
        intent.putExtra("categoria", producto);
        this.startActivity(intent);
    }

    public void entrarEnContacto(View v){
        Intent intent=new Intent(this, Contacto.class);
                this.startActivity(intent);
    }
}

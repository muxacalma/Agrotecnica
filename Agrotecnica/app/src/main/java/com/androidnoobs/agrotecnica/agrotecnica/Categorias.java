package com.androidnoobs.agrotecnica.agrotecnica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

public class Categorias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);
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

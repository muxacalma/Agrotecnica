package com.androidnoobs.agrotecnica.agrotecnica;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void guardad(View v){
        String nombre=((EditText)findViewById(R.id.nombre)).getText().toString();
        String apellidos=((EditText)findViewById(R.id.apellidos)).getText().toString();
        String mail=((EditText)findViewById(R.id.email)).getText().toString();
        String contraseña=((EditText)findViewById(R.id.contraseña)).getText().toString();
        String contraseña_encrip=md5(contraseña);


        //FALTA HACER EL SERVICE

        finish();
    }
    public static final String md5(final String contraseña) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance(MD5);
            digest.update(contraseña.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}

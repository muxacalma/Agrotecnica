package com.androidnoobs.agrotecnica.agrotecnica;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);
    }

    public void entrar(View v){
        String mail=((EditText)findViewById(R.id.email)).getText().toString();
        String contraseña=((EditText)findViewById(R.id.contraseña)).getText().toString();
        String contraseña_encrip=md5(contraseña);

        //FALTA HACER EL SERVICE

        //SI EL UNUARIO ES CORRECTO SE VA A LA ACTIVITY DE CATEGORIAS
        Intent in=new Intent(this,Categorias.class);
        startActivity(in);
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

    public void registrar(View v){
        Intent in=new Intent(this,Registro.class);
        startActivity(in);
    }

    public void facebook(View v){
        CallbackManager callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Intent in=new Intent(Login.this,Categorias.class);
                        startActivity(in); // App code
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(Login.this,"No se ha podido realizar la conexión" , Toast.LENGTH_LONG).show();

                        // App code
                    }
                });

    }


    @Override

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        CallbackManager callbackManager = CallbackManager.Factory.create();
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


}

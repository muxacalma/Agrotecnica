package com.androidnoobs.agrotecnica.agrotecnica;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Registro extends AppCompatActivity {

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        mAuth = FirebaseAuth.getInstance();
    }


    public void registroFirebase(View v) {

        final String email = ((EditText) findViewById(R.id.email)).getText().toString();
        final String password = ((EditText) findViewById(R.id.contrasena)).getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            FirebaseUser user = mAuth.getCurrentUser();
                            // intent a categorias
                            Intent in = new Intent(Registro.this, Categorias.class);
                            startActivity(in);
                            // updateUI(user);

                            SharedPreferences sp = Registro.this.getSharedPreferences("email", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putString("email", email);
                            editor.putString("contraseña", password);
                        } else {
                            Log.d("VICTORIA", task.getException() + "----");
                            // If sign in fails, display a message to the user.

                            Toast.makeText(Registro.this, "No es posible registrar, prueba añadiendo una contraseña de mas de 6 caracteres o posiblemente ya estes registrado .",
                                    Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void cambiar(View v) {

        Toast.makeText(getApplicationContext(), "Te hemos enviado un email para que restablezcas tu contraseña", Toast.LENGTH_SHORT).show();
        FirebaseAuth auth = FirebaseAuth.getInstance();
        String emailAddress = "user@example.com";

        auth.sendPasswordResetEmail(emailAddress)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("VICTORIA", "Email sent.");
                        }
                    }

                });

    }
}

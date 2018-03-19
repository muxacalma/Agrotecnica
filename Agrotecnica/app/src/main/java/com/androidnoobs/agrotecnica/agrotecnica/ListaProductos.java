package com.androidnoobs.agrotecnica.agrotecnica;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ListaProductos extends AppCompatActivity {

    private String categoria;
    ListView lvProductos;
    ArrayList <Producto> datosproducto=new ArrayList<Producto>();
    AdapterProducto adapterProducto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);



        Intent intent = this.getIntent();
        categoria = intent.getStringExtra("categoria");

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest sr = new StringRequest(Request.Method.POST, "http://juansancho.es/agrotecnica/listaProductos.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Log.d("Recibido",response.toString());
                        try {

                            JSONArray jarray=new JSONArray(response);
                            for (int i=0; i<jarray.length(); i++){
                                JSONObject job=jarray.getJSONObject(i);
                                int id=job.getInt("id");
                                String nombre=job.getString("nombre");
                                String descripcion=job.getString("descripcion");
                                String precio=job.getString("precio");
                                String imagen=job.getString("imagen");
                                int stock=job.getInt("stock");
                                String categoria=job.getString("categoria");
                                Producto producto=new Producto(id, nombre, descripcion, precio, imagen, stock,categoria);
                                datosproducto.add(producto);
                            }
                            cargarLista(datosproducto);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mPostCommentResponse.requestEndedWithError(error);
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("categoria", categoria);

                return params;
            }

          /*  @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded");
                return params;
            }*/
        };
        queue.add(sr);
    }

    public void cargarLista(final ArrayList datosproducto){
        lvProductos=(ListView) this.findViewById(R.id.listProducto);
        adapterProducto=new AdapterProducto(this, datosproducto);
        lvProductos.setAdapter(adapterProducto);

        lvProductos.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(ListaProductos.this,DetalleProducto.class);
                intent.putExtra("producto", (Parcelable) datosproducto.get(i));
                ListaProductos.this.startActivity(intent);

            }
        });

    }

}

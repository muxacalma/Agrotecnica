package com.androidnoobs.agrotecnica.agrotecnica;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gemma on 19/03/2018.
 */

public class AdapterProducto extends ArrayAdapter <Producto>{

    private Context contexto;
    private ArrayList<Producto> listaProducto=new ArrayList<Producto>();

    public AdapterProducto(@NonNull Context context, ArrayList<Producto> lista) {
        super(context,0, lista);
        contexto=context;
        listaProducto=lista;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null)
            listItem = LayoutInflater.from(contexto).inflate(R.layout.activity_vista_list_view, parent,false);

        Producto actualproducto =listaProducto.get(position);



        ImageView image = (ImageView)listItem.findViewById(R.id.imagenProducto);
        Picasso.with(contexto).load(actualproducto.getImagen()).into(image);

        TextView name = (TextView) listItem.findViewById(R.id.nombreProducto);
        name.setText(actualproducto.getNombre());

        TextView release = (TextView) listItem.findViewById(R.id.precioProducto);
        release.setText(actualproducto.getPrecio());

        return listItem;
    }
}

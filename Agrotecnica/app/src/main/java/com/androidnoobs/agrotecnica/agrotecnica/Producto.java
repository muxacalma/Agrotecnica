package com.androidnoobs.agrotecnica.agrotecnica;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Gemma on 16/03/2018.
 */

public class Producto implements Parcelable{
    private int id;
    private String nombre;
    private String descripcion;
    private String precio;
    private String imagen;
    private int stock;
    private String categoria;

    public Producto (int id, String nombre, String descripcion, String precio, String imagen, int stock, String categoria){
        this.id=id;
        this.nombre=nombre;
        this.descripcion=descripcion;
        this.precio=precio;
        this.imagen=imagen;
        this.stock=stock;
        this.categoria=categoria;
    }


    protected Producto(Parcel in) {
        id = in.readInt();
        nombre = in.readString();
        descripcion = in.readString();
        precio = in.readString();
        imagen = in.readString();
        stock = in.readInt();
        categoria = in.readString();
    }

    public static final Creator<Producto> CREATOR = new Creator<Producto>() {
        @Override
        public Producto createFromParcel(Parcel in) {
            return new Producto(in);
        }

        @Override
        public Producto[] newArray(int size) {
            return new Producto[size];
        }
    };

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }

    public String getPrecio(){
        return precio;
    }

    public void setPrecio(String precio){
        this.precio=precio;
    }

    public String getImagen(){
        return imagen;
    }

    public void setImagen(String imagen){
        this.imagen=imagen;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock){
        this.stock=stock;
    }

    public String getCategoria(){
        return categoria;
    }

    public void setCategoria(String categoria){
        this.categoria=categoria;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(nombre);
        parcel.writeString(descripcion);
        parcel.writeString(precio);
        parcel.writeString(imagen);
        parcel.writeInt(stock);
        parcel.writeString(categoria);
    }
}
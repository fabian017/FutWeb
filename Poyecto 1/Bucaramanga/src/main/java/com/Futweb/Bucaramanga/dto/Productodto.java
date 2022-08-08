package com.Futweb.Bucaramanga.dto;

import com.Futweb.Bucaramanga.entity.Producto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;

public class Productodto {
    public  String nombre;
    public double precio;
    public int stock;
    public String categoria;

    public String descripcion;

    public Producto getProductodto() {
        Producto producto=new Producto();
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setStock(stock);
        producto.setCategoria(categoria);
        producto.setDescripcion(descripcion);
        return producto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

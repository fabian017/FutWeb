package com.Futweb.Bucaramanga.service;

import com.Futweb.Bucaramanga.dto.Productodto;
import com.Futweb.Bucaramanga.entity.Producto;
import com.Futweb.Bucaramanga.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductoServiceImpl implements  ProductoService{

    @Autowired
    ProductoRepository productorepository;

    @Override
    public Producto guardar(Productodto producto) {
        Producto newproduct=producto.getProductodto();
        return productorepository.save(newproduct);
    }

    @Override
    public List<Producto> mostrartodo() {
        return productorepository.findAll();
    }

    @Override
    public Producto actualizar(Producto producto) {
        return productorepository.save(producto);
    }

    @Override
    public List<Producto> findone(Long id) {
        return productorepository.findAllById(Collections.singleton(id));
    }

    @Override
    public String deleteproduct(Long id){
        productorepository.deleteById(id);
        return "200";}

}

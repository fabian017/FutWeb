package com.Futweb.Bucaramanga.service;

import com.Futweb.Bucaramanga.dto.Productodto;
import com.Futweb.Bucaramanga.entity.Producto;

import java.util.List;

public interface ProductoService {

    Producto guardar(Productodto producto);
    List<Producto> mostrartodo();
    Producto actualizar(Producto producto);
    List<Producto> findone(Long id );


    String deleteproduct(Long id);


}

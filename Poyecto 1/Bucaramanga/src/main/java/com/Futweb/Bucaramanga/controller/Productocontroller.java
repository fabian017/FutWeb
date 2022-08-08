package com.Futweb.Bucaramanga.controller;

import com.Futweb.Bucaramanga.dto.Productodto;
import com.Futweb.Bucaramanga.entity.Producto;
import com.Futweb.Bucaramanga.entity.Usuario;
import com.Futweb.Bucaramanga.service.ProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class Productocontroller {

    public Productocontroller(ProductoService productoService) {
        this.productoService = productoService;
    }

    private ProductoService productoService;
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/getproductos")
    public List<Producto> getProducts(){

        return productoService.mostrartodo();
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/getoneproductos/{id}")
    public Producto getProducts(@PathVariable("id") Long id ){
        List<Producto> producto = productoService.findone(id);
        if (producto.size() !=0){
            return producto.get(0);
        }
        else {
            return null;
        }

    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/saveProducto")
    public ResponseEntity<Usuario>SaveProducto(@RequestBody Productodto producto){

        productoService.guardar(producto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/updateproducto/{id}")
    public ResponseEntity<Producto> updateproducto(@PathVariable("id") Long id,@RequestBody Productodto productodto){
        List<Producto> producto = productoService.findone(id);

        if (producto.size() != 0) {
            producto.get(0).setNombre(productodto.getNombre());
            producto.get(0).setDescripcion(productodto.getDescripcion());
            producto.get(0).setCategoria(productodto.getCategoria());
            producto.get(0).setPrecio(productodto.getPrecio());
            producto.get(0).setCategoria(productodto.getCategoria());
            producto.get(0).setStock(productodto.getStock());
            productoService.actualizar(producto.get(0));
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/deleteproducto/{id}")
    public ResponseEntity<Producto>deleteproducto(@PathVariable("id") Long id){
        productoService.deleteproduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

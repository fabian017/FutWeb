package com.Futweb.Bucaramanga.repository;

import com.Futweb.Bucaramanga.dto.Productodto;
import com.Futweb.Bucaramanga.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}

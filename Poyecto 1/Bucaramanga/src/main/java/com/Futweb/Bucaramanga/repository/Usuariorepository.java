package com.Futweb.Bucaramanga.repository;

import com.Futweb.Bucaramanga.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Usuariorepository extends JpaRepository<Usuario,Long> {
    Usuario findByUsername(String correo);

    boolean existsByCorreo(String correo);
    boolean existsByUsername(String username);

}

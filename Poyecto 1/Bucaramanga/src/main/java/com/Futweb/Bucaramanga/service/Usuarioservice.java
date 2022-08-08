package com.Futweb.Bucaramanga.service;

import com.Futweb.Bucaramanga.dto.Usuariodto;
import com.Futweb.Bucaramanga.entity.Usuario;
import org.springframework.stereotype.Service;


public interface Usuarioservice {
    Usuario guardar(Usuariodto user);
    Usuario findone(String username);

    Usuario updateUser(Usuario user);
}

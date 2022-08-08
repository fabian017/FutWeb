package com.Futweb.Bucaramanga.controller;

import com.Futweb.Bucaramanga.configure.TokenProvider;
import com.Futweb.Bucaramanga.dto.AuthToken;
import com.Futweb.Bucaramanga.dto.LoginUser;
import com.Futweb.Bucaramanga.dto.Usuariodto;
import com.Futweb.Bucaramanga.entity.Producto;
import com.Futweb.Bucaramanga.entity.Usuario;
import com.Futweb.Bucaramanga.service.Usuarioservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/usuario")
@RestController
public class Usuariocontroller {
    private Usuarioservice usuarioservice;
    private AuthenticationManager authenticationManager;

    private BCryptPasswordEncoder bcryptEncoder;

    private TokenProvider jwtTokenUtil;

    public Usuariocontroller(Usuarioservice usuarioservice, AuthenticationManager authenticationManager, BCryptPasswordEncoder bcryptEncoder, TokenProvider jwtTokenUtil) {
        this.usuarioservice = usuarioservice;
        this.authenticationManager = authenticationManager;
        this.bcryptEncoder = bcryptEncoder;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @PostMapping("/autenticar")
    public ResponseEntity<?> generateToken(@RequestBody LoginUser loginUser) {
        System.out.println(loginUser.getUsername());
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }
    @PostMapping("/register")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuariodto user){
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        usuarioservice.guardar(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @PutMapping("/updateUser/{username}")
    public ResponseEntity<Usuario> updateuser(@PathVariable("username") String username,@RequestBody Usuariodto user){
        Usuario usuario = usuarioservice.findone(username);

        if (usuario != null) {
            usuario.setNombre(user.getNombre());
            usuario.setPassword(bcryptEncoder.encode(user.getPassword()));
            usuario.setTelefono(user.getTelefono());
            usuarioservice.updateUser(usuario);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping("/getoneuser/{username}")
    public Usuario getProducts(@PathVariable("username") String username ){
        Usuario user = usuarioservice.findone(username);
        if (user !=null){
            return user;
        }
        else {
            return null;
        }}




    }

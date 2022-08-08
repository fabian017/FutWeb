package com.Futweb.Bucaramanga.service;

import com.Futweb.Bucaramanga.dto.Usuariodto;
import com.Futweb.Bucaramanga.entity.Role;
import com.Futweb.Bucaramanga.entity.Usuario;
import com.Futweb.Bucaramanga.exception.EmailAlreadyExistsException;
import com.Futweb.Bucaramanga.repository.Usuariorepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("usuarioService")
public class Usuarioserviceimp implements  Usuarioservice, UserDetailsService {

    @Autowired
    private Usuariorepository usariorepository;
    @Autowired
    private RoleService roleService;

    @Override
    public Usuario guardar(Usuariodto user) {
        Usuario nuser=user.getusuariofromdto();
        if (usariorepository.existsByCorreo(nuser.getCorreo())){
            throw new EmailAlreadyExistsException("Email ocupado");
        }
        if (usariorepository.existsByUsername(nuser.getUsername())){
            throw new UsernameNotFoundException("Username ocupado");
        }

        Role role = roleService.findByName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        if(nuser.getCorreo().split("@")[1].equals("admin.com")){
            role = roleService.findByName("ADMIN");
            roleSet.add(role);
        }
        nuser.setRoles(roleSet);
    return usariorepository.save(nuser);
    }
    public  Usuario updateUser(Usuario user){
        //Usuario newuser=user.getusuariofromdto();
        return usariorepository.save(user);

    }
    @Override
    public Usuario findone(String username) {
        return usariorepository.findByUsername(username);
    }



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usariorepository.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("Invalid email or password ");
        }
        return new org.springframework.security.core.userdetails.User( user.getUsername(),user.getPassword(),getAuthority(user));/*,getAuthority(user)*/
        }
    private Set<SimpleGrantedAuthority>getAuthority(Usuario user){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        System.out.println(authorities);
        return authorities;
    }
}

package com.sistema.blog.repositorio;

import com.sistema.blog.entidades.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RolRepositorio extends JpaRepository<Rol,Long> {
    
    public Optional<Rol>findByNombre(String nombre);
    
}

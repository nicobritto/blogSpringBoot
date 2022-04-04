package com.sistema.blog.repositorio;

import com.sistema.blog.entidades.Comentario;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepositorio extends JpaRepository<Comentario, Long> {

        public List<Comentario>findByPublicacionId(long publicacionId);
}

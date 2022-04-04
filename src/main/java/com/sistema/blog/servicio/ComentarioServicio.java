package com.sistema.blog.servicio;

import com.sistema.blog.dto.ComentarioDTO;
import java.util.List;

public interface ComentarioServicio {

    public ComentarioDTO crearComentario(long publicacionId, ComentarioDTO comentarioDTO);

    public List<ComentarioDTO>obtenerComentariosPorPublicacionId(long publicacionId);
    
}

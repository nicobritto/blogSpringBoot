package com.sistema.blog.servicio;

import com.sistema.blog.dto.PublicacionDTO;
import java.util.List;

public interface PublicacionServicio {

    public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO);

    public List<PublicacionDTO> obtenerTodasLasPublicaciones(int numeroDePagina,int medidaDePagina);

    public PublicacionDTO ObtenerPublicacionPorId(long id);

    public PublicacionDTO actualizarPublicacion(PublicacionDTO publicacionDTO, long id);

    public void eliminarPublicacion(long id);

}

package com.sistema.blog.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.blog.dto.ComentarioDTO;
import com.sistema.blog.entidades.Comentario;
import com.sistema.blog.entidades.Publicacion;
import com.sistema.blog.excepciones.BlogAppException;
import com.sistema.blog.excepciones.ResourceNotFoundException;
import com.sistema.blog.repositorio.ComentarioRepositorio;
import com.sistema.blog.repositorio.PublicacionRepositorio;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;

@Service
public class ComentarioServicioImpl implements ComentarioServicio {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ComentarioRepositorio comentarioRepositorio;

    @Autowired
    private PublicacionRepositorio publicacionRepositorio;
//----------------------------------------------------------------------

    @Override
    public ComentarioDTO crearComentario(long publicacionId, ComentarioDTO comentarioDTO) {
        Comentario comentario = mapearEntidad(comentarioDTO);

        Publicacion publicacion = publicacionRepositorio.findById(publicacionId)//buscamos publicacion por id si no la encontramos
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", publicacionId));//si no la encontramos retornamos una excepcion

        comentario.setPublicacion(publicacion);
        Comentario nuevoComentario = comentarioRepositorio.save(comentario);

        return mapearDTO(nuevoComentario);
    }

    //------------------------------------------------------------------
    private ComentarioDTO mapearDTO(Comentario comentario) {
        ComentarioDTO comentarioDTO = modelMapper.map(comentario, ComentarioDTO.class);

        return comentarioDTO;
    }

//----------------------------------------------------------------------
    @Override
    public ComentarioDTO obtenerComentarioPorId(Long publicacionId, Long comentarioId) {

        Publicacion publicacion = publicacionRepositorio.findById(publicacionId)//buscamos publicacion por id si no la encontramos
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", publicacionId));//si no la encontramos retornamos una excepcion
        Comentario comentario = comentarioRepositorio.findById(comentarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", comentarioId));

        if (!comentario.getPublicacion().getId().equals(publicacion.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "el comentario no pertenece ala publicacion");
        }
        return mapearDTO(comentario);
    }
//----------------------------------------------------------------------

    @Override
    public ComentarioDTO actualizarComentario(Long publicacionId, Long comentarioId, ComentarioDTO solicitudDeComentario) {

        Publicacion publicacion = publicacionRepositorio.findById(publicacionId)//buscamos publicacion por id si no la encontramos
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", publicacionId));//si no la encontramos retornamos una excepcion
        Comentario comentario = comentarioRepositorio.findById(comentarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", comentarioId));

        if (!comentario.getPublicacion().getId().equals(publicacion.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "el comentario no pertenece ala publicacion");
        }
        comentario.setNombre(solicitudDeComentario.getNombre());
        comentario.setEmail(solicitudDeComentario.getEmail());
        comentario.setCuerpo(solicitudDeComentario.getCuerpo());

        Comentario comentarioActualizado = comentarioRepositorio.save(comentario);

        return mapearDTO(comentarioActualizado);

    }
//----------------------------------------------------------------------

    @Override
    public void eliminarComentario(Long publicacionId, Long comentarioId) {

        Publicacion publicacion = publicacionRepositorio.findById(publicacionId)//buscamos publicacion por id si no la encontramos
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", publicacionId));//si no la encontramos retornamos una excepcion
        Comentario comentario = comentarioRepositorio.findById(comentarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Comentario", "id", comentarioId));

        if (!comentario.getPublicacion().getId().equals(publicacion.getId())) {
            throw new BlogAppException(HttpStatus.BAD_REQUEST, "el comentario no pertenece ala publicacion");
        }

        comentarioRepositorio.delete(comentario);

    }

    //----------------------------------------------------------------------
    private Comentario mapearEntidad(ComentarioDTO comentarioDTO) {
        Comentario comentario = modelMapper.map(comentarioDTO, Comentario.class);

        return comentario;

    }
//----------------------------------------------------------------------

    @Override
    public List<ComentarioDTO> obtenerComentariosPorPublicacionId(long publicacionId) {
        List<Comentario> comentarios = comentarioRepositorio.findByPublicacionId(publicacionId);

        return comentarios.stream().map(comentario -> mapearDTO(comentario)).collect(Collectors.toList());
    }

}

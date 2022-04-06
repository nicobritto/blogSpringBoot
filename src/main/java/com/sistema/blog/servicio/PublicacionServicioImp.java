package com.sistema.blog.servicio;

import com.sistema.blog.dto.PublicacionDTO;
import com.sistema.blog.dto.PublicacionRespuesta;
import com.sistema.blog.entidades.Publicacion;
import com.sistema.blog.excepciones.ResourceNotFoundException;
import com.sistema.blog.repositorio.PublicacionRepositorio;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PublicacionServicioImp implements PublicacionServicio {

    @Autowired
    private PublicacionRepositorio publicacionRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PublicacionDTO crearPublicacion(PublicacionDTO publicacionDTO) {//DTO objeto tranferencia de datos
        Publicacion publicacion = mapearEntidad(publicacionDTO);

        Publicacion nuevaPublicacion = publicacionRepositorio.save(publicacion);

        PublicacionDTO publicacionRespuesta = mapearDTO(nuevaPublicacion);

        return publicacionRespuesta;
    }
//-------------------------------------------------------------------

    @Override
    public PublicacionRespuesta obtenerTodasLasPublicaciones(int numeroDePagina, int medidaDePagina, String ordenarPor, String sortDir) {
        // Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(ordenarPor).ascending():Sort.by(ordenarPor).descending();
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(ordenarPor).ascending() : Sort.by(ordenarPor).descending();
        Pageable pageable = PageRequest.of(numeroDePagina, medidaDePagina, sort);

        Page<Publicacion> publicaciones = publicacionRepositorio.findAll(pageable);

        List<Publicacion> listaDePublicaciones = publicaciones.getContent();
        List<PublicacionDTO> contenido = listaDePublicaciones.stream().map(publicacion -> mapearDTO(publicacion)).collect(Collectors.toList());
        PublicacionRespuesta publicacionRespuesta = new PublicacionRespuesta();
        publicacionRespuesta.setContenido(contenido);
        publicacionRespuesta.setNumeroDePagina(publicaciones.getNumber());
        publicacionRespuesta.setMedidaDePagina(publicaciones.getSize());
        publicacionRespuesta.setTotalDeElementos(publicaciones.getTotalElements());
        publicacionRespuesta.setTotalDePaginas(publicaciones.getTotalPages());
        publicacionRespuesta.setUltima(publicaciones.isLast());//isLast sirtve para ver si es la ultima

        return publicacionRespuesta;

    }

    //------------------------------------------------------------------------
    @Override
    public PublicacionDTO ObtenerPublicacionPorId(long id) {

        Publicacion publicacion = publicacionRepositorio.findById(id)//buscamos publicacion por id si no la encontramos
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", id));//si no la encontramos retornamos una excepcion

        return mapearDTO(publicacion);
    }
//--------------------------------------------------------------------------------

    @Override
    public PublicacionDTO actualizarPublicacion(PublicacionDTO publicacionDTO, long id) {

        Publicacion publicacion = publicacionRepositorio.findById(id)//buscamos publicacion por id si no la encontramos
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", id));//si no la encontramos retornamos una excepcion

        publicacion.setTitulo(publicacionDTO.getTitulo());
        publicacion.setDescripcion(publicacionDTO.getDescripcion());
        publicacion.setContenido(publicacionDTO.getContenido());

        Publicacion publicacionActualizada = publicacionRepositorio.save(publicacion);

        return mapearDTO(publicacionActualizada);
    }
//----------------------------------------------------------------------------------

    @Override
    public void eliminarPublicacion(long id) {
        Publicacion publicacion = publicacionRepositorio.findById(id)//buscamos publicacion por id si no la encontramos
                .orElseThrow(() -> new ResourceNotFoundException("Publicacion", "id", id));//si no la encontramos retornamos una excepcion

        publicacionRepositorio.delete(publicacion);

    }

    //----------------------------------------------------------------------------
    //este metodo convierte entidad  a DTO
    private PublicacionDTO mapearDTO(Publicacion publicacion) {
        PublicacionDTO publicacionDTO = modelMapper.map(publicacion, PublicacionDTO.class);
        return publicacionDTO;
    }
//--------------------------------------------------------------------------------
    //convierte de DTO a Entidad

    private Publicacion mapearEntidad(PublicacionDTO publicacionDTO) {
        Publicacion publicacion = modelMapper.map(publicacionDTO, Publicacion.class);

        return publicacion;
    }

}

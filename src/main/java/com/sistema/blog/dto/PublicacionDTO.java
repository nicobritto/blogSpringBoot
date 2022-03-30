package com.sistema.blog.dto;

public class PublicacionDTO {
//DTO no tiene más comportamiento que.data tranfers objet
//almacenar y entregar sus propios datos 

    private Long id;
    private String titulo;
    private String descripcion;
    private String contenido;

    public PublicacionDTO() {
    }

    public PublicacionDTO(Long id, String titulo, String descripcion, String contenido) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.contenido = contenido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    @Override
    public String toString() {
        return "PublicacionDTO{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", contenido=" + contenido + '}';
    }

    }

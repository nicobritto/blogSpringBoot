package com.sistema.blog.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Data;

@Entity
@Table(name = "publicaciones",uniqueConstraints ={@UniqueConstraint(columnNames ="titulo" )} )
public class Publicacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "titulo",nullable = false )
    private String titulo;
    
    @Column(name = "descripcion",nullable = false )
    private String descripcion;
    
    @Column(name = "contenido",nullable = false )
    private String contenido;

    
    
    public Publicacion() {
    }
    

    public Publicacion(Long id) {
        this.id = id;
    }

    public Publicacion(Long id, String titulo, String descripcion, String contenido) {
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
        return "Publicacion{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", contenido=" + contenido + '}';
    }
    
    
    
    
    
    
}

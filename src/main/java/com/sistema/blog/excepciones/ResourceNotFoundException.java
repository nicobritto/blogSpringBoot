package com.sistema.blog.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)//el valor que va rsponder esta clase cuando se la llame va ser un no encontrado
public class ResourceNotFoundException extends RuntimeException {

    private String nombreDelRecurso;
    private String nombreDelCampo;
    private Long valorDelCampo;

    public ResourceNotFoundException(String nombreDelRecurso, String nombreDelCampo, Long valorDelCampo) {
        super(String.format("%s no encontrado con : %s : '%s'", nombreDelRecurso, nombreDelCampo, valorDelCampo));
        this.nombreDelRecurso = nombreDelRecurso;
        this.nombreDelCampo = nombreDelCampo;
        this.valorDelCampo = valorDelCampo;
    }

    public String getNombreDelRecurso() {
        return nombreDelRecurso;
    }

    public void setNombreDelRecurso(String nombreDelRecurso) {
        this.nombreDelRecurso = nombreDelRecurso;
    }

    public String getNombreDelCampo() {
        return nombreDelCampo;
    }

    public void setNombreDelCampo(String nombreDelCampo) {
        this.nombreDelCampo = nombreDelCampo;
    }

    public Long getValorDelCampo() {
        return valorDelCampo;
    }

    public void setValorDelCampo(Long valorDelCampo) {
        this.valorDelCampo = valorDelCampo;
    }

}

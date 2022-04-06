package com.sistema.blog.dto;

import java.util.Date;

public class ErrorDetalles {

    private Date marcaDeTiempo;
    private String mensaje;
    private String datalles;

    public ErrorDetalles() {
    }

    public ErrorDetalles(Date marcaDeTiempo, String mensaje, String datalles) {
        super();
        this.marcaDeTiempo = marcaDeTiempo;
        this.mensaje = mensaje;
        this.datalles = datalles;
    }

    public Date getMarcaDeTiempo() {
        return marcaDeTiempo;
    }

    public void setMarcaDeTiempo(Date marcaDeTiempo) {
        this.marcaDeTiempo = marcaDeTiempo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getDatalles() {
        return datalles;
    }

    public void setDatalles(String datalles) {
        this.datalles = datalles;
    }

}

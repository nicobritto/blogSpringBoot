package com.sistema.blog.dto;

import java.util.List;

public class PublicacionRespuesta {

    private List<PublicacionDTO> contenido;
    private int numeroDePagina;
    private int medidaDePagina;
    private long totalDeElementos;
    private int totalDePaginas;
    private boolean ultima;

    public PublicacionRespuesta() {
    }

    public PublicacionRespuesta(List<PublicacionDTO> contenido, int numeroDePagina, int medidaDePagina, long totalDeElementos, int totalDePaginas, boolean ultima) {
        this.contenido = contenido;
        this.numeroDePagina = numeroDePagina;
        this.medidaDePagina = medidaDePagina;
        this.totalDeElementos = totalDeElementos;
        this.totalDePaginas = totalDePaginas;
        this.ultima = ultima;
    }

    public List<PublicacionDTO> getContenido() {
        return contenido;
    }

    public void setContenido(List<PublicacionDTO> contenido) {
        this.contenido = contenido;
    }

    public int getNumeroDePagina() {
        return numeroDePagina;
    }

    public void setNumeroDePagina(int numeroDePagina) {
        this.numeroDePagina = numeroDePagina;
    }

    public int getMedidaDePagina() {
        return medidaDePagina;
    }

    public void setMedidaDePagina(int medidaDePagina) {
        this.medidaDePagina = medidaDePagina;
    }

    public long getTotalDeElementos() {
        return totalDeElementos;
    }

    public void setTotalDeElementos(long totalDeElementos) {
        this.totalDeElementos = totalDeElementos;
    }

    public int getTotalDePaginas() {
        return totalDePaginas;
    }

    public void setTotalDePaginas(int totalDePaginas) {
        this.totalDePaginas = totalDePaginas;
    }

    public boolean isUltima() {
        return ultima;
    }

    public void setUltima(boolean ultima) {
        this.ultima = ultima;
    }

    @Override
    public String toString() {
        return "PublicacionRespuesta{" + "contenido=" + contenido + ", numeroDePagina=" + numeroDePagina + ", medidaDePagina=" + medidaDePagina + ", totalDeElementos=" + totalDeElementos + ", totalDePaginas=" + totalDePaginas + ", ultima=" + ultima + '}';
    }

}

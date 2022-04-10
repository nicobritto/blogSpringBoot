package com.sistema.blog.seguridad;

public class JWTAuthResponseDTO {

    private String tokenDeAccedo;
    private String tipoDeToken = "Bearer";

    public JWTAuthResponseDTO(String tokenDeAccedo) {
        super();
        this.tokenDeAccedo = tokenDeAccedo;
    }

    public JWTAuthResponseDTO(String tokenDeAccedo, String tipoDeToken) {
        super();
        this.tokenDeAccedo = tokenDeAccedo;
        this.tipoDeToken = tipoDeToken;
    }

    public String getTokenDeAccedo() {
        return tokenDeAccedo;
    }

    public void setTokenDeAccedo(String tokenDeAccedo) {
        this.tokenDeAccedo = tokenDeAccedo;
    }

    public String getTipoDeToken() {
        return tipoDeToken;
    }

    public void setTipoDeToken(String tipoDeToken) {
        this.tipoDeToken = tipoDeToken;
    }

}

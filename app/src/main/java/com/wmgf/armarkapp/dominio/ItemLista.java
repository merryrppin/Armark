package com.wmgf.armarkapp.dominio;

/**
 * Created by WMGF on 23/09/2015.
 */
public class ItemLista {
    private String textoSuperior;
    private String textoMedio;
    private String textoInferior;
    private String imgUrl;

    public ItemLista(String textoSuperior, String textoMedio, String textoInferior, String imgUrl) {
        this.textoSuperior = textoSuperior;
        this.textoMedio = textoMedio;
        this.textoInferior = textoInferior;
        this.imgUrl = imgUrl;
    }

    public String getTextoSuperior() {
        return textoSuperior;
    }

    public String getTextoMedio() {
        return textoMedio;
    }

    public String getTextoInferior() {
        return textoInferior;
    }
}

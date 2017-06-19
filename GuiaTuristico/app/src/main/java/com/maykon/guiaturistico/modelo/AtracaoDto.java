package com.maykon.guiaturistico.modelo;

import java.util.List;

public class AtracaoDto {
    private String nomeLocal;
    private List<String> linksDasFotos;
    private String descricao;
    private String[] coordenada;
    private String[] idFotos;

    public String[] getIdFotos() {return idFotos; }

    public void setIdFotos(String[] idFotos) { this.idFotos = idFotos;}

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public List<String> getLinksDasFotos() {
        return linksDasFotos;
    }

    public void setLinksDasFotos(List<String> linksDasFotos) {
        this.linksDasFotos = linksDasFotos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String[] getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(String[] coordenada) {
        this.coordenada = coordenada;
    }
}

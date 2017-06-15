package com.maykon.guiaturistico.modelo;

import java.util.List;

public class AtracaoDto {
    private String nomeLocal;
    private List<String> linksDasFotos;
    private String descricao;
    private String coordenada;

    public AtracaoDto(String nomeLocal, List<String> links, String descricao, String coordenada){
        this.nomeLocal = nomeLocal;
        this.linksDasFotos = links;
        this.descricao = descricao;
        this.coordenada = coordenada;
    }
}

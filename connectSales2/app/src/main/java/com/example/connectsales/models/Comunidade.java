package com.example.connectsales.models;

import org.dizitart.no2.IndexType;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.Index;
import org.dizitart.no2.objects.Indices;

@Indices({
        @Index(value = "nome", type = IndexType.Unique)
})

public class Comunidade {

    @Id
    public NitriteId id;
    public String nome;
    public String categoria;
    public Integer qtd_participantes;
    public Boolean ativo;

    public NitriteId getId() {
        return id;
    }

    public void setId(NitriteId id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getQtd_participantes() {
        return qtd_participantes;
    }

    public void setQtd_participantes(Integer qtd_participantes) {
        this.qtd_participantes = qtd_participantes;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}

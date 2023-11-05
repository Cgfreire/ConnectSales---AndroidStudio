package com.example.connectsales.models;
import org.dizitart.no2.IndexType;
import org.dizitart.no2.NitriteId;
import org.dizitart.no2.objects.Id;
import org.dizitart.no2.objects.Index;
import org.dizitart.no2.objects.Indices;

@Indices({
        @Index(value = "nome", type = IndexType.Unique)
})

public class Posts {

    @Id
    public NitriteId id;

    public String titulo;
    public String assunto;
    public String conteudo;
    public String autor;
    public Integer qtd_reacoes;

    public NitriteId getId() {
        return id;
    }

    public void setId(NitriteId id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getQtd_reacoes() {
        return qtd_reacoes;
    }

    public void setQtd_reacoes(Integer qtd_reacoes) {
        this.qtd_reacoes = qtd_reacoes;
    }
}

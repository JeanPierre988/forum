package br.com.jean.forum.modelo;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensagem;
    @ManyToOne
    private Topico topico;
    private LocalDateTime dataCriacao = LocalDateTime.now();
    @ManyToOne
    private Usuario autor;
    private Boolean solucao = false;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resposta resposta = (Resposta) o;

        if (id != null ? !id.equals(resposta.id) : resposta.id != null) return false;
        if (mensagem != null ? !mensagem.equals(resposta.mensagem) : resposta.mensagem != null) return false;
        if (topico != null ? !topico.equals(resposta.topico) : resposta.topico != null) return false;
        if (dataCriacao != null ? !dataCriacao.equals(resposta.dataCriacao) : resposta.dataCriacao != null)
            return false;
        if (autor != null ? !autor.equals(resposta.autor) : resposta.autor != null) return false;
        return solucao != null ? solucao.equals(resposta.solucao) : resposta.solucao == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (mensagem != null ? mensagem.hashCode() : 0);
        result = 31 * result + (topico != null ? topico.hashCode() : 0);
        result = 31 * result + (dataCriacao != null ? dataCriacao.hashCode() : 0);
        result = 31 * result + (autor != null ? autor.hashCode() : 0);
        result = 31 * result + (solucao != null ? solucao.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Topico getTopico() {
        return topico;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public Boolean getSolucao() {
        return solucao;
    }

    public void setSolucao(Boolean solucao) {
        this.solucao = solucao;
    }
}

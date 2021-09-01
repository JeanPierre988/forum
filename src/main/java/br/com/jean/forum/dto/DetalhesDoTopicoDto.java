package br.com.jean.forum.dto;

import br.com.jean.forum.modelo.Resposta;
import br.com.jean.forum.modelo.StatusTopico;
import br.com.jean.forum.modelo.Topico;
import org.springframework.format.datetime.DateFormatter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class DetalhesDoTopicoDto {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private String nomeAutor;
    private StatusTopico statusTopico;
    private List<RespostaDto> respostas;

    public DetalhesDoTopicoDto(Topico t) {
        this.id = t.getId();
        this.titulo = t.getTitulo();
        this.mensagem = t.getMensagem();
        this.dataCriacao = t.getDataCriacao();
        this.nomeAutor = t.getAutor().getNome();
        this.statusTopico = t.getStatus();
        this.respostas = new ArrayList<>();
        this.respostas.addAll(t.getRespostas().stream().map(RespostaDto::new).collect(Collectors.toList()));
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public StatusTopico getStatusTopico() {
        return statusTopico;
    }

    public List<RespostaDto> getRespostas() {
        return respostas;
    }
}

package br.com.jean.forum.dto;

import br.com.jean.forum.modelo.Topico;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class TopicoDto {

    private Long id;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;

    public TopicoDto(Topico t) {
        this.id = t.getId();
        this.titulo = t.getTitulo();
        this.mensagem = t.getMensagem();
        this.dataCriacao = t.getDataCriacao();
    }

    public static List<TopicoDto> convert(List<Topico> topicos) {
        return topicos.stream().map(TopicoDto::new).collect(Collectors.toList());
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
}

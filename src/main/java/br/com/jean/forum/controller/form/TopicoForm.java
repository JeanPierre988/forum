package br.com.jean.forum.controller.form;

import br.com.jean.forum.modelo.Curso;
import br.com.jean.forum.modelo.Topico;
import br.com.jean.forum.repository.CursoRepository;
import br.com.jean.forum.repository.TopicoRepository;
import com.sun.istack.NotNull;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class TopicoForm {
    @NotNull @NotEmpty @Length(min = 5)
    private String titulo;
    @NotNull @NotEmpty @Length(min = 10)
    private String mensagem;
    @NotNull @NotEmpty
    private String curso;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Topico convert(CursoRepository repository) {
        Curso nomeCurso = repository.findByNome(curso);
        return new Topico(titulo, mensagem, nomeCurso);
    }
}

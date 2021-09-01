package br.com.jean.forum.controller;

import br.com.jean.forum.controller.form.TopicoForm;
import br.com.jean.forum.dto.TopicoDto;
import br.com.jean.forum.modelo.Topico;
import br.com.jean.forum.repository.CursoRepository;
import br.com.jean.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDto> lista(String nomeCurso){
        if (nomeCurso != null) {
            List<Topico> topicoList = topicoRepository.findByCurso_nome(nomeCurso);
            return TopicoDto.convert(topicoList);
        } else {
            List<Topico> topicoList = topicoRepository.findAll();
            return TopicoDto.convert(topicoList);
        }
    }

    @PostMapping
    public ResponseEntity<TopicoDto> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder){
        Topico topico = form.convert(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }
}

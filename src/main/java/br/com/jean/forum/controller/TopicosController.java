package br.com.jean.forum.controller;

import br.com.jean.forum.dto.TopicoDto;
import br.com.jean.forum.modelo.Curso;
import br.com.jean.forum.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDto> lista(){
        Topico topico1 = new Topico("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação"));

        return TopicoDto.convert(Arrays.asList(topico1, topico1, topico1));
    }
}

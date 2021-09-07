package br.com.jean.forum.repository;

import br.com.jean.forum.modelo.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Page<Topico> findByCurso_nome(String nomeCurso, Pageable paginacao);
}

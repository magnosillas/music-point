package br.edu.ufape.musicpoint.repositorio;

import br.edu.ufape.musicpoint.basica.NotalGeral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioNotaGeral extends JpaRepository<NotalGeral, Long > {
}

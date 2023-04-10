package br.edu.ufape.musicpoint.cadastro;

import br.edu.ufape.musicpoint.basica.NotalGeral;
import br.edu.ufape.musicpoint.repositorio.RepositorioNotaGeral;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CadastroNotaGeral {
    @Autowired
    private RepositorioNotaGeral repositorioNotaGeralTotal;

    public NotalGeral cadastrarMediaNotas(NotalGeral notalGeralTotal) {
        return repositorioNotaGeralTotal.save(notalGeralTotal);
    }
}

package br.edu.ufape.musicpoint.cadastro;


import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.repositorio.RepositorioArtista;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CadastroArtista {

    @Autowired
    private RepositorioArtista repositorioArtista;

    public Artista cadastrarArtista(Artista artista){
        return repositorioArtista.save(artista);
    }
}

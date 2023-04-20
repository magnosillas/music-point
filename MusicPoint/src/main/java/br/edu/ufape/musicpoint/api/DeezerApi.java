package br.edu.ufape.musicpoint.api;


import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.basica.Musica;

import br.edu.ufape.musicpoint.exceptions.ArtistaNaoEncontradoException;
import br.edu.ufape.musicpoint.fachada.MusicPoint;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

public class DeezerApi {

    private final MusicPoint musicPoint;

    public DeezerApi(MusicPoint musicPoint) {
        this.musicPoint = musicPoint;
    }

    public List<Album> getTopAlbums() throws Exception {
        String url = "https://api.deezer.com/chart/0/albums?limit=150";
        HttpResponse<String> response = Unirest.get(url).asString();

        JSONObject jsonObject = new JSONObject(response.getBody());
        JSONArray albumsArray = jsonObject.getJSONArray("data");
        List<Album> albums = new ArrayList<>();

        for (int i = 0; i < albumsArray.length(); i++) {
            JSONObject albumObject = albumsArray.getJSONObject(i);
            String albumTitle = albumObject.getString("title");
            int albumRank = albumObject.getInt("position");
            String coverUrl = albumObject.getString("cover_medium");
            String trackList = albumObject.getString("tracklist");



            JSONObject artistObject = albumObject.getJSONObject("artist");
            Artista artista = new Artista(artistObject.getString("name"),artistObject.getString("picture_medium"));


            try {
                artista = musicPoint.buscarArtistaPorNome(artista.getNome());
            } catch (ArtistaNaoEncontradoException e){
                musicPoint.save(artista);
            }

            List<Musica> musicas = getTracks(trackList);
            Album album = new Album(albumTitle,coverUrl,albumRank, musicas,artista);
            albums.add(album);

        }

        return albums;
    }

    public List<Musica> getTracks(String trackListURL) throws Exception{
        List<Musica> musicas = new ArrayList<>();

        HttpResponse<String> response = Unirest.get(trackListURL).asString();

        JSONObject jsonObject = new JSONObject(response.getBody());
        JSONArray tracksArray = jsonObject.getJSONArray("data");

        for (int i = 0; i < tracksArray.length(); i++){
            JSONObject musicObject = tracksArray.getJSONObject(i);

            String title = musicObject.getString("title");

            Musica musica = new Musica(title);
            musicPoint.save(musica);
            musicas.add(musica);

        }

        return musicas;
    }

}
package br.edu.ufape.musicpoint.api;


import br.edu.ufape.musicpoint.basica.Album;
import br.edu.ufape.musicpoint.basica.Artista;
import br.edu.ufape.musicpoint.basica.Musica;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;


import java.util.ArrayList;
import java.util.List;

public class DeezerApi {
    public DeezerApi() {
    }


    public List<Album> getTopAlbums() throws Exception {
        String url = "https://api.deezer.com/chart/0/albums?limit=100";
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

            JSONObject artistObject = albumObject.getJSONObject("artista");
            Artista artista = new Artista(artistObject.getString("name"),artistObject.getString("picture_medium"));

            Album album = new Album();
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
            musicas.add(musica);


        }


        return musicas;
    }



}






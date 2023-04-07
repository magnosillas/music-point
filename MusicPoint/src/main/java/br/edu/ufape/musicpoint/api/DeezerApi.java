package br.edu.ufape.musicpoint.api;


import br.edu.ufape.musicpoint.basic.Album;
import br.edu.ufape.musicpoint.basic.Artist;
import br.edu.ufape.musicpoint.basic.Music;
import br.edu.ufape.musicpoint.controller.AlbumController;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Autowired;

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

            JSONObject artistObject = albumObject.getJSONObject("artist");
            Artist artist = new Artist(artistObject.getString("name"),artistObject.getString("picture_medium"));

            Album album = new Album(albumTitle,albumRank,coverUrl);
            albums.add(album);

        }

        return albums;
    }

    public List<Music> getTracks(String trackListURL) throws Exception{
        List<Music> musics= new ArrayList<>();

        HttpResponse<String> response = Unirest.get(trackListURL).asString();

        JSONObject jsonObject = new JSONObject(response.getBody());
        JSONArray tracksArray = jsonObject.getJSONArray("data");

        for (int i = 0; i < tracksArray.length(); i++){
            JSONObject musicObject = tracksArray.getJSONObject(i);

            String title = musicObject.getString("title");

            Music music = new Music(title);
            musics.add(music);


        }


        return musics;
    }



}






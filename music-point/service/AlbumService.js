import http from "@/common/http";

class AlbumService {
    
    listar() {
        return http.get("/album/lista");
    }
    
    buscarPorId(id) {
        return http.get("/album/" + id);
    }

    buscarPorNome(nome) {
        return http.get("/album/nome/" + nome);
    }


    buscarPorArtistaId(id) {
        return http.get("/album/artista/" + id);
    }

}
export default new AlbumService();
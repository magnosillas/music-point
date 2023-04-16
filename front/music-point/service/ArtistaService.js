import http from "@/common/http";

class ArtistaService {
    listar() {
        return http.get("/artista/lista");
    }
    buscarPorId(id) {
        return http.get("/artista/" + id);
    }
    buscarPorNome(nome) {
        return http.get("/artista/nome/" + nome);
    }
    
}
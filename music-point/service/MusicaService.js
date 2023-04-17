import http from "@/common/http";

class MusicaService {
    listar() {
        return http.get("/musica/lista");
    }
    buscarPorId(id) {
        return http.get("/musica/" + id);
    }
    buscarPorNome(nome) {
        return http.get("/musica/nome/" + nome);
    }
    
}
export default new MusicaService();
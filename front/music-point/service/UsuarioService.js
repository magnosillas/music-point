import http from "@/common/http";


class UsuarioService {
    criar(data) {
        console.log(data);
        return http.post("/usuario", data);
    }
    atualizar( data) {
        return http.patch("/usuario", data);
    }
    listar() {
        return http.get("/usuario/lista");
    }
    deletarPorId(id) {
        return http.delete("/usuario/id/" + id);
    }
    deletarPorUsername(username) {
        return http.delete("/usuario/username/" + username);
    }
    buscarPorId(id) {
        return http.get("/usuario/" + id);
    }
    buscarPorUsername(username) {
        return http.get("/usuario/username/" + username);
    }
    seguirPorId(usuarioId, seguidorId) {
        return http.patch(`/usuario/seguir/id/${usuarioId}/${seguidorId}`);
    }
    seguirPorUsername(usuarioUsername, usuarioDestinoUsername) {
        return http.patch(`usuario/seguir/username/${usuarioUsername}/${usuarioDestinoUsername}`);
    }
    deixarDeSeguirPorId(usuarioId, seguidorId) {
        return http.patch(`/usuario/deixar-seguir/id/${usuarioId}/${seguidorId}`);
    }
    deixarDeSeguirPorUsername(usuarioUsername, usuarioDestinoUsername) {
        return http.patch(`usuario/deixar-seguir/username/${usuarioUsername}/${usuarioDestinoUsername}`);
    }
    login(email,senha) {
        return http.post(`/usuario/login/${email}/${senha}`);
    }
        
}
export default new UsuarioService();
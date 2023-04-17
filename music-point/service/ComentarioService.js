import http from "@/common/http";

class ComentrarioService {
  criar(data) {
    console.log(data);
    return http.post("/comentario", data);
  }

  atualizar(data) {
    return http.patch("/comentario", data);
  }

  deletar(id){
    return http.delete("/comentario/" + id);
  }

  buscarTodos() {
    return http.get("/comentario/lista");
  }

  buscarPorId(id) {
    return http.get("/comentario/" + id);
    }

  buscarPorUsuario(id){
    return http.get("/comentario/usuario/" + id);
  }

  buscarPorReview(id){
    return http.get("/comentario/review/" + id);
  }

  
}
export default new ComentrarioService();
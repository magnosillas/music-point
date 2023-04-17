import http from "@/common/http";

class ReviewService {
  criar(data) {
    console.log(data);
    return http.post("/review", data);
  }

  atualizar(data) {
    return http.patch("/review", data);
  }

  buscarTodos() {
    return http.get("/review/lista");
  }

  buscarPorId(id) {
    return http.get("/review/" + id);
    }

  buscarPorUsuario(data){
    return http.get("/review/usuario/", data);
  }

  buscarPorAutores(data){
    return http.get("/review/autores/", data);
  }

  like(id) {
    return http.patch("/review/like/id" + id);
  }

  unlike(id) {
    return http.patch("/review/unlike/id" + id);
  }
}
export default new ReviewService();
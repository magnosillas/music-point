import http from "@/common/http";

class AlbumService {
    
    list() {
        return http.get("/album");
    }
    
    findById(id) {
        return http.get("/album/" + id);
    }
}
export default new AlbumService();
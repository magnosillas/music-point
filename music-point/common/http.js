import axios from "axios";

export default axios.create({
  baseURL: "http://localhost:8081/musicpoint/api/v1/",
  headers: {
    "Content-type": "application/json"
  }
});
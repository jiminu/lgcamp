import axios from "axios";

const url = process.env.REACT_APP_JSON_SERVER_URL;
const api = axios.create({
  baseURL: "http://localhost:3001/",
  withCredentials: url,
  
});

export default api;
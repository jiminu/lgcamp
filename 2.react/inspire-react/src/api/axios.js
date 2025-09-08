import axios from "axios";

const url = process.env.REACT_APP_JSON_SERVER_URL;

const api = axios.create({
  baseURL: url,
  withCredentials: true,
  
});

export default api;
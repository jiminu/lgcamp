import axios from "axios";

const url = process.env.REACT_APP_JSON_SERVER_URL;
const token = process.env.REACT_APP_OPENAPI_KEY;
const api = axios.create({
  baseURL: url,
  withCredentials: token,
  
});

export default api;
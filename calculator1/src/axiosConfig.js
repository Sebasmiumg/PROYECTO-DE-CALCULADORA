import axios from 'axios';

const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080', // URL del backend
});

export default axiosInstance;

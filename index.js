console.log("Running server...")
const express = require("express");
const cors = require("cors");

const app = express(); // Asegúrate de definir app antes de usarlo

// Habilitar CORS
app.use(cors({
    origin: "https://sianwebsiteback.onrender.com",
    methods: "GET,POST,PUT,DELETE",
    allowedHeaders: "Content-Type,Authorization"
}));

// Middleware para JSON
app.use(express.json());

// Ruta de prueba
app.get("/", (req, res) => {
    res.send("¡Servidor funcionando correctamente!");
});

// Escuchar en un puerto dinámico (Render usa process.env.PORT)
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Servidor corriendo en el puerto ${PORT}`);
});

console.log("Running server...");

const express = require("express");
const cors = require("cors");
const admin = require("firebase-admin");

// Inicializa Firebase Admin SDK
const serviceAccount = JSON.parse(process.env.FIREBASE_CONFIG); // Asegúrate de que esta ruta sea correcta

admin.initializeApp({
    credential: admin.credential.cert(serviceAccount),
});

const db = admin.firestore();
const app = express();

// Habilitar CORS
app.use(cors({
    origin: ["http://localhost:4200", "https://sianwebsiteback.onrender.com"],
    methods: "GET,POST,PUT,DELETE",
    allowedHeaders: "Content-Type,Authorization"
}));

// Middleware para JSON
app.use(express.json());

// Ruta de prueba
app.get("/", (req, res) => {
    res.send("¡Servidor funcionando correctamente!");
});

// Ruta para buscar artículos en Firestore
app.get("/Articulo/buscar/:query", async (req, res) => {
    const query = req.params.query.toLowerCase(); // Convertir a minúsculas

    try {
        const snapshot = await db.collection("sian").get();
        const productos = snapshot.docs
            .map(doc => ({ id: doc.id, ...doc.data() }))
            .filter(item =>
                item.Articulo &&
                item.Articulo.toLowerCase().includes(query) // Búsqueda parcial
            );

        if (productos.length === 0) {
            return res.status(404).json({ error: "No se encontraron resultados" });
        }

        res.status(200).json(productos);
    } catch (error) {
        console.error("Error en la búsqueda:", error);
        res.status(500).json({ error: "Error en la búsqueda", details: error.message });
    }
});

// Escuchar en un puerto dinámico (Render usa process.env.PORT)
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`🔥 Servidor corriendo en el puerto ${PORT}`);
});

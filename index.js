console.log("Running server...");

const express = require("express");
const cors = require("cors");
const admin = require("firebase-admin");

// Inicializa la aplicación de Firebase
admin.initializeApp({
    credential: admin.credential.cert(require('./sianwebsite-firebase-adminsdk-fbsvc-a0e15a8d2f.json')),
    databaseURL: 'https://sianwebsite-default-rtdb.europe-west1.firebasedatabase.app',
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
        const collectionRef = db.collection("sian");
        const snapshot = await collectionRef.get();

        if (snapshot.empty) {
            return res.status(404).json({ error: "No se encontraron resultados" });
        }

        const productos = snapshot.docs.map(doc => ({ id: doc.id, ...doc.data() }));
        const filteredProductos = productos.filter(item =>
            item.Articulo && item.Articulo.toLowerCase().includes(query)
        );

        if (filteredProductos.length === 0) {
            return res.status(404).json({ error: "No se encontraron resultados" });
        }

        res.status(200).json(filteredProductos);
    } catch (error) {
        console.error("Error en la búsqueda:", error);
        res.status(500).json({ error: "Error en la búsqueda", details: error.message });
    }
});

const PORT = process.env.PORT || 3306;
app.listen(PORT, () => {
    console.log(`🔥 Servidor corriendo en el puerto ${PORT}`);
});
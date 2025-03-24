const admin = require('firebase-admin');

// Inicializa Firebase Admin SDK
const serviceAccount = require('C:\\Users\\Jose Espejo\\Desktop\\main\\sianwebsite-firebase-adminsdk-fbsvc-a0e15a8d2f.json'); // Reemplaza con la ruta a tu archivo de credenciales

admin.initializeApp({
    credential: admin.credential.cert(serviceAccount),
    databaseURL: 'https://sianwebsite.firebaseio.com' // Reemplaza con la URL de tu proyecto (opcional, pero recomendado)
});

const db = admin.firestore();

// Función para cargar los datos
async function cargarDatos() {
    const jsonData = require('C:\\Users\\Jose Espejo\\Desktop\\main\\sian.json'); // Reemplaza con la ruta a tu archivo JSON

    let datosImportar = [];

    // Busca el objeto que contiene la clave "data"
    for (const obj of jsonData) {
        if (obj.type === "table" && obj.data) {
            datosImportar = obj.data;
            break; // Tomamos el primer conjunto de datos encontrado
        }
    }

    if (datosImportar.length === 0) {
        console.error("No se encontraron datos en el JSON.");
        return;
    }

    // Define el nombre de la colección en Firestore
    const coleccionNombre = "sian"; // Puedes cambiarlo si necesitas otro nombre

    for (const documento of datosImportar) {
        try {
            await db.collection(coleccionNombre).add(documento);
            console.log(`Documento agregado a ${coleccionNombre}`);
        } catch (error) {
            console.error(`Error al agregar documento:`, error);
        }
    }

    console.log('¡Todos los datos han sido cargados!');
}

cargarDatos()
    .then(() => {
        console.log('Proceso de importación completado.');
        process.exit(0); // Salir del proceso Node.js
    })
    .catch(error => {
        console.error('Error durante la importación:', error);
        process.exit(1); // Salir con código de error
    });

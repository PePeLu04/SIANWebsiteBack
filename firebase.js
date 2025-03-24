const admin = require('firebase-admin');

// Ruta a tu archivo de credenciales JSON (ajústala según tu estructura)
const serviceAccount = require('C:\\Users\\Jose Espejo\\Desktop\\main\\sianwebsite-firebase-adminsdk-fbsvc-a0e15a8d2f.json');

admin.initializeApp({
    credential: admin.credential.cert(serviceAccount),
    databaseURL: 'https://sianwebsite.firebaseio.com' // Reemplaza con la URL de tu proyecto
});

const db = admin.firestore();

module.exports = db;

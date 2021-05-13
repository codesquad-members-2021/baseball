import firebase from 'firebase';

const firebaseConfig = {
    apiKey: 'AIzaSyDve7bT1KUzDeLxIqaqOAKlTlyfNKFaK34',
    authDomain: 'fir-599a5.firebaseapp.com',
    projectId: 'fir-599a5',
    storageBucket: 'fir-599a5.appspot.com',
    messagingSenderId: '934291833471',
    appId: '1:934291833471:web:5008c15fabbd31d97e754a',
    measurementId: 'G-QNWSL5TVMW',
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);
firebase.analytics();

export default firebase;

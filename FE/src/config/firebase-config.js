import firebase from 'firebase';

const firebaseConfig = {
  apiKey: 'AIzaSyDg7BpKWF6sui839JLLnVT3CPKJjrAu5pw',
  authDomain: 'baseball-game-f56dd.firebaseapp.com',
  projectId: 'baseball-game-f56dd',
  storageBucket: 'baseball-game-f56dd.appspot.com',
  messagingSenderId: '203025757935',
  appId: '1:203025757935:web:f8f776e557904f05e00d1a',
  measurementId: 'G-PNGFXJ77EK',
};
// Initialize Firebase
firebase.initializeApp(firebaseConfig);
firebase.analytics();

export default firebase;

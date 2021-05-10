import firebase from "../config/firebase-config";

const socialMediaAuth = async (provider) => {
  try {
    const auth = await firebase.auth();
    const res = await auth.signInWithPopup(provider);
    return res.user;
  } catch (error) {
    return error;
  }
};

export default socialMediaAuth;

// return firebase
// .auth()
// .signInWithPopup(provider)
// .then((res) => {
//   return res.user;
// })
// .catch((er) => {
//   return er;
// });

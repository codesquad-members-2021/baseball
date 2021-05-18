import firebase from '../../config/firebase-config';

const socialMediaAuth = async (provider) => {
    try {
        const auth = firebase.auth();
        const res = await auth.signInWithPopup(provider);
        return res.user;
    } catch (error) {
        return error;
    }
};

export default socialMediaAuth;

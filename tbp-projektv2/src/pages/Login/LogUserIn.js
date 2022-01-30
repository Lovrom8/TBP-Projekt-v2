import { loginUser } from '../../api/login';
import { getUserData } from '../../api/user';
import userContext from '../../context/userContext';

/**
 * Tries to log user in or throws server's error message.
 * @param {string} email Email of the requested user.
 * @param {string} password Readable password of the requested user.
 * @param {function} setUser Callback function for user setter (setUser).
 * @returns {object} Logged user.
 */
const LogUserIn = async ({ email, password }, setUser) => {
  var response, responseData = null;
  var currentUser, currentUserData = null;
  try {
    responseData = await loginUser({ email, password });
    response = responseData.data;

    currentUserData = await getUserData(response.jwt);
    currentUser = currentUserData.data;
  } catch (ex) {
    if (response) throw response;
    else throw new Error('Something went terribly wrong! Please try again.');
  }

  currentUser['isLoggedIn'] = true;
  currentUser['authToken'] = response.jwt;
  currentUser['jwtExp'] = new Date().getTime() + 3600000; 

  localStorage.setItem('userData', JSON.stringify(currentUser)); 

  setUser(currentUser);
  return currentUser;
};

export default LogUserIn;

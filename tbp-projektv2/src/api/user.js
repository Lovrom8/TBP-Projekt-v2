import apiOrigin from './api';

export const getUserData = (authToken) => {
  console.log(authToken);
  return fetch(`${apiOrigin}/api/user`, {
    method: 'GET',
    headers: {
      'Authorization': 'Bearer ' + authToken,
      'Content-Type': 'application/json',
    },
  }).then((res) => res.json());
};
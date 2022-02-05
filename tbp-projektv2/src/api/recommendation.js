import apiOrigin from './api';

export const getRecommendations = (authToken) => {
  return fetch(`${apiOrigin}/api/user/recommendation`, {
    method: 'GET',
    headers: {
      'Authorization': 'Bearer ' + authToken,
      'Content-Type': 'application/json',
    },
  }).then((res) => res.json());
};

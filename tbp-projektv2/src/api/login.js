import apiOrigin from './api';

export const loginUser = (user) => {
  return fetch(`${apiOrigin}/api/auth`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(user),
  }).then((res) => {
    if (res.ok) return res.json();
    else return res.text();
  });
};
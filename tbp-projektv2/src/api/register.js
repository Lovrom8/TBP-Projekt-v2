import apiOrigin from './api';

export const registerUser = (data) => {
    console.log(data);
    return fetch(`${apiOrigin}/api/auth/register`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(data),
    }).then((res) => res.json());
  }
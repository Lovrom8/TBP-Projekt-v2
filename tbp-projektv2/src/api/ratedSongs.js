import apiOrigin from './api';

export const getRatedSongs = (authToken) => {
    return fetch(`${apiOrigin}/api/user/rated/songs`, {
      method: 'GET',
      headers: {
        'Authorization': 'Bearer ' + authToken,
        'Content-Type': 'application/json',
      },
    }).then((res) => res.json());
  };

  export const addRating = (authToken, songId, rating) => {
    return fetch(`${apiOrigin}/api/songs/rating`, {
      method: 'POST',
      headers: {
        'Authorization': 'Bearer ' + authToken,
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({songId:songId, rating:rating}),
    }).then((res) => {
      if (res.ok) return res.json();
      else return res.text();
    });
  };

  export const updateRating = (authToken, songId, rating) => {
    return fetch(`${apiOrigin}/api/songs/rating`, {
      method: 'PUT',
      headers: {
        'Authorization': 'Bearer ' + authToken,
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({songId:songId, rating:rating}),
    }).then((res) => {
      if (res.ok) return res.json();
      else return res.text();
    });
  };
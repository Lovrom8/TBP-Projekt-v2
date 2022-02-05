import apiOrigin from './api';

export const getSongRatingByUser = (authToken, songId) => {
    return fetch(`${apiOrigin}/api/songs/rating/${songId}`, {
      method: 'GET',
      headers: {
        'Authorization': 'Bearer ' + authToken,
        'Content-Type': 'application/json',
      },
    }).then((res) => res.json());
};

export const getSongDetails = (authToken, songId) => {
    return fetch(`${apiOrigin}/api/songs/${songId}`, {
      method: 'GET',
      headers: {
        'Authorization': 'Bearer ' + authToken,
        'Content-Type': 'application/json',
      },
    }).then((res) => res.json());
};

export const getRandomUnratedSong = (authToken) => {
  return fetch(`${apiOrigin}/api/songs/unrated`, {
    method: 'GET',
    headers: {
      'Authorization': 'Bearer ' + authToken,
      'Content-Type': 'application/json',
    },
  }).then((res) => res.json());
};

export const getSongSearch = (authToken, searchTerm) => {
  return fetch(`${apiOrigin}/api/songs/search/${searchTerm}`, {
    method: 'GET',
    headers: {
      'Authorization': 'Bearer ' + authToken,
      'Content-Type': 'application/json',
    },
  }).then((res) => res.json());
};
import apiOrigin from './api';

export const getAllGenres = (authToken) => {
  return fetch(`${apiOrigin}/api/genres`, {
    method: 'GET',
    headers: {
      'Authorization': 'Bearer ' + authToken,
      'Content-Type': 'application/json',
    },
  }).then((res) => res.json());
};

export const getAllSubgenres = (authToken) => {
  return fetch(`${apiOrigin}/api/subgenres`, {
    method: 'GET',
    headers: {
      'Authorization': 'Bearer ' + authToken,
      'Content-Type': 'application/json',
    },
  }).then((res) => res.json());
};

//------------------------------------------------------------

export const getLikedGenres = (authToken) => {
  return fetch(`${apiOrigin}/api/user/liked/genres`, {
    method: 'GET',
    headers: {
      'Authorization': 'Bearer ' + authToken,
      'Content-Type': 'application/json',
    },
  }).then((res) => res.json());
};

export const setLikedGenres = (authToken, likedGenres) => {
  return fetch(`${apiOrigin}/api/user/liked/genres`, {
    method: 'POST',
    headers: {
      'Authorization': 'Bearer ' + authToken,
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(likedGenres),
  }).then((res) => {
    if (res.ok) return res.json();
    else return res.text();
  });
};

export const getLikedSubgenres = (authToken) => {
  return fetch(`${apiOrigin}/api/user/liked/subgenres`, {
    method: 'GET',
    headers: {
      'Authorization': 'Bearer ' + authToken,
      'Content-Type': 'application/json',
    },
  }).then((res) => res.json());
};

export const setLikedSubgenres = (authToken, likedSubgenres) => {
  return fetch(`${apiOrigin}/api/user/liked/subgenres`, {
    method: 'POST',
    headers: {
      'Authorization': 'Bearer ' + authToken,
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(likedSubgenres),
  }).then((res) => {
    if (res.ok) return res.json();
    else return res.text();
  });
};
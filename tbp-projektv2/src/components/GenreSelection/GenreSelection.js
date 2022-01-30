import React, {useEffect, useState} from 'react';
import GenreSelector from '../GenreSelector/GenreSelector';
import { GenreSelectionGrid } from './GenreSelectionStyle';
import { getAllGenres, getLikedGenres } from '../../api/genres';
import userContext from '../../context/userContext';


const GenreSelection = ({selectedGenres, setSelectedGenres}) => { 

  const [allGenreData, setGenreData] = useState(false);
  const [likedGenreData, setLikedGenresData] = useState(false);
  const [displayedData, setDisplayedData] = useState(false);

  const setLikedGenres = async() => {
    var allGenres = [];

    console.log("Setting liked genres:");
    Object.keys(allGenreData).forEach(k => {
      const currentGenre = allGenreData[k];

      const likedGenre = likedGenreData.find(
        (likedGenre_) => likedGenre_.id === currentGenre.id,
      );

      if(likedGenre != null)
        currentGenre.liked = true;

      allGenres.push(currentGenre);
    });

    setDisplayedData([...allGenres]);
  };

 const loadLikedGenres = async () => {
    const dataJSON = await getLikedGenres(userContext.getJWT);
    const selectedGenresList = dataJSON.data;

    setLikedGenresData(selectedGenresList);
    setSelectedGenres([...selectedGenresList])
 };

  const loadGenreData = async () => {
    const dataJSON = await getAllGenres(userContext.getJWT);
    setGenreData(dataJSON.data);
  };

  useEffect(() => {
    setLikedGenres();
   }, [allGenreData]);
  
   useEffect(() => {
    loadGenreData();
   }, [likedGenreData]);
  
   useEffect(() => {
    loadLikedGenres();
   }, []);

  const newGenreSelected = (genreId, selected) => {
      if(selected) {
        const thisGenre = allGenreData.find(
          (anyGenre) => anyGenre.id === genreId,
        );

        setSelectedGenres([...selectedGenres, thisGenre]);
      } else {
        const genresWithoutThisOne = selectedGenres.filter(
          (otherGenre) => otherGenre.id !== genreId,
        );

        setSelectedGenres([...genresWithoutThisOne]);
      }
  };

  return <GenreSelectionGrid>
            { displayedData && 
              displayedData.map((genre) => <GenreSelector 
                                        key={genre.id} 
                                        genre={genre}
                                        liked={genre.liked}
                                        genreSelected={newGenreSelected}
                                         />)
            } 
    </GenreSelectionGrid>;
};

export default GenreSelection;

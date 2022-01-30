import React, {useEffect, useState} from 'react';
import { getAllSubgenres, getLikedSubgenres } from '../../api/genres';
import GenreSelector from '../GenreSelector/GenreSelector';
import { SubgenreSelectionGrid } from './SubgenreSelectionStyle';
import userContext from '../../context/userContext';

const SubgenreSelection = ({selectedSubgenres, setSelectedSubgenres}) => {
  const [allSubgenresData, setGenreData] = useState(false);
  const [likedSubgenreData, setLikedSubgenreData] = useState(false);
  const [displayedData, setDisplayedData] = useState(false);

  const setLikedSubgenres = async() => {
    var allSubgenres = [];

    console.log("Setting liked subgenres:");
    Object.keys(allSubgenresData).forEach(k => {
      const currentSubgenre = allSubgenresData[k];
      console.log(currentSubgenre);

      const likedSubgenre = likedSubgenreData.find(
        (likedGenre) => likedGenre.id === currentSubgenre.id,
      );

      if(likedSubgenre != null)
        currentSubgenre.liked = true;

      allSubgenres.push(currentSubgenre);
    });

    setDisplayedData([...allSubgenres]);
  };

  const loadSubgenreData = async () => {
    const dataJSON = await getAllSubgenres(userContext.getJWT);
    setGenreData(dataJSON.data);
 };

 const loadLikedSubgenres = async () => {
    const dataJSON = await getLikedSubgenres(userContext.getJWT);
    const selectedGenresList = dataJSON.data;

    setLikedSubgenreData(selectedGenresList);
    setSelectedSubgenres([...selectedGenresList])
 };

 useEffect(() => {
  setLikedSubgenres();
 }, [allSubgenresData]);

 useEffect(() => {
  loadSubgenreData();
 }, [likedSubgenreData]);

 useEffect(() => {
  loadLikedSubgenres();
 }, []);

 const newSubgenreSelected = (subgenreId, selected) => {
  if(selected) {
    const thisGenre = allSubgenresData.find(
      (anyGenre) => anyGenre.id === subgenreId,
    );

    setSelectedSubgenres([...selectedSubgenres, thisGenre]);
  } else {
    const genresWithoutThisOne = selectedSubgenres.filter(
      (otherGenre) => otherGenre.id !== subgenreId,
    );

    setSelectedSubgenres([...genresWithoutThisOne]);
  }
};

  return <SubgenreSelectionGrid>
              { displayedData && 
              displayedData.map((genre) => 
              <GenreSelector 
                key={genre.id} 
                liked={genre.liked}
                genre={genre} 
                genreSelected={newSubgenreSelected}
              />)
            } 
    </SubgenreSelectionGrid>;
};

export default SubgenreSelection;

import React, { useEffect, useState } from 'react';
import { setLikedGenres, setLikedSubgenres } from '../../api/genres';
import GenreSelection from '../../components/GenreSelection/GenreSelection';
import SubgenreSelection from '../../components/SubgenreSelection/SubgenreSelection';
import { GenreSelectionWrapper, SaveLikedGenresButton, SectionTitle } from './LikedGenresStyle';
import userContext from '../../context/userContext';

const LikedGenres = () => {
    const [selectedGenres, setSelectedGenres] = useState([]);
    const [selectedSubgenres, setSeletedSubgenres] = useState([]);

    const saveSelectedGenres = async () =>
    {
        let genreIDs = selectedGenres.map((genre) => genre.id);

        setLikedGenres(userContext.getJWT, genreIDs);
    };

    const saveSelectedSubgenres = async () =>
    {
        let subgenreIDs = selectedSubgenres.map((genre) => genre.id);

        setLikedSubgenres(userContext.getJWT, subgenreIDs);
    };

    const handleSave = () =>
    {
        console.log("Selected genres:");
        console.log(selectedGenres);
        console.log(selectedSubgenres);

        saveSelectedGenres();
        saveSelectedSubgenres();
    };

    return (
        <>
            <SectionTitle>Genres</SectionTitle>
            <GenreSelectionWrapper>
                <GenreSelection selectedGenres={selectedGenres} setSelectedGenres={setSelectedGenres} />
            </GenreSelectionWrapper>
            <SectionTitle>Subgenres</SectionTitle>
            <GenreSelectionWrapper>
                <SubgenreSelection selectedSubgenres={selectedSubgenres} setSelectedSubgenres={setSeletedSubgenres} />
            </GenreSelectionWrapper>

            <SaveLikedGenresButton type="submit" value="Spremi" onClick={()=>handleSave() }/>
        </>
    );
};

export default LikedGenres;
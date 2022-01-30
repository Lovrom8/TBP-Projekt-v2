import React, {useState} from 'react';
import { GenreSelectorCircle } from './GenreSelectorStyle';

const GenreSelector = ({genre, genreSelected, liked}) => {
    const [selected, setSelected] = useState(liked);

    const handleGenreSelected = () =>
    {
        setSelected(!selected);   
        genreSelected(genre.id, selected !== true);
    };

    return <GenreSelectorCircle isSelected={selected} onClick={() => handleGenreSelected()}>{genre.name}</GenreSelectorCircle>;
};

export default GenreSelector;

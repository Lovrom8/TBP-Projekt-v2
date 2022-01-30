import React, {useState} from 'react';
import { RecommendationWrapper, AlbumImage, Genre, SubgenreList, ArtistName, SongName } from './RecommendationStyle';

const Recommendation = ({recommendedSong}) => {
    return <RecommendationWrapper>
        <SongName>{recommendedSong.songName}</SongName>
        <ArtistName>{recommendedSong.artistName}</ArtistName>
        <AlbumImage src={recommendedSong.albumUrl} />
        <Genre>{recommendedSong.genre}</Genre>
        <SubgenreList>{recommendedSong.subgenres}</SubgenreList>
    </RecommendationWrapper>;
};

export default Recommendation;

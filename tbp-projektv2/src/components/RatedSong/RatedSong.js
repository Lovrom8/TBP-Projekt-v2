import React from 'react';
import { RatedSongWrapper, AlbumImage, SongName, ArtistName, Genre, SubgenreList, Rating, ButtonEditRating } from './RatedSongStyle';
import { Link } from 'react-router-dom';

const RatedSong = ({song}) => {
    return <RatedSongWrapper>
        <AlbumImage src={song.albumUrl} />
        <SongName>{song.song}</SongName>
        <ArtistName>{song.artist}</ArtistName>
        <Genre>{song.genre}</Genre>
        <SubgenreList>{song.subgenres}</SubgenreList>
        <Rating>{song.rating}</Rating>
        <Link to={`/editRating?songId=${song.songId}`}>
            <ButtonEditRating type="submit" value="Edit rating" />
        </Link>
    </RatedSongWrapper>
};

export default RatedSong;

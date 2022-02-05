import React, { useState, useEffect } from 'react';
import { addRating, updateRating } from '../../api/ratedSongs';
import userContext from '../../context/userContext';
import { useSearchParams } from 'react-router-dom';
import Recommendation from '../../components/Recommendation/Recommendation';
import { RatingNumberPicker, ButtonSaveRating, ButtonNextSong, RateSongWrapper } from './RateSongStyle';
import { getSongDetails, getSongRatingByUser, getRandomUnratedSong } from '../../api/song';
import { Link } from 'react-router-dom';

const RateSong = () => {
    const [songId, setSongId] = useState('');
    const [unratedSong, setUnratedSong] = useState(true);
    const [rateMore, setRateMore] = useState(false);
    const [songData, setSongData] = useState(false);
    const [songRating, setSongRating] = useState(3);

    const [searchParams, setSearchParams] = useSearchParams();

    const loadSongDetails = async () => {
        const dataJSON = await getSongDetails(userContext.getJWT, songId);
        setSongData(dataJSON.data);
    };

    const loadSongRating = async () => {
        const dataJSON = await getSongRatingByUser(userContext.getJWT, songId);
        setSongRating(dataJSON.data.rating);
    };

    const getRandomSong = async () => {
        const dataJSON = await getRandomUnratedSong(userContext.getJWT);
        setSongData(dataJSON.data);
        setSongId(dataJSON.data.songId);
    };

    const updateSongRating = async () => {
        if(rateMore) {
            console.log('Adding rating...');
            await addRating(userContext.getJWT, songId, songRating);
        } else {
            console.log('Updating rating...');
            await updateRating(userContext.getJWT, songId, songRating);
        }
    };

    useEffect(() => {
        if(!rateMore) {
            loadSongDetails();
            loadSongRating();
         }
    }, [songId]);

    useEffect(() => {
        const rateMoreSongs = searchParams.get("rateMore");
        if(rateMoreSongs) {
            console.log('Loading a random song...');
            setRateMore(true);
            getRandomSong();
        }

        const songId = searchParams.get("songId");
        if (songId) {
            setUnratedSong(false);
            setSongId(songId);
        }
    }, []);

    return (  
         <RateSongWrapper>
            { songData && <Recommendation key={songData.id} recommendedSong={songData} /> }
            <RatingNumberPicker min={1} max={5} value={songRating}  onChange={value => setSongRating(value)} />
            <ButtonSaveRating type="submit" value="Save rating" onClick={(e) => updateSongRating()} />
            <Link to={`/editRating?rateMore`}>
                { rateMore && <ButtonNextSong type="submit" value="Rate next song" /> }
            </Link>
         </RateSongWrapper>
    );
};

export default RateSong;
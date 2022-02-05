import React, { useState, useEffect } from 'react';
import { getRatedSongs } from '../../api/ratedSongs';
import RatedSong from '../../components/RatedSong/RatedSong';
import { ButtonRateMore, RatedSongsWrapper, RatedSongsGrid, ButtonSongSearch, MenuButtonsWrapper } from './RatedSongsStyle';
import userContext from '../../context/userContext';
import { Link } from 'react-router-dom';

const RatedSongs = () => {
    const [ratedSongsData, setRatedSongsData] = useState(false);

    const loadRatedSongs = async () => {
      const dataJSON = await getRatedSongs(userContext.getJWT);
      setRatedSongsData(dataJSON.data);
      console.log(dataJSON.data);
    };
  
    useEffect(() => {
        loadRatedSongs();
    }, []);

    return (
        <RatedSongsWrapper>
            <MenuButtonsWrapper>
                <Link to={`/editRating?rateMore=1`}>
                    <ButtonRateMore type="submit" value="Ocjeni nasumičnu pjesmu" />
                </Link>
                <Link to={`/songSearch`}>
                    <ButtonSongSearch type="submit" value="Pretraga pjesama" />
                </Link>
            </MenuButtonsWrapper>
            <RatedSongsGrid>
            { ratedSongsData &&
                ratedSongsData.map((ratedSong) => <RatedSong key={ratedSong.songId} song={ratedSong} /> )  
            }
            </RatedSongsGrid>
        </RatedSongsWrapper>
    );
};

export default RatedSongs;
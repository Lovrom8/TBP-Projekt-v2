import React, { useState, useEffect } from 'react';
import { SongSearchGrid, SearchBox, SongSearchWrapper, SearchButton} from './SongSearchStyle';
import RatedSong from '../../components/RatedSong/RatedSong';
import { getSongSearch } from '../../api/song';
import userContext from '../../context/userContext';

const SongSearch = () => {
    const [searchTerm, setSearchTerm] = useState('');
    const [searchData, setSearchData] = useState(false);

    const searchSongs = async () => {
        console.log('searching');
        const dataJSON = await getSongSearch(userContext.getJWT, searchTerm);
        setSearchData(dataJSON.data);
    };

    return (
        <SongSearchWrapper>

            <SearchBox icon='search' placeholder='Pretraži...' onChange={(e) => setSearchTerm(e.target.value) }/>
            <SearchButton type="submit" value="Pretraži" onClick={(e) => searchSongs()}/>

            <SongSearchGrid>
                { searchData &&
                    searchData.map((song) => <RatedSong key={song.songId} song={song} /> )  
                }
            </SongSearchGrid>

        </SongSearchWrapper>
    );
};

export default SongSearch;
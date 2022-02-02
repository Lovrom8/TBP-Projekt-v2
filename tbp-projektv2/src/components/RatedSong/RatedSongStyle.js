import styled from 'styled-components';
import { colors } from '../../lib/style/theme';
import {
    ButtonStyle
  } from '../../lib/style/generalStyles';

export const RatedSongWrapper = styled.div`
    text-align:center;
    display:inline-block;
    display:flex;
    flex-direction:row;
    align-items: center;
    justify-content: center;

    border: 3px solid ${colors.black};
    border-radius: 6px;
    padding: 10px;
    gap: 10px;
    margin: 10px;
`;

export const SongName = styled.span`
    padding-left: 20px;
    padding-right: 10px;
`;

export const ArtistName = styled.span`
    padding-right: 10px;
`;

export const AlbumImage = styled.img`
    height: 75px;
    width: 75px;
`;

export const Genre = styled.span`
    padding-right: 10px;
`;

export const SubgenreList = styled.span`
    padding-right: 10px;
`;

export const Rating = styled.span`
    padding-left: 20px;
    padding-right: 30px;
    color: red;
    font-weight: bold;
`;

export const ButtonEditRating = styled.input`
  ${ButtonStyle};
  width: 150px;

  background-color: ${colors.black};
`;
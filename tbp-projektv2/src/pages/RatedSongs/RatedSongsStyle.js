import styled from 'styled-components';
import { colors } from '../../lib/style/theme';
import {
    ButtonStyle
} from '../../lib/style/generalStyles';

export const RatedSongsWrapper = styled.div`
    display: flex;
    justify-content: center;
    flex-direction: column;
    padding-top: 20px;
    padding-left: 150px;
`;

export const RatedSongsGrid = styled.div`
    display:grid;
    grid-column-gap: 50px;
    
    grid-template-columns: 1fr;
    margin: 0 auto;
    text-align:center;
`;


export const ButtonRateMore = styled.input`
  ${ButtonStyle};
  width: 300px;
  text-align: center;

  background-color: ${colors.black};
`;

export const ButtonSongSearch = styled.input`
  ${ButtonStyle};
  width: 200px;
  text-align: center;

  background-color: ${colors.black};
`;

export const MenuButtonsWrapper = styled.div`
    max-width: 500px;
    display: flex;
    justify-content: space-between;
    gap: 20px;
`;
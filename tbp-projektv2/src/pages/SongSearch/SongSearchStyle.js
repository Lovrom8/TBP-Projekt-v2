import styled from 'styled-components';
import { colors } from '../../lib/style/theme';
import {
    ButtonStyle
} from '../../lib/style/generalStyles';

export const SongSearchWrapper = styled.div`
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
`;

export const SongSearchGrid = styled.div`
    display:grid;
    grid-column-gap: 50px;
    
    grid-template-columns: 1fr;
    margin: 0 auto;
    text-align:center;
`;

export const SearchBox = styled.input`
    border: 2px solid ${colors.black};
    border-radius: 6px;
    width: 200px;
    height: 30px;
    margin: 20px;
`;

export const SearchButton = styled.input`
  ${ButtonStyle};
  width: 100px;
  text-align: center;

  background-color: ${colors.black};
`;
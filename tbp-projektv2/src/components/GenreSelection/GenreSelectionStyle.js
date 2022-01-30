import styled from 'styled-components';
import { colors, breakpoints } from '../../lib/style/theme';

export const GenreSelectionGrid = styled.div`
    display: grid;
    grid-template-columns: repeat(3, 200px);
    grid-gap: 30px;
    padding: 25px;
`;

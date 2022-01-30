import styled from 'styled-components';
import { colors, breakpoints } from '../../lib/style/theme';
import { ButtonStyle } from '../../lib/style/generalStyles';

export const GenreSelectionWrapper = styled.div`
    display: flex;
    justify-content: space-around;
`;

export const SectionTitle = styled.h2`
    padding: 10px;
    margin: 10px;
    color: ${colors.grey};
`;

export const SaveLikedGenresButton = styled.input`
  ${ButtonStyle};
  bottom: 16px;
  width: 288px;

  margin-top: 40px;
  position: relative;
  margin-left: 800px;
`;
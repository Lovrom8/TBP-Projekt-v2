import styled from 'styled-components';
import { colors, breakpoints } from '../../lib/style/theme';

export const MainWrapper = styled.main`
  box-sizing: border-box;
  margin: 0;
  padding: 0;
  margin-top: 70px;
  flex: 1 0 auto;
  background-color: ${colors.greyBackground};
  width: auto;
  height: auto;

  @media screen and (${breakpoints.tablet}) {
    margin-top: 80px;
  }
`;

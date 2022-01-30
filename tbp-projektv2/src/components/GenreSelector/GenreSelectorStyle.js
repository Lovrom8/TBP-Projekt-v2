import styled from 'styled-components';
import { colors } from '../../lib/style/theme';

export const GenreSelectorCircle = styled.div`
  width: 125px;
  height: 125px;
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 50%;
  border-style: solid;
  border-width: ${(props) => props.isSelected === true ? '5px' : '2px'};
  border-color: ${(props) => props.isSelected === true ? colors.black : colors.grey};
  font-size: 18px;
  font-color: ${colors.black}
  color: ${colors.darkBlue};
  text-align: center;
`;

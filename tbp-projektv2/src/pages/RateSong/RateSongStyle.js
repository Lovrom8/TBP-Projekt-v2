import styled from 'styled-components';
import { colors } from '../../lib/style/theme';
import {
    ButtonStyle
  } from '../../lib/style/generalStyles';
import NumberPicker from "react-widgets/NumberPicker";
import "react-widgets/styles.css";

export const RateSongWrapper = styled.div`
  text-align:center;
  justify-content: center;

  padding: 10px;
  gap: 10px;
  margin: 10px;

  & > * {
    margin: 10px 0;
  }
`;

export const ButtonSaveRating = styled.input`
  ${ButtonStyle};
  width: 150px;

  background-color: ${colors.black};
`;


export const ButtonNextSong = styled.input`
  ${ButtonStyle};
  width: 150px;

  background-color: ${colors.black};
`;

export const RatingNumberPicker = styled(NumberPicker)`
  margin-left: 400px;
  margin-right: 400px;
`;
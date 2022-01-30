import styled, { css, keyframes } from 'styled-components';
import {
  ButtonStyle,
  InputStyle,
  TextDefault,
  TextStyle,
} from '../../lib/style/generalStyles';
import { breakpoints, colors } from '../../lib/style/theme';
import backgroundBig from './images/ilustrationBig.png';
import backgroundMedium from './images/ilustrationMedium.png';
import backgroundSmall from './images/ilustrationSmall.png';
import logo from './images/logo.png';

export const RegisterPageWrapper = styled.div`
  height: 100%;
  display: flex;
  flex-direction: column;
  overflow: hidden;
  justify-content: center;
  align-items: center;
`;

export const RegisterForm = styled.form`
  height: 100%;
  width: 100%;
  display: flex;
  z-index: 999;
  justify-content: center;
  align-content: center;
  align-items: center;
  flex-direction: column;

  @media screen and (${breakpoints.mobileLarge}) {
    align-content: center;
  }
`;

export const Logo = styled.div`
  width: 100%;
  height: 256px;
  background-image: url(${logo});
  background-repeat: no-repeat;
  background-size: contain;
  @media screen and (${breakpoints.mobileLarge}) {
    width: 470px;
    height: 140px;
    position: relative;
  }
`;

export const ButtonRegister = styled.input`
  ${ButtonStyle};
  position: absolute;
  bottom: 16px;
  width: 288px;

  @media screen and (${breakpoints.mobileLarge}) {
    margin-top: 40px;
    position: relative;
  }
`;

export const InputArea = styled.div`
  display: flex;
  width: 90%;
  justify-content: flex-start;

  margin-top: 10px;

  z-index: 999;

  @media screen and (${breakpoints.mobileLarge}) {
    max-width: 288px;
  }
`;

export const AnimatedPlaceholder = styled.span`
  ${TextStyle};

  position: absolute;
  display: inline;

  position: fixed;
  margin-top: 16px;

  color: ${colors.greyOverlay};
  pointer-events: none;
`;

export const InputField = styled.input`
  ${InputStyle};
  max-width: 100%;
  width: 100%;
  padding: 0 16px;
  font-size: 16px;

  &::placeholder {
    color: transparent;
  }

  &:focus + span,
  &:not(:placeholder-shown) + span {
    transform: translateY(-1em) translateX(-1em) scale(0.75);
    color: ${(props) => (props.error ? colors.error : colors.lightBlue)};
  }

  @media screen and (${breakpoints.mobileLarge}) {
    width: 100%;
    max-width: 100%;
    max-height: 56px;
  }
`;

/* Animations Part (the cool stuff) */

const AnimationBackgroundBig = keyframes`
    from {
        background-position: 0 0;
    }
    to {
        background-position: 1250px 700px;
    }
`;
const AnimationBackgroundMedium = keyframes`
    from {
        background-position: 0 0;
    }
    to {
        background-position: 750px 300px;
    }
`;

const AnimationBackgroundSmall = keyframes`
    from {
        background-position: 0 0;
    }
    to {
        background-position: 300px 200px;
    }
`;

export const BackgroundDefault = css`
  position: fixed;
  top: 0;
  left: 0;

  margin: 0;
  padding: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
  background-size: auto;

  animation-direction: alternate;
  animation-iteration-count: infinite;
  animation-fill-mode: both;
  animation-play-state: running;
  animation-timing-function: ease-out;

  @media screen and (${breakpoints.tablet}) {
    scale: 1.2;
  }
  @media screen and (${breakpoints.desktop}) {
    scale: 1.4;
  }
`;

export const BackgroundBig = styled.div`
  background: url(${backgroundBig});

  animation: ${AnimationBackgroundBig};
  animation-duration: 175s;
  z-index: 3;

  ${BackgroundDefault};
`;

export const BackgroundMedium = styled.div`
  background: url(${backgroundMedium});

  animation: ${AnimationBackgroundMedium};
  animation-duration: 175s;
  z-index: 2;

  ${BackgroundDefault};
`;

export const BackgroundSmall = styled.div`
  background: url(${backgroundSmall});

  animation: ${AnimationBackgroundSmall};
  animation-duration: 175s;
  z-index: 1;

  ${BackgroundDefault};
`;

export const MessageError = styled.div`
  ${TextDefault};
  margin: 16px 0 35px;
  font-weight: 1000;
  color: ${colors.error};
`;

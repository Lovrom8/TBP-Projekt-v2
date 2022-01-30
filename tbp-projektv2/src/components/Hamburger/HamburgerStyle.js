import styled, { keyframes } from 'styled-components';
import { NavLink } from 'react-router-dom';
import {
  colors,
  breakpoints,
  boxShadow,
  transitionEase,
} from '../../lib/style/theme';

export const HamburgerWrapper = styled.div`
  width: 25px;

  & > div {
    background-color: ${(props) => props.isOpened && colors.mediumBlue};
  }

  @media screen and (${breakpoints.desktop}) {
    display: none;
  }
`;

export const HamburgerLine = styled.div`
  width: 100%;
  height: 2px;
  border-radius: 100px;
  background-color: ${colors.black};
  margin-bottom: 6px;

  transition: ${transitionEase};

  &:last-child {
    margin-bottom: 2px;
  }
`;

export const HamburgerOpened = styled.div`
  position: absolute;
  right: 0;
  top: 70px;
  padding: 10px 50px 25px;
  background-color: ${colors.white};

  border-style: solid;
  border-top-style: none;
  border-right-style: none;
  border-width: 3px;
  border-color: ${colors.grey};

  box-shadow: ${boxShadow};

  @media screen and (${breakpoints.desktop}) {
    display: none;
  }
`;

export const openingAnimation = keyframes`
 from { opacity: 0%; }
 to { opacity: 100%; padding: 15px 2px 20px; }
`;

export const HamburgerItem = styled(NavLink)`
  display: block;
  text-decoration: none;
  color: ${(props) =>
    props.isCurrent === 'true' ? colors.mediumBlue : colors.black};
  font-weight: 1000;
  font-size: 20px;

  &:hover {
    color: ${colors.red};
  }

  animation-name: ${openingAnimation};
  animation-duration: 0.25s;
  animation-iteration-count: 1;
  animation-fill-mode: forwards;
`;

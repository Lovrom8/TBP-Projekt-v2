import styled, { css, keyframes } from 'styled-components';
import {
  borderBlue,
  borderGrey,
  boxShadow,
  boxShadowActive,
  breakpoints,
  colors,
  transitionCubic,
  transitionEase,
} from './theme';

export const InnerFontDefinitionStyle = css`
  font-family: 'HelveticaNeue', sans-serif;
  font-size: 18px;
  font-weight: 500;
  font-stretch: normal;
  font-style: normal;
  line-height: 1.44;
  letter-spacing: 1px;
  text-align: center;
`;

// Ovaj stil koristiš tamo gdje želiš da se izvana mijenjaju css obilježja prema specifičnim potrebama!
export const InheritanceStyle = css`
  display: ${(props) => props.display && props.display};

  margin: ${(props) => props.margin};
  padding: ${(props) => props.padding};

  width: ${(props) => props.width};
  height: ${(props) => props.height};
  max-width: ${(props) => props.maxWidth};
  max-height: ${(props) => props.maxHeight};
  min-width: ${(props) => props.minWidth};
  min-height: ${(props) => props.minHeight};

  background-color: ${(props) => props.color};
  background-color: ${(props) =>
    props.color === 'grey' && colors.greyBackground};
`;

export const buttonClickAnimation = keyframes`
  from  {
    box-shadow: boxShadowActive;
    scale: 100%;
  }
  to {
    box-shadow: none;
    scale: 95%;
  }
`;
export const ButtonClickAnimation = css`
  animation-name: ${buttonClickAnimation};
  animation-duration: 0.05s;
  animation-iteration-count: 0;
`;

export const ButtonStyle = css`
  display: ${(props) => (props.display ? props.display : 'inline')};
  transition: ${transitionEase};
  ${InnerFontDefinitionStyle};

  width: ${(props) => (props.width ? props.width : '232px')};
  height: ${(props) => (props.width ? props.width : '56px')};
  border-radius: 4px;
  box-shadow: ${boxShadow};
  border: ${borderBlue};

  color: ${(props) =>
    props.color === 'white' ? colors.grey : colors.white};
  background-color: ${(props) =>
    props.color === 'white' ? colors.white : colors.grey};

  color: ${(props) => props.deactivated === 'true' && colors.grey};
  border: ${(props) => props.deactivated === 'true' && borderGrey};
  background-color: ${(props) => props.deactivated === 'true' && colors.white};
  box-shadow: ${(props) => props.deactivated === 'true' && 'none'};

  &:hover {
    box-shadow: ${(props) => props.deactivated !== 'true' && boxShadowActive};
    cursor: pointer;
    background-color: ${(props) =>
      props.deactivated !== 'true' && colors.selectedBlue};
    background-color: ${(props) =>
      props.color === 'white' && colors.greyBackground};
    color: ${(props) => props.color === 'white' && colors.darkBlue};
  }
  &:focus {
    box-shadow: ${(props) => props.deactivated !== 'true' && boxShadow};
    ${ButtonClickAnimation};
    animation-iteration-count: ${(props) => props.deactivated !== 'true' && 1};
  }

  @media not screen and (${breakpoints.mobileLarge}) {
    width: 90%;
  }
`;
export const ButtonDefault = styled.button`
  ${ButtonStyle};
`;

export const TextStyle = css`
  display: ${(props) => (props.display ? props.display : 'block')};
  transition: ${transitionEase};

  margin: ${(props) => (props.margin ? props.margin : '24px')};
  color: ${colors.black};
  color: ${(props) => props.blue && colors.darkBlue};
  color: ${(props) => props.white && colors.white};
  width: ${(props) => (props.width ? props.width : 'auto')};

  font-family: 'HelveticaNeue', sans-serif;
  font-size: ${(props) => (props.fontSize ? props.fontSize : '16px')};
  font-weight: ${(props) => (props.bold ? 'bold' : 'normal')};
  font-stretch: normal;
  font-style: normal;
  line-height: 1.5;
  letter-spacing: normal;
`;
export const TextDefault = styled.span`
  ${TextStyle};
`;

export const TabStyle = css`
  display: ${(props) => (props.display ? props.display : 'inline')};
  transition: ${transitionCubic};
  width: 100%;
  ${InnerFontDefinitionStyle};

  background-color: ${colors.transparent};
  border-color: ${colors.transparent};
  border: 3px ${colors.transparent} outset;
  padding: 15px 0;

  border-bottom-color: ${(props) =>
    props.active === 'true' && colors.black};
  color: ${(props) => props.active !== 'true' && colors.black};
  font-weight: ${(props) => (props.active === 'true' ? 'bold' : '300')};

  &:hover {
    border-bottom-color: ${(props) =>
      props.active !== 'true' ? colors.lightBlue : colors.darkBlue};
    color: ${(props) => props.active !== 'true' && colors.black};
    cursor: pointer;
  }
`;
export const TabDefault = styled.button`
  ${TabStyle};
`;

export const GridStyle = css`
  grid-template-columns: ${(props) =>
    props.cols && 'repeat(' + props.cols + ', auto)'};
  grid-template-rows: ${(props) =>
    props.rows && 'repeat(' + props.rows + ', auto)'};

  ${InheritanceStyle};
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: column;

  @media screen and (${breakpoints.tablet}) {
    display: grid;
    align-items: initial;
    justify-content: initial;
    flex-direction: initial;
  }
`;
export const GridDefault = styled.div`
  ${GridStyle};
`;

export const FlexStyle = css`
  display: flex;
  justify-content: space-around;
  align-items: center;

  ${InheritanceStyle};
`;
export const FlexDefault = styled.div`
  ${FlexStyle};
`;

export const openingAnimation = keyframes`
  from  {
    opacity: 0%;
    scale: 0%;
  }
  to {
    opacity: 100%; 
    scale: 100%;
  }
`;

/*  Za "zoom-in" efekt na komponenti, u njezin stil staviti odavde:

${ZoomAnimation};

*/
export const ZoomInAnimation = css`
  animation-name: ${openingAnimation};
  animation-duration: 0.25s;
  animation-iteration-count: 1;
  animation-fill-mode: forwards;
`;

export const InputStyle = css`
  ${InheritanceStyle};

  max-width: 95%;

  outline: none;
  font-size: 14px;
  line-height: 56px;

  border-radius: 4px;
  border: ${borderGrey};

  transition: ${transitionEase};

  &:focus {
    transition: ${transitionEase};
    border: ${borderBlue};
  }

  @media screen and (${breakpoints.tablet}) {
    width: 350px;
  }

  @media screen and (${breakpoints.desktop}) {
    width: 400px;
  }

  @media screen and (${breakpoints.desktop}) {
    font-size: 16px;
  }
`;

export const InputDefault = styled.input`
  ${InputStyle};
  padding: ${(props) => (props.padding ? props.padding : '0 16px')};
  margin: ${(props) => (props.margin ? props.margin : '0 auto')};
  height: ${(props) => (props.height ? props.height : '56px')};
  width: ${(props) => (props.width ? props.width : '288px')};
`;

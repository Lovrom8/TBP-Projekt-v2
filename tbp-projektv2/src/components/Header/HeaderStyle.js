import styled from 'styled-components';
import { Link } from 'react-router-dom';
import { colors, breakpoints, boxShadow } from '../../lib/style/theme';
import {
  ButtonStyle,
  TextStyle,
  TabStyle,
} from '../../lib/style/generalStyles';

export const HeaderWrapper = styled.header`
  background-color: ${colors.lightBlue};
  box-shadow: ${boxShadow};
  width: 100%;
  height: 70px;
  position: fixed;
  top: 0;
  left: 0;
  z-index: 1;

  @media screen and (${breakpoints.tablet}) {
    height: 80px;
  }
`;

export const Inner = styled.div`
  height: 100%;
  padding: 15px;
  display: flex;
  justify-content: space-between;
  align-items: center;

  @media screen and (${breakpoints.tablet}) {
    margin: 16px 40px 16px 40px;
    padding: 0;
    height: 48px;
    align-items: flex-end;
  }

  @media screen and (${breakpoints.desktop}) {
    width: 100%;
    margin: auto;
  }
`;

export const LogoContainer = styled(Link)`
  display: block;
  width: 50px;

  @media screen and (${breakpoints.tablet}) {
    width: 39px;
    height: 44px;
    margin: 0;
  }

  @media screen and (${breakpoints.desktp}) {
    height: 39px;
    width: 44px;
    margine-left: 40px;
  }
`;

export const Logo = styled.img`
  width: 34px;
  height: 38px;
  object-fit: contain;

  @media screen and (${breakpoints.tablet}) {
    width: 100%;
    height: 100%;
    margin: 0;
  }

  @media screen and (${breakpoints.desktop}) {
    margin-left: 108px;
    margin-top: 18px;
  }
`;

export const HeaderTitle = styled.h2`
  ${TextStyle}
  line-height: 1.44;
  width: 100%;
  height: 100%;
  font-size: 36px;
  
  display: none;

  @media screen and (${breakpoints.desktop}) {
    display: flex;
    margin: 18px auto auto 100px;
    justify-content: space-between;
    align-items: baseline;
  }
`;

export const Nav = styled.nav`
  display: none;

  @media screen and (${breakpoints.desktop}) {
    display: block;
  }
`;

export const HamburgerWrapper = styled.div`
  height: 24px;
  width: 24px;

  @media screen and (${breakpoints.tablet}) {
    display: none;
  }
`;

export const HeaderButtonWrapper = styled.div`
  display: none;

  @media screen and (${breakpoints.tablet}) {
    display: inline-block;
    height: 100%;
    width: 104px;
  }

  @media screen and (${breakpoints.desktop}) {
    height: 48px;
    width: 104px;
    margin-bottom: -16px;
    margin-right: 108px;
  }
`;

export const HeaderButtonWrapperTabs = styled.div`
  display: none;

  @media screen and (${breakpoints.desktop}) {
    display: grid;
    align-self: baseline;
    grid-template-columns: repeat(2, 1fr);
    grid-gap: 32px;
    width: auto;
    height: auto;
    margin-top: 18px;
    margin-right: 32px;
  }
`;

export const TabDefault = styled.button`
  ${TabStyle};

  padding-top: 8px;
  padding-bottom: 22px;
`;

export const ButtonHeader = styled.button`
  ${ButtonStyle};

  @media screen and (${breakpoints.desktop}) {
    height: 48px;
    width: 104px;
    margin-bottom: -16px;
    margin-right: 108px;
  }
`;
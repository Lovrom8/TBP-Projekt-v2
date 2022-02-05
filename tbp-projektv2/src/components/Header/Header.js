import React from 'react';
import { observer } from 'mobx-react';

import userContext from '../../context/userContext';
import { NavLink, useNavigate, useLocation  } from 'react-router-dom';

import LogoImage from '../../pages/Login/images/logo.png';

import {
    HeaderWrapper,
    Inner,
    Logo,
    LogoContainer,
    HeaderTitle,
    HeaderButtonWrapper,
    ButtonHeader,
    HeaderButtonWrapperTabs,
    TabDefault,
  } from './HeaderStyle';

const Header = props => {
  const navigate = useNavigate();
  let location = useLocation();

  const handleLogout = () => {
    userContext.setUser(null);
    localStorage.setItem('userData', null);
    navigate('/');
  };

  return (
    <HeaderWrapper>
        <Inner>
            <HeaderTitle bold>Preporučitelj</HeaderTitle>
            { userContext.getIsAuthenticated && <HeaderButtonWrapperTabs>
              <NavLink to='/'><TabDefault active={location.pathname === '/' ? "true" : "false"}>Preporuke</TabDefault></NavLink>
              <NavLink to='/ratedSongs'><TabDefault active={location.pathname === '/ratedSongs' ? "true" : "false"}>Pjesme</TabDefault></NavLink>
            </HeaderButtonWrapperTabs>  }
            { userContext.getIsAuthenticated && <HeaderButtonWrapper>
          <ButtonHeader height="100%" width="100%" onClick={handleLogout}>
            Odjava
          </ButtonHeader>
        </HeaderButtonWrapper>
        }
        </Inner>
    </HeaderWrapper>
  );
};

export default observer(Header);

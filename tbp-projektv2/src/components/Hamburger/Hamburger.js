import React, { useState } from 'react';
import { useLocation } from 'react-router-dom';
import {
  HamburgerWrapper,
  HamburgerItem,
  HamburgerLine,
  HamburgerOpened,
} from './HamburgerStyle';

const routes = [
  {
    name: 'Preporuke',
    link: '/',
  },
  {
    name: 'Omiljeni žanrovi',
    link: '/likedGenres',
  }
];

const Hamburger = () => {
  const [open, setOpen] = useState(false);
  const location = useLocation();

  return (
    <>
      <HamburgerWrapper isOpened={open} onClick={() => setOpen(!open)}>
        <HamburgerLine />
        <HamburgerLine />
        <HamburgerLine />
      </HamburgerWrapper>
      {open && (
        <HamburgerOpened>
          {routes.map((route) => (
            <HamburgerItem
              isCurrent={JSON.stringify(location.pathname === route.link)}
              to={route.link}>
              {route.name}
            </HamburgerItem>
          ))}
        </HamburgerOpened>
      )}
    </>
  );
};

export default Hamburger;

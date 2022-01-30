import React from 'react';
import { MainWrapper } from './MainStyle';

const Main = (props) => {
  return <MainWrapper>{props.children}</MainWrapper>;
};

export default Main;

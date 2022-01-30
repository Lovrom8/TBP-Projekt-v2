import React from 'react';
import { Navigate } from 'react-router-dom';
import { useLocation } from 'react-router-dom';
import userContext from '../../context/userContext';

export default function PublicRoute ({ children }) {  
    const location = useLocation();

    console.log(userContext);
    console.log('logged' + userContext.getIsAuthenticated);

    return userContext.getIsAuthenticated === false ? 
    children 
    : 
    <Navigate to="/" replace  state={{ path: location.pathname }} />;
}

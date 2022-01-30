import React from 'react';
import { Navigate } from 'react-router-dom';
import { useLocation } from 'react-router-dom';
import userContext from '../../context/userContext';

export default function ProtectedRoute ({ children }) {  
  const location = useLocation();

  return userContext.getIsAuthenticated === true ? 
      children : 
      <Navigate to="/login" replace state={{ path: location.pathname }} />;
}

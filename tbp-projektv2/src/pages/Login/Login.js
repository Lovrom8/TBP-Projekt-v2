import React, { useState, useEffect } from 'react';
import { useFormik } from 'formik';
import * as Yup from 'yup';

import userContext from '../../context/userContext';
import { observer } from 'mobx-react';
import { useNavigate } from 'react-router-dom';
import LogUserIn from './LogUserIn';

import {
  BackgroundBig,
  BackgroundMedium,
  BackgroundSmall,
  LoginPageWrapper,
  ButtonLogin,
  LoginForm,
  Logo,
  AnimatedPlaceholder,
  InputArea,
  InputField,
  MessageError,
  ButtonRedirect
} from './LoginStyle';
import { ButtonHeader } from '../../components/Header/HeaderStyle';

const Login = () => {
    const [isLoading, setIsLoading] = useState(false);
    const [errorMessage, setErrorMessage] = useState('');
    const [isRequestFinished, setIsRequestFinished] = useState(false);
    const navigate = useNavigate();

    const handleRedirect = () => {
        navigate('/register');
    };
 
    useEffect(() => {
        if(userContext.getIsAuthenticated) {
          navigate('/');
        }
    });

    const formik = useFormik({
        initialValues: {
            email: '',
            password: '',
        },
        validationSchema: Yup.object({
            email: Yup.string()
              .email('Nevažeća email adresa')
              .required('Unesite email'),
            password: Yup.string()
              .min(8, 'Lozinka mora imati najmanje 8 znakova')
              .required('Unesite lozinku'),
          }),
          onSubmit: async (values) => {
            setIsLoading(true);
            setIsRequestFinished(false);
            setErrorMessage('');
      
            try {
              await LogUserIn({ ...values }, userContext.setUser);
      
              console.log("We're in :0");
              navigate('/');
            } catch (error) {
              switch (error[0]) {
                case 'U': {
                  setErrorMessage('Račun ne postoji!');
                  break;
                }
                case 'P': {
                  setErrorMessage('Lozinka nije valjana!');
                  break;
                }
                case '"': {
                  setErrorMessage('Provjerite još jedanput vaš mail!');
                  break;
                }
                default: {
                  setErrorMessage('Problem s bazom podataka!');
                  break;
                }
              }
            } finally {
              setIsLoading(false);
              setIsRequestFinished(true);
            }
          },
    });

    return (
      <LoginPageWrapper>
      <BackgroundBig />
      <BackgroundMedium />
      <BackgroundSmall />
      <LoginForm onSubmit={formik.handleSubmit}>
        <Logo />
        <InputArea>
          <InputField
            error={formik.errors.email}
            enabled={!isLoading}
            placeholder=" "
            type="email"
            {...formik.getFieldProps('email')}
          />
          <AnimatedPlaceholder>E-mail</AnimatedPlaceholder>
        </InputArea>
        <InputArea>
          <InputField
            error={formik.errors.password}
            enabled={!isLoading}
            placeholder=" "
            type="password"
            {...formik.getFieldProps('password')}
          />
          <AnimatedPlaceholder>Lozinka</AnimatedPlaceholder>
        </InputArea>
        {isRequestFinished && <MessageError>{errorMessage}</MessageError>}
        <ButtonLogin type="submit" value="Prijava" />
        <ButtonRedirect height="100%" width="100%" onClick={handleRedirect}>
           Registracija
        </ButtonRedirect>
      </LoginForm>
    </LoginPageWrapper>
    );
};

export default observer(Login);
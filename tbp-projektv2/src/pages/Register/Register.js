import React, { useState, useEffect } from 'react';
import { useFormik } from 'formik';
import * as Yup from 'yup';

import userContext from '../../context/userContext';
import { observer } from 'mobx-react';
import { useNavigate } from 'react-router-dom';
import RegisterUser from './RegisterUser';

import {
  BackgroundBig,
  BackgroundMedium,
  BackgroundSmall,
  RegisterPageWrapper,
  ButtonRegister,
  RegisterForm,
  Logo,
  AnimatedPlaceholder,
  InputArea,
  InputField,
  MessageError,
} from './RegisterStyle';

const Register = () => {
    const [isLoading, setIsLoading] = useState(false);
    const [errorMessage, setErrorMessage] = useState('');
    const [isRequestFinished, setIsRequestFinished] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        if(userContext.getIsAuthenticated) {
          navigate('/');
        }
    });

    const formik = useFormik({
        initialValues: {
            firstName: '',
            lastName: '',
            username: '',
            email: '',
            password: ''
        },
        validationSchema: Yup.object({
            username: Yup.string()
              .required("Unesite username"),
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
              await RegisterUser({ ...values });
      
              console.log("We're in :0");
              navigate('/');
            } catch (error) {
              switch (error[0]) {
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
      <RegisterPageWrapper>
      <BackgroundBig />
      <BackgroundMedium />
      <BackgroundSmall />
      <RegisterForm onSubmit={formik.handleSubmit}>
        <Logo />
        <InputArea>
          <InputField
            enabled={!isLoading}
            placeholder=" "
            type="username"
            {...formik.getFieldProps('firstName')}
          />
          <AnimatedPlaceholder>Ime</AnimatedPlaceholder>
        </InputArea>
        <InputArea>
          <InputField
            error={formik.errors.lastName}
            enabled={!isLoading}
            placeholder=" "
            type="username"
            {...formik.getFieldProps('lastName')}
          />
          <AnimatedPlaceholder>Prezime</AnimatedPlaceholder>
        </InputArea>
        <InputArea>
          <InputField
            error={formik.errors.username}
            enabled={!isLoading}
            placeholder=" "
            type="username"
            {...formik.getFieldProps('username')}
          />
          <AnimatedPlaceholder>Korisničko ime</AnimatedPlaceholder>
        </InputArea>
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
        <ButtonRegister type="submit" value="Registracija" />
      </RegisterForm>
    </RegisterPageWrapper>
    );
};

export default observer(Register);
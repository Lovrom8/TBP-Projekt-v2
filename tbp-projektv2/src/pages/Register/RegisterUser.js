import { registerUser } from '../../api/register';

const RegisterUser = async ({ firstName, lastName, username, email, password }) => {
  var response, responseData = null;
  try {
    responseData = await registerUser({ firstName, lastName, username, email, password  });
    response = responseData.data;

  } catch (ex) {
    if (response) throw response;
    else throw new Error('Something went terribly wrong! Please try again.');
  }
};

export default RegisterUser;

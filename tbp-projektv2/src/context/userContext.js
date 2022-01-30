import { makeAutoObservable } from 'mobx';

class UserContext {
  user = null;

  constructor() {
    makeAutoObservable(this);
  }

  setUser = (newUser) => (this.user = newUser);

  get getUser() {
    return this.user;
  }

  get getJWT() {
    return this.user ? this.user.authToken : '';
  }

  get getUserEmail() {
    return this.user ? this.user.email : '';
  }

  get getIsAuthenticated() {
    return this.user !== null;
  }

  get getJWTExpired() {
    return this.user && this.user.jwtExp < new Date().getTime();  
  }
}

const userContext = new UserContext();
export default userContext;

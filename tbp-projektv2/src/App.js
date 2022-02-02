import './App.css';
import Recommendations from './pages/Recommendations/Recommendations';
import LikedGenres from './pages/LikedGenres/LikedGenres';
import Header from './components/Header/Header';
import Main from './components/Main/Main';
import RatedSongs from './pages/RatedSongs/RatedSongs';
import RateSong from './pages/RateSong/RateSong';

import { Routes, Route} from 'react-router-dom';
import ProtectedRoute from './components/Routes/ProtectedRoute';
import PublicRoute from './components/Routes/PublicRoute';
import Login from './pages/Login/Login';
import Register from './pages/Register/Register';

function App() {
  return (
    <>
      <Header />
      <Main>
        <Routes>
          <Route path="/register" element={<PublicRoute><Register /></PublicRoute>} />
          <Route path="/login" element={<PublicRoute><Login /></PublicRoute>} />
          <Route path="/likedGenres" element={<ProtectedRoute><LikedGenres /></ProtectedRoute>} />
          <Route path="/ratedSongs" element={<ProtectedRoute><RatedSongs /></ProtectedRoute>} />
          <Route path="/editRating" element={<ProtectedRoute><RateSong /></ProtectedRoute>} />
          <Route path="/" element={<ProtectedRoute><Recommendations /></ProtectedRoute>} />
        </Routes>
      </Main>
    </>
  );
}

export default App;

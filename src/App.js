
import { BrowserRouter, Router, Route, Routes, Switch } from 'react-router-dom';
import Login from './Pages/Login';
import {SignUp} from './Pages/SignUp';
import Navbar from './Components/Navbar'


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path = "/login" element={<Login></Login>}>
        </Route>
          <Route path="/" element={<Navbar/>}></Route>
        <Route path = "/signup" element={<SignUp></SignUp>}>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;

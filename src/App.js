
import { BrowserRouter, Router, Route, Routes, Switch } from 'react-router-dom';
import Login from './Pages/Login';
import {SignUp} from './Pages/SignUp';


function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path = "/" element={<Login></Login>}>
        </Route>
        <Route path = "/signup" element={<SignUp></SignUp>}>
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;

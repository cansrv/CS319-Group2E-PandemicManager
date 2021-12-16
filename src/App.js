import { BrowserRouter, Router, Route, Routes, Switch } from 'react-router-dom';
import Login from './Pages/Login';
import { SignUp } from './Pages/SignUp';
import StaffCampusPage from './Pages/StaffCampusPage';
import StudentHomePage from "./Pages/StudentHomePage"
import InstructorCampusPage from './Pages/InstructorCampusPage';
import Navbar from './components/navbar'


function App() {
    return ( <
            BrowserRouter >
            <
            Routes >
            <
            Route path = "/login"
            element = { < Login > < /Login>}> <
                /Route> <
                Route path = "/"
                exact element = { < InstructorCampusPage / > } > < /Route> <
                Route path = "/signup"
                element = { < SignUp > < /SignUp>}> <
                    /Route> <
                    /Routes> <
                    /BrowserRouter>
                );
            }

            export default App;
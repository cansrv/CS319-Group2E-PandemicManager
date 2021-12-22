import { BrowserRouter, Router, Route, Routes, Switch } from 'react-router-dom';
import Login from './Pages/Login';
import { SignUp } from './Pages/SignUp';
import StaffCampusPage from './Pages/StaffCampusPage';
import StudentHomePage from "./Pages/StudentHomePage"
import InstructorCoursePage from './Pages/InstructorCoursePage';
import InstructorCampusPage from './Pages/InstructorCampusPage';
import Navbar from './components/navbar'
import StudentTestsPage from "../src/Pages/StudentTestsPage"


function App() {
    return ( 
        <BrowserRouter>
            <Routes>
                <Route path = "/login" element = { <Login></Login>}></Route> 
                <Route path = "/studentHomePage"exact element = { <StudentHomePage/>}></Route> 
                <Route path = "/signup" element = { <SignUp > </SignUp>}></Route>
            </Routes> 
        </BrowserRouter>
                );
            }

            export default App;
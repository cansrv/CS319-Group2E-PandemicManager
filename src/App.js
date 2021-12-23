import { BrowserRouter, Router, Route, Routes, Switch, Navigate, useHis } from 'react-router-dom';
import Login from './Pages/Login';
import { SignUp } from './Pages/SignUp';
import StaffCampusPage from './Pages/StaffCampusPage';
import StudentHomePage from "./Pages/StudentHomePage"
import StudentCoursesPage from './Pages/StudentCoursesPage';
import InstructorCampusPage from './Pages/InstructorCampusPage';
import Navbar from './components/navbar'
import StudentTestsPage from "../src/Pages/StudentTestsPage"
import GroupsPage from './Pages/GroupsPage';
import InstructorCoursesPage from './Pages/InstructorCoursesPage';
import StudentMyProfile from "./Pages/StudentMyProfile"
import {useState} from "react"



function App() {

    const [userType, setUserType] = useState("student")
    const [loggedIn, setLoggedIn] = useState(false)

    return ( 
        <BrowserRouter>
            <Routes>
                <Route path = "/signup" element = {<SignUp></SignUp>}></Route>
                <Route path = "/login" element = {<Login></Login>}></Route> 
                <Route path = "/studentHomePage" element = {!loggedIn ? <Navigate to="/login"/> : <StudentHomePage/>}></Route>
                <Route path= "/studentCoursesPage"  element={!loggedIn ? <Navigate to="/login"/> : <StudentCoursesPage/>}></Route>
                <Route path="/instructorCoursesPage" element={!loggedIn ? <Navigate to="/login"/> : <InstructorCoursesPage />}></Route>
                <Route path="/instructorCampusPage" element={!loggedIn ? <Navigate to="/login"/> : <InstructorCampusPage />}></Route>
                <Route path="/studentMyProfilePage" element={!loggedIn ? <Navigate to="/login"/> : <StudentMyProfile />}></Route>
                <Route path = "/" element = {!loggedIn ? <Navigate to="/login"/> : <GroupsPage></GroupsPage>}></Route>
            </Routes>
        </BrowserRouter>

                );
            }

            export default App;
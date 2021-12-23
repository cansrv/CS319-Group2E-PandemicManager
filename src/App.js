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
                <Route path = "/" element = {<Login></Login>}></Route> 
                <Route path = "/studentHomePage" element = {!loggedIn ? <Navigate to="/"/> : <StudentHomePage/>}></Route>
                <Route path= "/studentCoursesPage"  element={!loggedIn ? <Navigate to="/"/> : <StudentCoursesPage/>}></Route>
                <Route path="/instructorCoursesPage" element={!loggedIn ? <Navigate to="/"/> : <InstructorCoursesPage />}></Route>
                <Route path="/instructorCampusPage" element={!loggedIn ? <Navigate to="/"/> : <InstructorCampusPage />}></Route>
                <Route path="/studentMyProfilePage" element={!loggedIn ? <Navigate to="/"/> : <StudentMyProfile />}></Route>
                <Route path = "/groupsPage" element = {!loggedIn ? <Navigate to="/"/> : <GroupsPage></GroupsPage>}></Route>
            </Routes>
        </BrowserRouter>

                );
            }

            export default App;
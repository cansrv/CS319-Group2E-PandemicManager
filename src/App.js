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
                <Route path = "/home" element = {!loggedIn ? <Navigate to="/"/> : <StudentHomePage/>}></Route>
                <Route path= "/courses"  
                element={!loggedIn ? <Navigate to="/"/> : 
                        (userType === "student" ? <StudentCoursesPage userType={userType}/> 
                        : <InstructorCoursesPage userType={userType}/>)}>
                </Route>
                <Route path="/campus" element={!loggedIn ? <Navigate to="/"/> : (userType === "student" ? <StaffCampusPage userType={userType}/> 
                        : <InstructorCampusPage userType={userType}/>)}></Route>
                <Route path="/myProfile" element={!loggedIn ? <Navigate to="/"/> : <StudentMyProfile userType={userType}/>}></Route>
                <Route path="/tests" element={!loggedIn ? <Navigate to="/"/> : <StudentTestsPage userType={userType}/>}></Route>
                <Route path="/groups" element={!loggedIn ? <Navigate to="/"/> : <GroupsPage userType={userType}/>}></Route>
            </Routes>
        </BrowserRouter>

                );
            }

            export default App;
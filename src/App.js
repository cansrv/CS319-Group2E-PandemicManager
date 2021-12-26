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
import {createStore} from "redux";
import {Provider} from "react-redux"
import reducer from "../src/redux/reducer"
import {state_prototype} from "../src/redux/redux_state"
import ExamsPage from './Pages/ExamsPage';
import {connect} from "react-redux"

function App({loggedIn, accountType}) {
    

    return (
        
        <BrowserRouter>
            <Routes>
                <Route path = "/signup" element = {<SignUp></SignUp>}></Route>
                <Route path = "/" element = {<Login></Login>}></Route> 
                <Route path = "/home" element = {false ? <Navigate to="/"/> : <StudentHomePage/>}></Route>
                <Route path= "/courses"  
                element={!loggedIn ? <Navigate to="/"/> :
                        (accountType === "student" ? <StudentCoursesPage />
                        : accountType === "staff" ? <StudentHomePage/> : <InstructorCoursesPage />)}>
                </Route>
                <Route path="/campus" element={!loggedIn ? <Navigate to="/"/> : (accountType === "staff" ? <StaffCampusPage />
                        : <InstructorCampusPage />)}></Route>
                <Route path="/myProfile" element={!loggedIn ? <Navigate to="/"/> : <StudentMyProfile />}></Route>
                <Route path="/tests" element={!loggedIn ? <Navigate to="/"/> : <StudentTestsPage />}></Route>
                <Route path="/groups" element={!loggedIn ? <Navigate to="/"/> : <GroupsPage />}></Route>
                <Route path="/exams" element={!loggedIn ? <Navigate to="/"/> : <ExamsPage />}></Route>
            </Routes>
        </BrowserRouter>
        
                );
            }

const mapStateToProps = state => {
    return {
        loggedIn: state.loggedIn,
        accountType: state.accountType,
    };
}
export default connect(mapStateToProps)(App);
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

function App() {
    const store = createStore(reducer, state_prototype ,window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__());

    return (
        <Provider store={store}>
        <BrowserRouter>
            <Routes>
                <Route path = "/signup" element = {<SignUp></SignUp>}></Route>
                <Route path = "/" element = {<Login></Login>}></Route> 
                <Route path = "/home" element = {false ? <Navigate to="/"/> : <StudentHomePage/>}></Route>
                <Route path= "/courses"  
                element={false ? <Navigate to="/"/> : 
                        (store.getState().accountType === "student" ? <StudentCoursesPage />
                        : store.getState().accountType === "staff" ? <StudentHomePage/> : <InstructorCoursesPage />)}>
                </Route>
                <Route path="/campus" element={false ? <Navigate to="/"/> : (store.getState().accountType === "staff" ? <StaffCampusPage />
                        : <InstructorCampusPage />)}></Route>
                <Route path="/myProfile" element={false ? <Navigate to="/"/> : <StudentMyProfile />}></Route>
                <Route path="/tests" element={false ? <Navigate to="/"/> : <StudentTestsPage />}></Route>
                <Route path="/groups" element={false ? <Navigate to="/"/> : <GroupsPage />}></Route>
                <Route path="/exams" element={false ? <Navigate to="/"/> : <ExamsPage />}></Route>
            </Routes>
        </BrowserRouter>
        </Provider>
                );
            }

export default App;
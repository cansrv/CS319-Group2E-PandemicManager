import { BrowserRouter, Router, Route, Routes, Switch } from 'react-router-dom';
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


function App() {
    return ( 
        <BrowserRouter>
            <Routes>
                <Route path = "/login" exact element = { <Login></Login>}></Route> 
                <Route path = "/studentHomePage" element = { <StudentHomePage/>}></Route>
                <Route path= "/studentCoursesPage"  element={<StudentCoursesPage />}></Route>
                <Route path="/instructorCoursesPage" element={<InstructorCoursesPage />}></Route>
                <Route path = "/signup" element = { <SignUp > </SignUp>}></Route>
                <Route path = "/" element = {<GroupsPage></GroupsPage>}></Route>
            </Routes>
        </BrowserRouter>

                );
            }

            export default App;
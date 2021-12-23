import React from 'react'
import "../css/Sidebar.css"
import HomeIcon from "../images/home.png"
import PersonIcon from "../images/person_outline.png"
import CoursesIcon from "../images/courses.png"
import TestsIcon from "../images/tests.png"
import CampusIcon from "../images/Icon.png"
import LogoutIcon from "../images/logout.png"
import { Link } from 'react-router-dom'
const Sidebar = () => {
    return (
        <div className="sidebar">
            <aside className="d-flex flex-column">
            <Link to="/home"  className="text-decoration-none text-white">
                <section className="sidebar-link mb-1 mt-1 hover-effect"> <img src={HomeIcon} className="ml-lg-3 sidebar-icon"/><span className="ml-lg-3 ml-2">Home</span></section>
            </Link>
            <Link to="/myProfile" className="text-decoration-none text-white">
                <section className="sidebar-link mb-1 hover-effect"><img src={PersonIcon} className="sidebar-icon ml-lg-3"/><span className="ml-lg-3 ml-2">Profile</span></section>
            </Link>
            <Link to="/tests" className="text-decoration-none text-white">
                <section className="sidebar-link mb-1 hover-effect"><img src={TestsIcon} className="ml-lg-3 sidebar-icon"/><span className="ml-lg-3 ml-2">Tests</span></section>
            </Link>
            <Link to="/campus" className="text-decoration-none text-white">
                <section className="sidebar-link mb-1 hover-effect"><img src={CampusIcon} className="ml-lg-3 sidebar-icon"/><span className="ml-lg-3 ml-2">Campus</span></section>
            </Link>
            <Link to="/courses" className="text-decoration-none text-white">
                <section className="sidebar-link mb-1 hover-effect flex-1"><img src={CoursesIcon} className="ml-lg-3 sidebar-icon"/><span className="ml-lg-3 ml-2">Courses</span></section>
            </Link>
            <Link to="/" className="text-decoration-none text-white">
                <section className="sidebar-link hover-effect logout-div"><img src={LogoutIcon} className="sidebar-icon ml-lg-3"/><span className="ml-lg-3 ml-2">Logout</span></section>
            </Link>
            </aside>
        </div>
    )
}

export default Sidebar
import {useState} from "react"
import Navbar from "../components/navbar"
import '../css/StaffCampusPage.css'
import Sidebar from "../components/Sidebar"
import { Link } from "react-router-dom"
import {connect} from "react-redux"

const StaffCampusPage = ({status, report}) => {
        return (
            <>
                    <div className='container staffCampusPg'>
                            <div className='row'>
                                    <Navbar/>
                            </div>

                            <div className = 'row align-items-between'>
                                    <div className="d-none d-md-block col-md-2 ">
                                            <Sidebar/>
                                    </div>
                                    <div className="col-12 col-md-10   bg-light ">
                                            <div className="row mt-4 d-flex justify-content-center">
                                                    <div className="col-12 col-sm-7 px-sm-1">
                                                            {(status !== true) ? (<div className="statusNotRisky d-flex text-center justify-content-center align-items-center">
                                                                    You Are Allowed On Campus
                                                            </div>) : (<div className="statusRisky d-flex text-center justify-content-center align-items-center">
                                                                    You Are  NOT Allowed On Campus
                                                            </div>)}
                                                    </div>
                                            </div>
                                            <div className="row mt-4 d-flex justify-content-center">
                                                    <p className = 'reportText'>Weekly Covid-19 Report</p>
                                            </div>
                                            {!(report.length === 0) ? (<div className="row covidTable table-responsive mb-4">
                                                    <table className="table table-striped  col-11 ml-4   ">
                                                            <thead className = 'text-center sticky-top bg-light'>
                                                            <tr>
                                                                    <th scope="col">Date</th>
                                                                    <th scope="col"># of Positive Students</th>
                                                                    <th scope="col"># of Positive Staff</th>
                                                                    <th scope="col"># of Recovered</th>
                                                            </tr>
                                                            </thead>
                                                            <tbody>
                                                            {report.map((report) => {
                                                                    return(
                                                                        <tr className = "text-center">
                                                                                <td>{report.date}</td>
                                                                                <td>{report.posStudents}</td>
                                                                                <td>{report.posStaff}</td>
                                                                                <td>{report.recovered}</td>
                                                                        </tr>
                                                                    )
                                                            })}
                                                            </tbody>
                                                    </table>
                                            </div>): (
                                                        <div className="row d-flex justify-content-center align-items-center covidTable  mb-4">
                                                                <h1> No Reports Available</h1>
                                                        </div>

                                            )
                                            }
                                            <div className="row d-flex justify-content-center">
                                                    <div className="col-12 col-sm-4 mb-2">
                                                            <Link to="/groups">
                                                                    <button className='groupsButton px-5 py-3'>
                                                                    Groups
                                                            </button>
                                                            </Link>
                                                           
                                                    </div>
                                            </div>


                                    </div>

                            </div>
                    </div>
            </>
        )
}

const mapStateToProps = state => {
        return {
                status: state.isAllowedOnCampus,
                report: state.weeklyReport
        };
}

export default connect(mapStateToProps)(StaffCampusPage)
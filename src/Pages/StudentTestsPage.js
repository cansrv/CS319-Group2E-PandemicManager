import {useState} from "react"
import Navbar from "../components/navbar"
import '../css/StudentTestsPage.css'
import Sidebar from "../components/Sidebar"
import QR from "../images/QR2 1.png"
import { connect } from "react-redux"

const StudentTestsPage = ({ tests}) => {
    

    return (
        <div className='container'>
            <div className='row'>
                <Navbar/>
            </div>

            <div className = 'row align-items-between'>
                <div className="d-none d-lg-block col-md-2">
                    <Sidebar/>
                </div>
                <div className="col-lg-10 col-md-12 bg-light">
                    <div className="row">
                    <div className="col-lg-7">
                        <div className="row mt-5 mb-2 d-flex justify-content-center">
                            <p className="past-result-header text-center">Your Past Test Results</p>
                        </div>
                        <div className="table-responsive ml-lg-3 border-radius">
                        <table className="table table-hover text-center green-border">
                            <thead>
                            <tr>
                                <th scope="col" className="table-header">Date</th>
                                <th scope="col" className="table-header">Type</th>
                                <th scope="col" className="table-header">Result</th>
                            </tr>
                            </thead>
                            <tbody>
                            {(tests.length !== 0)? tests.map((test)=> {
                                return(
                                    <tr>
                                        <td scope="row" className="table-data green-border">{test.date}</td>
                                        <td className="table-data green-border">{test.type}</td>
                                        <td className="table-data green-border">{test.result}</td>
                                    </tr>
                                )
                            }) : (
                                <tr>
                                    <td className="table-data no-past-test-msg" colspan="3">No Past Tests Found!</td>
                                </tr>
                            )}
                            </tbody>
                        </table>
                        </div>
                    </div>
                    <div className="col-lg-5 d-flex justify-content-center align-items-center mb-5 my-3">
                        <div className="btn test-appointment-button py-2 px-4 d-flex justify-content-center align-items-center">
                            <a href="https://stars.bilkent.edu.tr/accounts/login/" className="get-appointment-text">Get Test Appointment</a>
                        </div>
                    </div>
            </div>
            </div>
            </div>
            </div>
    )
}
const mapStateToProps = state => {
    return {
        tests: state.tests
    };
}
export default connect(mapStateToProps)(StudentTestsPage)
import {useState} from "react"
import Navbar from "../components/navbar"
import '../css/StudentTestsPage.css'
import Sidebar from "../components/Sidebar"
import QR from "../images/QR2 1.png"

const StudentTestsPage = () => {
    const [isCovid, setIsCovid] = useState(true)
    const [tests, setTests] = useState( [
        {
            date: "27.11.2021",
            type: "Diagnovir",
            result: "POSITIVE",
        },
        {
            date: "12.09.2021",
            type: "Diagnovir",
            result: "NEGATIVE",
        },
        {
            date: "11.07.2021",
            type: "PCR",
            result: "NEGATIVE",
        },
        {
            date: "23.04.2021",
            type: "PCR",
            result: "NEGATIVE",
        }
    ])

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
                            {tests !== []? tests.map((test)=> {
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
                        <div className="test-appointment-button py-2 px-4 d-flex justify-content-center align-items-center">
                            <p className="get-appointment-text">Get Test Appointment</p>
                        </div>
                    </div>
            </div>
            </div>
            </div>
            </div>
    )
}

export default StudentTestsPage;
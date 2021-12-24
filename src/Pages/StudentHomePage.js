import {useState} from "react"
import Navbar from "../components/navbar"
import '../css/StudentHomePage.css'
import Sidebar from "../components/Sidebar"
import QR from "../images/QR2 1.png"

const StudentHomePage = () => {
    const [isCovid, setIsCovid] = useState(false)
    const [remainingDays, setremainingDays] = useState(10)
    const [isoStart, setIsoStart] = useState("27.11.2021")
    const [isoEnd, setIsoEnd] = useState("10.11.2021")
    const [hes, setHes] = useState("YFMN23")
    const [vaccinated, setVaccinated] = useState(true)
    const [recovered, setRecovered] = useState(false)
    const [negTest, setNegTest] = useState(false)
    const [campusStatus, setCampusStatus] = useState(true)

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
                            <div className="col-lg-6 col-12 ml-lg-4 ml-3">
                                <div className="covidInfo mt-5 ml-2">
                                    <div className="row">
                                        <div className="col-12 d-flex justify-content-center my-3">
                                        <img src={QR} className="qr"/>
                                        </div>
                                    </div>
                                    <div className="row">
                                        <div className="col- offset-2 col-lg-8">
                                            <h1 className="covidInfoText">HES Code: {hes}</h1>
                                            <h1 className="covidInfoText">Vaccinated: {vaccinated?"YES":"NO"}</h1>
                                            <h1 className="covidInfoText">Recovered: {recovered?"YES":"NO"}</h1>
                                            <h1 className="covidInfoText">Negative Test (48hrs): {negTest?"YES":"NO"}</h1>
                                            <h1 className="covidInfoText">Allowed on Campus: {campusStatus?"YES":"NO"}</h1>
                                        </div>
                                    </div>
                                </div>
                                <div className={`covid-situation-label text-center py-3 my-4 my-sm-5 ml-3 col-11  ${isCovid? "isCovid": "isNotCovid"}`}>
                                    {isCovid?"Covid Situation: RISKY" : "Covid Situation: NOT RISKY" }
                                </div>
                            </div>
                            <div className="col-lg-4 col-10 offset-1 offset-lg-0 d-flex my-md-1  flex-column justify-content-around">
                                <div className="row d-flex justify-content-center mx-auto">
                                    <div className="col-12 offset-lg-4">
                                        <div id="carouselExampleControls" className="carousel slide" data-ride="carousel">
                                            <div className="carousel-inner">
                                                <div className="carousel-item active class-info">
                                                    <h1 className="text-center "> Current 1</h1>
                                                    <h1 className="text-center"> Current Courses</h1>
                                                    <h1 className="text-center"> Current Courses</h1>
                                                    <h1 className="text-center"> Current Courses</h1>
                                                </div>
                                                <div className="carousel-item">
                                                    <h1 className="text-center"> Current 2</h1>
                                                </div>
                                                <div className="carousel-item">
                                                    <h1 className="text-center"> Current 3</h1>
                                                </div>
                                            </div>
                                            <button className="carousel-control-prev" type="button"
                                                    data-target="#carouselExampleControls" data-slide="prev">
                                                <span className="carousel-control-prev-icon bg-dark" aria-hidden="true"></span>
                                                <span className="sr-only">Previous</span>
                                            </button>
                                            <button className="carousel-control-next" type="button"
                                                    data-target="#carouselExampleControls" data-slide="next">
                                                <span className="carousel-control-next-icon bg-dark text-dark" aria-hidden="true"></span>
                                                <span className="sr-only">Next</span>
                                            </button>
                                        </div>
                                    </div>
                            </div>
                                <div className="row">
                                    <div className="col-lg-12 col-10 offset-1 py-3 px-4 offset-lg-2 my-3 my-sm-5 isolation-info d-flex flex-column">
                                        <p className="row iso-info-header m-auto">Isolation Information</p>
                                        {isCovid?(
                                            <>
                                            <div className="row px-3">Remaining Days: {remainingDays} Days </div>
                                            <div className="row px-3">Start of Isolation: {isoStart}</div>
                                            <div className="row px-3">End of Isolation: {isoEnd}</div>
                                            </>
                                        ) : <p className="mx-auto">You are allowed on campus!!</p>}
                                    </div>
                                </div>
                        </div>
                        </div>
                    </div>
                </div>
            </div>
    )
}

export default StudentHomePage;
import {useState} from "react"
import Navbar from "../components/navbar"
import '../css/StudentHomePage.css'
import Sidebar from "../components/Sidebar"
import QR from "../images/QR2 1.png"
import {connect} from "react-redux"


const StudentHomePage = ({
                             isCovid,
                             isoRemainingDays,
                             isolationStartDate,
                             isoEndDate,
                             HEScode,
                             vaccinated,
                             recovered,
                             negativeTest,
                             isAllowedOnCampus,
                            courses, 
                            accountType
                         }) => {
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
                                            <h1 className="covidInfoText">HES Code: {HEScode}</h1>
                                            <h1 className="covidInfoText">Vaccinated: {vaccinated?"YES":"NO"}</h1>
                                            <h1 className="covidInfoText">Recovered: {recovered?"YES":"NO"}</h1>
                                            <h1 className="covidInfoText">Negative Test (48hrs): {negativeTest?"YES":"NO"}</h1>
                                            <h1 className="covidInfoText">Allowed on Campus: {isAllowedOnCampus?"YES":"NO"}</h1>
                                        </div>
                                    </div>
                                </div>
                                <div className={`covid-situation-label text-center py-3 my-4 my-sm-5 ml-3 col-11  ${isCovid? "isCovid": "isNotCovid"}`}>
                                    {isCovid?"Covid Situation: RISKY" : "Covid Situation: NOT RISKY" }
                                </div>
                            </div>
                            <div className="col-lg-4 col-10 offset-1 offset-lg-0 d-flex my-md-1 flex-column justify-content-around">
                                <div className="row d-flex justify-content-center mx-auto">
                                    <div className="col-10">
                                        {accountType !== "staff" ? (<div id="carouselExampleControls" className="carousel slide" data-ride="carousel">
                                            <div className="carousel-inner ">
                                                {!(courses.length === 0 )? (
                                                <div className="carousel-item carouselCourse active class-info ">
                                                    <div className = "col-10 d-flex align-items-center flex-column">
                                                        <div className="row">
                                                            <h3 >Current Courses</h3>
                                                        </div>
                                                        <div className="row">
                                                            <h3>{courses[0].name}</h3>
                                                        </div>
                                                        <div className="row">
                                                            <h3>Section: {courses[0].section}</h3>
                                                        </div>
                                                        <div className="row">
                                                            <h3>{courses[0].instructor}</h3>
                                                        </div>
                                                        <div className="row">
                                                            <h3>{courses[0].type}</h3>
                                                        </div>
                                                    </div>
                                                </div>) : 
                                                
                                                    (<div className="carousel-item carouselCourse active class-info ">
                                                        <div className="col-10 d-flex align-items-center flex-column">
                                                            <div className="row">
                                                                <h3 >No Courses</h3>
                                                            </div>
                                                            
                                                        </div>
                                                    </div>
                                                        
                                                    )}
                                            {!(courses.length === 0 ) ? courses.slice(1).map((course=>{
                                                        return(
                                                            <div className="carousel-item carouselCourse class-info  ">
                                                            <div className="col-10 d-flex align-items-center flex-column">
                                                                <div className="row">
                                                                    <h3 >Current Courses</h3>
                                                                </div>
                                                                <div className="row">
                                                                    <h3>{course.name}</h3>
                                                                </div>
                                                                <div className="row">
                                                                    <h3>Section: {course.section}</h3>
                                                                </div>
                                                                <div className="row">
                                                                    <h3>{course.instructor}</h3>
                                                                </div>
                                                                <div className="row">
                                                                    <h3>{course.type}</h3>
                                                                </div>`
                                                            </div>
                                                            </div>
                                                        )
                                                    })): <div></div>}
                                                
                                            </div>
                                            <button className="carousel-control-prev bg" type="button"
                                                    data-target="#carouselExampleControls" data-slide="prev">
                                                <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                                                <span className="sr-only">Previous</span>
                                            </button>
                                        <button className="carousel-control-next bg" type="button"
                                                    data-target="#carouselExampleControls" data-slide="next">
                                                <span className="carousel-control-next-icon" aria-hidden="true"></span>
                                                <span className="sr-only">Next</span>
                                            </button>
                                        </div>) : 
                                        <div className="isolation-info d-flex justify-content-center mx-auto display-4 p-4">
                                            Welcome to PanMan!
                                        </div>
                                        }
                                    </div>
                            </div>
                                <div className="row">
                                    <div className="col-lg-12 col-10 offset-1 py-3 px-4 offset-lg-2 my-3 my-sm-5 isolation-info d-flex flex-column">
                                        <p className="row iso-info-header m-auto">Isolation Information</p>
                                        {isCovid?(
                                            <>
                                            <div className="row px-3">Remaining Days: {isoRemainingDays} Days </div>
                                            <div className="row px-3">Start of Isolation: {isolationStartDate}</div>
                                            <div className="row px-3">End of Isolation: {isoEndDate}</div>
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

const mapStateToProps = state => {
    return {
        isCovid: state.isCovid,
        isoRemainingDays: state.isoRemainingDays,
        isolationStartDate: state.isolationStartDate,
        isoEndDate: state.isoEndDate,
        HEScode: state.HEScode,
        vaccinated: state.vaccinated,
        recovered: state.recovered,
        negativeTest: state.negativeTest,
        isAllowedOnCampus: state.isAllowedOnCampus,
        courses: state.courses,
        accountType: state.accountType,
    };
}

export default connect(mapStateToProps)(StudentHomePage);


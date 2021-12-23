import {useState} from "react"
import Navbar from "../components/navbar"
import '../css/StudentMyProfile.css'
import Sidebar from "../components/Sidebar"
import PanManLogo from "../images/panman_logo.png"

const StudentMyProfilePage = () => {
    return (
        <div className='container'>
            <div className='row'>
                <Navbar/>
            </div>

            <div className='row align-items-between'>
                <div className="d-none d-lg-block col-md-2">
                    <Sidebar/>
                </div>
                <div className="col-lg-10 col-md-12 bg-light">
                    <div className="row">
                        <div className="col-6 d-flex flex-column justify-content-center align-items-center">
                            <div className="row">
                                <button className="editButton btn btn-lg py-3 px-5 mt-5">Edit HES Code</button>
                            </div>
                            <div className="row">
                                <button className="editButton btn btn-lg py-3 px-5 mt-5">Edit Vaccination Card</button>
                            </div>
                            <div className="row">
                                <button className="markSelfRiskyButton btn btn-lg py-3 px-5 mt-5">Mark Self as Risky</button>
                            </div>
                            <div className="row">
                            <form className="my-5">
                                <div className="form-row">
                                    <div className="col">
                                        <input type="text" className="form-search form-control-lg px-2" placeholder="Bilkent ID"/>
                                    </div>
                                    <div className="col">
                                        <button className="markSomeoneRiskyButton btn btn-lg px-3">Mark Someone Risky</button>
                                    </div>
                                </div>
                            </form>
                            </div>
                        </div>
                        <div className="col-6">
                            <div className="covid-info d-flex flex-column my-5">
                                <div className="row d-flex justify-content-center">
                                    <img src={PanManLogo} className="panman-logo-content mt-3"/>
                                </div>
                                <div className="row">
                                    <div className="col-11 mt-2">
                                        <div className="covid-info-content py-3 ml-3"> <span className="bold">Name:</span> Mehmet</div>
                                        <div className="covid-info-content py-3 ml-3"> <span className="bold">Surname:</span> Yılmaz</div>
                                        <div className="covid-info-content py-3 ml-3"> <span className="bold">Email:</span> mehmet.yılmaz@ug.bilkent.edu.tr</div>
                                        <div className="covid-info-content py-3 ml-3"> <span className="bold">Bilkent ID:</span> 21901784</div>
                                    </div>
                                </div>
                                <div className="row mt-4 ml-3 mb-5">
                                    {/*LINKS*/}
                                    <div className="vaccination-card-link">Display Vaccination Card</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default StudentMyProfilePage;
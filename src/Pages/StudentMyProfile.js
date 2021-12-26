import {useState, useRef} from "react"
import Navbar from "../components/navbar"
import '../css/StudentMyProfile.css'
import Sidebar from "../components/Sidebar"
import PanManLogo from "../images/panman_logo.png"
import {connect} from "react-redux"
import axios from "axios"

const StudentMyProfilePage = ({name, surname, email, ID, edit_HES_code, HEScode, mark_self_risky, isCovid, covidStatus}) => {
    const [input, setInput] = useState("")
    const [newHESCode, setNewHESCode] = useState("")

    const markSomeoneRisky = (e) => {
        e.preventDefault()
        axios.post("http://127.0.0.1:4567/markSomeoneRisky",
                {input : input}
            ).then((response) => {
                console.log("Response" + response)
                window.alert("You have marked " + input + " as Risky")
            }).catch(error => { console.error(error);
                window.alert("Database Error Group"); return Promise.reject(error); })
                setInput("")
    }

    const handleInput = (e) => {
        console.log(e.target.value)
        setInput(e.target.value)
    }

    const codeHandler = (value) => {
        console.log(value)
        setNewHESCode(value)
    }
    
    const editHandler = () => {
        if (newHESCode !== "") {
            edit_HES_code(newHESCode);
            var newInfo = {
                email: email,
                newHESCode: newHESCode
            }
            axios.post("http://127.0.0.1:4567/markSelfRisky",
                newInfo
            ).then((response) => {
                    console.log("Response" + response)
                }).catch(error => { 
                    console.error(error);
                    window.alert("Database Error HES Code Change"); 
                    return Promise.reject(error); 
                })
            setNewHESCode("")
            window.alert("Your HES Code have been changed")
        }
        else {
            window.alert("Please enter a valid HES Code")
        }
    }

    const handleRiskStatus = () => {
        mark_self_risky()
        axios.post("http://127.0.0.1:4567/markSelfRisky",
            {email: email}
        ).then((response) => {
            console.log("Response" + response)
        }).catch(error => { console.error(error);
            window.alert("Database Error Group"); return Promise.reject(error); })
        window.alert("You have marked yourself as RISKY")
    }

    return (
        <div className='container'>
            <div className='row'>
                <Navbar/>
            </div>

            <div className='row align-items-between'>
                <div className="d-none d-lg-block col-md-2">
                    <Sidebar/>
                </div>
                <div className="col-lg-10 col-12 bg-light">
                    <div className="row">
                        <div className="col-xl-6 col-12 col-lg-6 d-flex flex-column justify-content-center align-items-center">
                            <div className="row">
                                <button className="editButton btn btn-lg py-xl-3 px-xl-5 mt-5" data-toggle="modal" data-target="#editHESCodeModal">Edit HES Code</button>
                                <div className="modal fade" id="editHESCodeModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div className="modal-dialog modal-dialog-centered" role="document">
                                <div className="modal-content">
                                <div className="modal-header">
                                    <h5 className="modal-title" id="exampleModalLongTitle">Change HES Code:</h5>
                                    <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div className="modal-body">
                                    <form>
                                    <div className="form-group row d-flex justify-content-between">
                                        <label for="hesCode" className="col-sm-4 col-form-label">New HES Code:</label>
                                        <div className="col-sm-8">
                                        <input type="text" 
                                        className="form-control" 
                                        id="hesCode" 
                                        placeholder="New HES Code" 
                                        value={newHESCode}
                                        required
                                        onChange={(e) => codeHandler(e.target.value)}></input>
                                        </div>
                                    </div>
                                    </form>
                                </div>
                                <div className="modal-footer">
                                    <button type="button" className="btn btn-primary" onClick={() => editHandler()}>Change HES Code</button>
                                </div>
                                </div>
                            </div>
                            </div>
                            </div>
                            
                            <div className="row">
                                <button type="button" className="markSelfRiskyButton btn btn-lg py-xl-3 px-xl-5 mt-5" data-toggle="tooltip" data-placement="top" title="I sure hope what you are doing" 
                                onClick={() => handleRiskStatus()} disabled={((covidStatus !== "Positive") && (covidStatus !== "Risky")) }>Mark Self as Risky</button>
                            </div>
                            <div className="row">
                            <form className="my-5" >
                                <div className="row">
                                    <div className="col d-flex">
                                        <input value={input} type="text" className="form-search form-control-lg px-xl-2 mx-lg-auto mx-md-none mx-auto" placeholder="Bilkent ID or Full Name" onChange={(e) => {handleInput(e)}}/>
                                    </div>
                                    <div className="col d-flex">
                                        <button className="markSomeoneRiskyButton btn btn-lg px-xl-3 mx-lg-auto mt-lg-4 mt-xl-0 mx-md-none mx-auto mt-2 mt-md-none" onClick={(e) => markSomeoneRisky(e)}>Mark Someone Risky</button>
                                    </div>
                                </div>
                            </form>
                            </div>
                        </div>
                        <div className="col-xl-6 col-12 col-lg-6">
                            <div className="covid-info d-flex flex-column my-5">
                                <div className="row d-flex justify-content-center">
                                    <img src={PanManLogo} className="panman-logo-content mt-3"/>
                                </div>
                                <div className="row">
                                    <div className="col-11 mt-2">
                                       <div className="covid-info-content py-3 ml-3"> <span className="bold">Name:</span> {name}</div>
                                        <div className="covid-info-content py-3 ml-3"> <span className="bold">Surname:</span> {surname}</div>
                                        <div className="covid-info-content py-3 ml-3"> <span className="bold">Email:</span> {email}</div>
                                        <div className="covid-info-content py-3 ml-3"> <span className="bold">Bilkent ID:</span> {ID}</div>
                                        <div className="covid-info-content py-3 ml-3"> <span className="bold">HES Code:</span> {HEScode}</div>
                                    </div>
                                </div>
                                <div className="row mt-4 ml-3 mb-5">
                                    <div className="vaccination-card-link"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
const mapStateToProps = state => {
    return {
        name: state.name,
        surname: state.surname,
        email: state.email,
        ID: state.id,
        HEScode: state.HEScode,
        isCovid: state.isCovid,
        covidStatus: state.covidStatus
    };
}
const mapDispatchToProps = (dispatch) => {
    return {
        edit_HES_code: (HEScode) => dispatch({type : "EDIT_HES_CODE", payload: {HEScode: HEScode} }),
        mark_self_risky: () => dispatch({type : "MARK_SELF_RISKY"}),
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(StudentMyProfilePage);
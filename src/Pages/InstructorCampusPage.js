import {useState} from "react"
import Navbar from "../components/navbar"
import '../css/InstructorCampusPage.css'
import report from "../components/weeklyReportData"
import exams from "../components/examData"


const InstructorCampusPage = () => {
	const [status, setStatus] = useState(false)
	const [addedParticipants, setAddedParticipants] = useState([])

    const [name, setName] = useState("")
    const [date, setDate] = useState("")
    const [examType, setExamType] = useState("")
    const [examPlace, setExamPlace] = useState("")
    const [newParticipant, setNewParticipant] = useState("");

    const addParticipant = () => {
        console.log(newParticipant, " will be added")
        if(addedParticipants.includes(newParticipant)) {
            window.alert("This participant already exists in this exam")
            console.log(newParticipant, " already exists")
        }
        else if (newParticipant == "") {
            window.alert("Invalid Participant ID")
        }
        else {
            setAddedParticipants([...addedParticipants, newParticipant])
            console.log(newParticipant, " is added")
        }
    }

    const removeParticipant = (participant) => {
        var filteredArray = addedParticipants.filter(function(item) {
            return item !== participant
        })
        console.log(filteredArray);
        setAddedParticipants(filteredArray);
        console.log(participant, "is removed");
    }

    const nameHandler = (value) => {
        console.log(value);
        setName(value);
    };
    const examPlaceHandler = (value) => {
        console.log(value);
        setExamPlace(value);
    };
    
    const dateHandler = (value) => {
        console.log(value);
        setDate(value);
    };
    const newParticipantHandler = (value) => {
        console.log(value);
        setNewParticipant(value);
    };

	const createExam = () => {

	}
	return (
		<>
			<div className='container staffCampusPg'>
				<div className='row'>
					<Navbar />
				</div>

				<div className='row align-items-between'>
					<div className="d-none d-md-block col-md-2  bg-dark">
						{/*SIDEBAR*/}
					</div>
					<div className="col-12 col-md-10   bg-light ">
						<div className="row mt-4 d-flex justify-content-between ml-5">
							<div className="col-12 col-sm-8 px-sm-1">
								{status ? (<div className="statusNotRisky d-flex text-center justify-content-center align-items-center">
									You Are Allowed On Campus
								</div>) : (<div className="statusRisky d-flex text-center justify-content-center align-items-center">
									You Are  NOT Allowed On Campus
								</div>)}
							</div>
							<div className="d-none d-sm-block col-12 col-sm-4">
								<button className="btn createExam text-center d-flex justify-content-center align-items-center" data-toggle="modal" data-target="#createExamModal">
									Create Exam
								</button>
								<div className="modal fade" id="createExamModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div className="modal-dialog modal-dialog-centered" role="document">
                                <div className="modal-content">
                                <div className="modal-header">
                                    <h5 className="modal-title" id="exampleModalLongTitle">Create an Exam</h5>
                                    <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div className="modal-body">
                                    <form>
                                    <div className="form-group row d-flex justify-content-between">
                                        <label for="nameInput" className="col-sm-4 col-form-label">Exam Name</label>
                                        <div className="col-sm-8">
                                        <input type="text" 
                                        className="form-control" 
                                        id="nameInput" 
                                        placeholder="Group Name" 
                                        value={name}
                                        required
                                        onChange={(e) => nameHandler(e.target.value)}></input>
                                        </div>
                                    </div>
                                    <div className="form-group row d-flex justify-content-between">
                                        <label for="placeInput" className="col-sm-4 col-form-label">Place</label>
                                        <div className="col-sm-8">
                                        <input type="text" 
                                        className="form-control" 
                                        id="typeInput" 
                                        placeholder="Place" 
                                        value={examPlace}
                                        required
                                        onChange={(e) => examPlaceHandler(e.target.value)}></input>
                                        </div>
                                    </div>
                                    <div className="form-group row d-flex justify-content-between">
                                        <label for="idInput" className="col-sm-4 col-form-label">Participant ID</label>
                                        <div className="col-sm-5">
                                        <input type="number" className="form-control" id="idInput" 
                                        placeholder="Participant ID"
                                        value={newParticipant}
                                        required
                                        onChange={(e) => newParticipantHandler(e.target.value)}></input>
                                        </div>
                                        <button className="btn btn-success col-sm-2 mr-3" type="button" onClick={() => addParticipant()}>Add</button>
                                    </div>
									
                                    <div className="form-group row d-flex justify-content-between">
                                        <label for="dateInput" className="col-sm-4 col-form-label">Date</label>
                                        <div className="col-sm-8">
                                        <input type="date" className="form-control" id="dateInput" placeholder="Date"
                                        value={date}
                                        onChange={(e) => dateHandler(e.target.value)}></input>
                                        </div>
                                    </div>
                                    </form>
                                    <div className="row">
                                        <ul className="list-group w-100 mx-3 addedParticipantsList">
                                        {addedParticipants.length ? 
                                        addedParticipants.map((participant) => {
                                            return (
                                                <li className="list-group-item d-flex justify-content-between align-items-center"> 
												    <span>{participant}</span> 
                                                    <span>
                                                        <button className="btn btn-danger" type="button"
                                                        onClick={() => removeParticipant(participant)}>Remove</button>
                                                    </span>
												</li>
                                            )
                                        }) : (
                                            <div>
                                                No Participants Added
                                            </div>
                                        )}
                                        </ul>
                                    </div>
                                </div>
                                <div className="modal-footer">
                                    <button type="button" className="btn btn-primary" onClick={() => createExam()}>Create Group</button>
                                </div>
                                </div>
                            </div>
                            </div>
							</div>	
						</div>
						<div className="row mt-4 d-flex justify-content-center">
							<p className='reportText'>Weekly Covid-19 Report</p>
						</div>
						<div className="row covidTable table-responsive mb-4"> 
							<table className="table table-striped  col-11 ml-4   ">
								<thead className='text-center sticky-top bg-light'>
									<tr>
										<th scope="col">Date</th>
										<th scope="col"># of Positive Students</th>
										<th scope="col"># of Positive Staff</th>
										<th scope="col"># of Recovered</th>
									</tr>
								</thead>
								<tbody>
									{report.map((report) => {
										return (
											<tr className="text-center">
												<td>{report.date}</td>
												<td>{report.posStudents}</td>
												<td>{report.posStaff}</td>
												<td>{report.recovered}</td>
											</tr>
										)
									})}
								</tbody>
							</table>
						</div>
						<div className="row mt-4 d-flex justify-content-center">
							<p className='reportText'>Exam Information</p>
						</div>
						<div className="row examTable table-responsive mb-4"> 
							<table className="table table-striped  col-11 ml-4   ">
								<thead className='text-center sticky-top bg-light'>
									<tr>
										<th scope="col">Date</th>
										<th scope="col">Information</th>
										<th scope="col">Places</th>
										<th scope="col">Type</th>
									</tr>
								</thead>
								<tbody>
									{exams.map((exams) => {
										return (
											<tr className="text-center">
												<td>{exams.date}</td>
												<td>{exams.information}</td>
												<td>{exams.places}</td>
												<td>{exams.type}</td>
											</tr>
										)
									})}
								</tbody>
							</table>
						</div>
						
					</div>
				</div>
			</div>
		</>
	)
}

export default InstructorCampusPage
import Navbar from "../components/navbar"
import Sidebar from "../components/Sidebar"
import "../css/GroupsPage.css"
import { useState } from "react"
import {connect} from "react-redux"

const ExamsPage = ({add_exam, remove_exam, exams, courses, name, surname, email, accountType}) => {
    
	
	const [addedParticipants, setAddedParticipants] = useState([])
    const [date, setDate] = useState("")
    const [examType, setExamType] = useState("")
    const [examBuilding, setExamBuilding] = useState("")
    const [examRoom, setExamRoom] = useState("")
    const [newParticipant, setNewParticipant] = useState("");
    const [examClassification, setExamClassification] = useState("");
    const [examCourse, setExamCourse] = useState("");

	const createExam = () => {
		if (date !== "" && examType !== "" && examBuilding !== "" && examRoom !== "" && addedParticipants.length && examClassification !== "" && examCourse !== "") {
			var examPlace = examBuilding + "-" + examRoom
            var examName = examCourse + " " + examClassification
            var fullName = name + " " + surname
			var newExam = {
                id: new Date().getTime().toString(),
				course: examCourse,
				classification: examClassification,
                name: examName,
				instructorMail: email,
                instructorName: fullName,
				type: examType,
				participants: addedParticipants,
				place: examPlace,
                date: date
			}
			add_exam(newExam)
			window.alert("A new exam is added")
			setDate("")
			setExamType("")
			setExamBuilding("")
			setExamRoom("")
			setNewParticipant("")
			setExamClassification("")
			setExamCourse("")
		}
		else {
			window.alert("All fields are required to be filled.")
		}
	}

    const deleteExam = (exam) => {
        var filteredArray = exams.filter(function(item) {
            return item.id !== exam.id
    })
        console.log(filteredArray);
        remove_exam(filteredArray);
        console.log(exam.name, "is removed");
    }

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

	const examBuildingHandler = (value) => {
		console.log(value.toUppercase());

        setExamBuilding(value.toUppercase());
	}
	const examRoomHandler = (value) => {
		console.log(value);
        setExamRoom(value);
	}
    
    const dateHandler = (value) => {
        console.log(value);
		var formattedDate =  value.substring(8) + "/" + value.substring(5,7) + "/" + value.substring(0, 4) 
		console.log(formattedDate);
        setDate(formattedDate);
    };

    const newParticipantHandler = (value) => {
        console.log(value);
        setNewParticipant(value);
    };

	const examTypeHandler = (value) => {
		console.log(value);
		setExamType(value);
	}

	const examClassificationHandler = (value) => {
		console.log(value);
		setExamClassification(value);
	}

	const examCourseHandler = (value) => {
		console.log(value);
		setExamCourse(value);
	}



    return (
        <>
			<div className="container">
				<div className="row">
					<Navbar/>
				</div>
                <div className='row align-items-between'>
					<div className="d-none d-md-block col-md-2">
						<Sidebar></Sidebar>
					</div>
					<div className="col-12 col-md-10 bg-light contentContainer">
                        <div className="row col-12 d-flex justify-content-end">
                            {(accountType === "instructor") ? (
                                <>
                                <button className="col-12 col-md-3 btn btn-primary m-md-3 createGroupButton" data-toggle="modal" data-target="#createExamModal">
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
									<div class="form-group">
										<label for="courseSelect">Select Course</label>
										<select class="form-control" id="courseSelect" value={examCourse} onChange={(e) => examCourseHandler(e.target.value)}>
											<option>Select an Option</option>
										    {courses?.map((course) => {
											    return  <option>{course}</option>
										})}
										</select>
									</div>
									<div class="form-group">
										<label for="examType">Select Exam Type</label>
										<select class="form-control" id="examType" onChange={(e) => examTypeHandler(e.target.value)} value={examType}>
											<option>Select an Option</option>
											<option>Face to Face</option>
											<option>Online</option>
										</select>
									</div>
									<div class="form-group">
										<label for="examType">Select Exam Classification</label>
										<select class="form-control" id="examType" onChange={(e) => examClassificationHandler(e.target.value)} value={examClassification}>
											<option>Select an Option</option>
										<option>Midterm 1</option>
										<option>Midterm 2</option>
										<option>Final</option>
										<option>Quiz</option>
										</select>
									</div>
                                    <div className="form-group row d-flex justify-content-between">
                                        <label for="placeInput" className="col-sm-6 col-form-label">Building Code (e.g. EE, B)</label>
                                        <div className="col-sm-6">
                                        <input type="text" 
                                        className="form-control text-uppercase" 
                                        id="typeInput" 
                                        placeholder="Building" 
                                        value={examBuilding}
                                        required
                                        onChange={(e) => examBuildingHandler(e.target.value)}></input>
                                        </div>
                                    </div>
                                    <div className="form-group row d-flex justify-content-between">
                                        <label for="placeInput" className="col-sm-6 col-form-label">Room Name (e.g. 102, Z04)</label>
                                        <div className="col-sm-6">
                                        <input type="text" 
                                        className="form-control" 
                                        id="typeInput" 
                                        placeholder="Room" 
                                        value={examRoom}
                                        required
                                        onChange={(e) => examRoomHandler(e.target.value)}></input>
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
                                    <button type="button" className="btn btn-primary" onClick={() => createExam()}>Create Exam</button>
                                </div>
                                </div>
                            </div>
                            </div>
                                </>
                            ) :
                                null
                            }
                            
                        </div>
						<div className="row">
							{exams.length ? exams?.map((exam)=>{
								return(
										<div className="col-12 col-md-6">
											<div className="groupCard text-center my-4 ">
												<div className="groupCardHeader card-header">
													<span><h5 className="groupCardTitle card-title">{exam.name}</h5></span>
                                                    <span>
                                                        <span className="groupCardText card-text">
                                                            <span className="card-text">{exam.type}</span>
                                                            <span className="card-text">{exam.date}</span>
                                                        </span>
                                                    </span>
												</div>
												<div className="groupCardBody card-body">
                                                    <ul className="attendanceList list-group list-group-flush">
														{exam?.participants?.map((participant) => {
                                                                return (
                                                                <li className=" list-group-item d-flex justify-content-between"> 
																    <div>{participant}</div> 
															    </li>
                                                                )
                                                            }
                                                        )}
													</ul>													
												</div>
												<div className="groupCardFooter card-footer">
                                                    {(accountType === "instructor") ? (
                                                        <>
                                                        <span>
                                                            <button className="btn btn-danger m-2" onClick={() => deleteExam(exam)} type="button">Delete Exam</button>
                                                        </span>
                                                        </>
                                                    ): (
                                                        <>
                                                        <div>
                                                            {exam.instructorName}
                                                        </div>
                                                        </>
                                                    )}
                                                    
												</div>
											</div>
										</div>
									
								)}) : (
                                    
                                        <div className="container bg-danger display-4 text-light d-flex justify-content-center mx-5 mt-3 rounded">
                                            No Exams Found
                                        </div>
                                    
                                )
							}
						</div>
					</div>
				</div>
			</div>
		</>
    )
}

const mapStateToProps = state => {
    return {
        exams: state.exams,
        courses: state.courses,
        name: state.name,
        surname: state.surname,
        email: state.email,
        accountType: state.accountType
    };
}
const mapDispatchToProps = (dispatch) => {
    return {
        add_exam: (exam) => dispatch({type : "ADD_NEW_EXAM", payload: {exam: exam} }),
        remove_exam: (exam) => dispatch({type : "REMOVE_EXAM", payload: {exam: exam} })
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(ExamsPage);

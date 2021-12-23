import Navbar from "../components/navbar"
import Sidebar from "../components/Sidebar"
import "../css/GroupsPage.css"
import { useState } from "react"

const GroupsPage = () => {
    const [groups, setGroups] = useState([
        {
            
            groupName: "Library Group - 1",
            date: "10.12.2021",
            participants: ["21902570", "21902572", "21902574"],
            isActive: true,
        },
        {
            
            groupName: "Library Group - 2",
            date: "11.12.2021",
            participants: ["21902570", "21902572", "21902574", "21902576"],
            isActive: true,
        },
        {
            
            groupName: "Study Group in EA0",
            date: "12.12.2021",
            participants: ["21902570", "21902572"],
            isActive: false,
        },
    ])

    const [addedParticipants, setAddedParticipants] = useState([])

    const [date, setDate] = useState("")
    const [name, setName] = useState("")
    const [newParticipant, setNewParticipant] = useState("");

    const addParticipant = () => {
        console.log(newParticipant, " will be added")
        if(addedParticipants.includes(newParticipant)) {
            window.alert("This participant already exists in this group")
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
    
    const dateHandler = (value) => {
        console.log(value);
        setDate(value);
    };
    const newParticipantHandler = (value) => {
        console.log(value);
        setNewParticipant(value);
    };
    
    const createGroup = () => {
        if ((name !== "") && (date !== "") && addedParticipants.length) {
            var newGroup = {
            groupName: name,
            date: date,
            participants: addedParticipants,
            isActive: true,
            }
            setGroups([...groups, newGroup])
            window.alert("A new group is added")
            setName("")
            setNewParticipant("")
            setDate("")
            setAddedParticipants([])
        }
        else {
            window.alert("All fields are required to be filled.")
        } 
    }

    const deleteGroup = (group) => {
        var filteredArray = groups.filter(function(item) {
            return item.groupName !== group.groupName
        })
        console.log(filteredArray);
        setGroups(filteredArray);
        console.log(group.groupName, "is removed");
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
					<div className="col-12 col-md-10 bg-light ">
                        <div className="row col-12 d-flex justify-content-end">
                            <button className="col-12 col-md-3 btn btn-primary m-md-3 createGroupButton" data-toggle="modal" data-target="#createGroupModal">
                                Create Group
                            </button>
                            <div className="modal fade" id="createGroupModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div className="modal-dialog modal-dialog-centered" role="document">
                                <div className="modal-content">
                                <div className="modal-header">
                                    <h5 className="modal-title" id="exampleModalLongTitle">Create a Group</h5>
                                    <button type="button" className="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div className="modal-body">
                                    <form>
                                    <div className="form-group row d-flex justify-content-between">
                                        <label for="nameInput" className="col-sm-4 col-form-label">Group Name</label>
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
                                    <button type="button" className="btn btn-primary" onClick={() => createGroup()}>Create Group</button>
                                </div>
                                </div>
                            </div>
                            </div>
                        </div>
						<div className="row">
							{groups.length ? groups.map((group)=>{
								return(
										<div className="col-12 col-md-6">
											<div className="card text-center my-4 ">
												<div className="card-header">
													<span><h5 className="card-title">{group.groupName}</h5></span>
                                                    <span>
                                                        <span className="card-text">{
                                                            group.isActive ? (
                                                                <span className="card-text px-3">(Active)</span>
                                                            ) : (
                                                                <span className="card-text px-3">(Inactive)</span>
                                                            )
                                                            }
                                                            <span className="card-text">{group.date}</span>
                                                        </span>
                                                    </span>
												</div>
												<div className="card-body">
                                                    <ul className="attendanceList list-group list-group-flush">
														{group.participants.map((participant) => {
                                                                return (
                                                                <li className=" list-group-item d-flex justify-content-between"> 
																    <div>{participant}</div> 
															    </li>
                                                                )
                                                            }
                                                        )}
													</ul>													
												</div>
												<div className="card-footer">
                                                    <span>
                                                        <button className="btn btn-danger m-2" onClick={() => deleteGroup(group)} type="button">Delete Group</button>
                                                    </span>
												</div>
											</div>
										</div>
									
								)}) : (
                                    <div className="container">
                                        No Groups Found
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

export default GroupsPage
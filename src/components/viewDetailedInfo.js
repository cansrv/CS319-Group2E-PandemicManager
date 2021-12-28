import '../css/viewDetailedInfo.css'
import { connect } from 'react-redux'
import axios from 'axios'
const riskyStudents = [
	//account type mail yolla
	{
		name: "Cenk Duran",
		id: "21903214"
	},
	{
		name: "Berk Türkçapar",
		id: "21903214"
	},
	{
		name: "Yiğit Ekin",
		id: "21903214"
	},
	{
		name: "Can Önal",
		id: "21903214"
	},
	
]
const ViewDetailedInfoModal = ({name, switchCourseType, course, section, type, accountType}) => {
	const handleTypeSwitch = (course) => {
		switchCourseType(course)
		axios.post("http://127.0.0.1:8080/switchCourseType",
                course
            ).then((response) => {
                window.alert("You have switched type of course: " + course.name)
            }).catch(error => { console.error(error);
                window.alert("Database Error Switch Type"); return Promise.reject(error); })
	}

	return (
		< div className="modal fade" id={`viewDetailedInfoModal${name + section}`} tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true" >
			<div className="modal-dialog modal-lg modal-dialog-centered" role="document">
				<div className="modal-content">
					<div className="modal-header">
						<h5 className="modal-title text-danger text-underline" id="exampleModalCenterTitle">Risky Students</h5>
						<button type="button" className="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div className="modal-body">
						<div className="row">
							<div className="col-7 tableDiv">
								<table className="table">
									<thead>
										<tr className= "sticky-top riskyTable">
											<th className="bg-danger text-white" scope="col">Name</th>
											<th className="bg-danger text-white" scope="col">ID</th>
										</tr>
									</thead>
									<tbody>
											{riskyStudents.map((riskyStudents)=>{
											return(
												<tr className="riskyTable">
													<td >{riskyStudents.name}</td>
													<td>{riskyStudents.id}</td>
												</tr>
											)
										})}	
									</tbody>
								</table>
							</div>
							<div className="col-5">
								
									{accountType === "instructor" ? (
										<div className="row">
										<div className="col-12">
										<div onClick= {() => {
											handleTypeSwitch(course)
										}} className ={`btn d-flex align-items-center justify-content-center switchF2F ${(type === "Face to Face")?"disabled": null}`}
										>Make Lesson Face To Face</div>
									</div>
									<div className="col-12">
										<div onClick={() => {
											handleTypeSwitch(course)
										}} className={`btn d-flex align-items-center justify-content-center switchOnline ${(type === "Online") ? "disabled" : null}`}
										>Make Lesson Online</div>
									</div>
										</div>
									) : (
										null
									)}
								
							</div>
						</div>
					</div>
					<div className="modal-footer">
						<button type="button" className="btn btn-secondary" data-dismiss="modal">Close</button>

					</div>
				</div>
			</div>
		</div >
	)
}
const mapDispatchToProps = dispatch => {
	return {
		switchCourseType: (course) => {
			dispatch({type: "SWITCH_COURSE_TYPE", payload: {course: course}})
		}
	};
}
const mapStateToProps = state => {
	return {
		courses: state.courses,
		accountType: state.accountType
	};
}
export default connect(mapStateToProps,mapDispatchToProps)(ViewDetailedInfoModal)
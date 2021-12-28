import {useState} from 'react'
import '../css/TakeAttendanceModal.css'


const Students = [
	{
		name: "Dummy Student 1",
		id: "21901234",
		isAttended: true
	},
	{
		name: "Dummy Student 2",
		id: "21901235",
		isAttended: true
	},
	{
		name: "Dummy Student 3",
		id: "21901236",
		isAttended: true
	},
	{
		name: "Dummy Student 4",
		id: "21901237",
		isAttended: true
	},
	{
		name: "Dummy Student 5",
		id: "21901238",
		isAttended: true
	},
	{
		name: "Dummy Student 6",
		id: "21901239",
		isAttended: true
	},
	{
		name: "Dummy Student 7",
		id: "21901240",
		isAttended: true
	},
	{
		name: "Dummy Student 8",
		id: "21901241",
		isAttended: true
	},
	{
		name: "Dummy Student 9",
		id: "21901242",
		isAttended: true
	},
	{
		name: "Dummy Student 10",
		id: "21901243",
		isAttended: true
	},
	{
		name: "Dummy Student 11",
		id: "21901244",
		isAttended: true
	},
	{
		name: "Dummy Student 12",
		id: "21901245",
		isAttended: true
	},
]




const TakeAttendanceModal = ({lecture, courseName, section}) =>{
	const [filteredStudents, setFilteredStudents] = useState(Students)
	const [filter, setFilter] = useState("")

	const filterSearch = () => {
		var theFilterStudents = Students.filter((student) => {
			return(
				student.id.includes(filter)
		)
		})
		setFilteredStudents(theFilterStudents)
	}
	const [attendance, setAttendance] =useState(false)
	const [checkAll, setCheckAll] =useState(false); 
	return(
		< div className="modal fade" id={`takeAttendanceModal${lecture}${courseName}${section}`} tabindex = "-1" role = "dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true" >
			<div className="modal-dialog modal-dialog-centered modal-lg" role="document">
				<div className="modal-content">
					<div className="modal-header">
						<h5 className="modal-title " id="exampleModalCenterTitle">Attendance Info</h5>
						<button type="button" className="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div className="modal-body">
						<div className="container">
							<div className="row nameInfo  text-white ">
								<div className="col-8">
									Name
								</div>
								<div className="col-4">
									ID
								</div>
							</div>
							<div className="row">
								<div className="input-group mb-3">
									<input type="text" onChange = {
										(e) => {
											setFilter(e.target.value)
										}
									}className="form-control" placeholder="Filter by ID" aria-label="Filter by ID" aria-describedby="searchBox"/>
									<div className="input-group-append">
										<button onClick = {() => {
											filterSearch()
										}} className="btn btn-outline-secondary" type="button">Search</button>
									</div>
								</div>
							</div>
							<div className="container takeAttendanceList">
								<ul className="list-group list-group-flush">
									{filteredStudents.map((Student) => {
										return (
											<li className="list-group-item ">
												<div className="custom-control custom-checkbox">
													<input type="checkbox" className="custom-control-input" id={`${lecture}${courseName}${section}${Student.id}`} onClick={() => {Student.isAttended = !Student.isAttended
													}} defaultChecked={true}  />
													<label className="custom-control-label d-flex justify-content-between" for={`${lecture}${courseName}${section}${Student.id}`} >
														<div className="col-7">{Student.name}</div>
														<div className="col-4">{Student.id}</div>
													</label>
												</div>
											</li>)

									})}
								</ul>
								
							</div>
							


						</div>
					</div>
					<div className="modal-footer">
						<button type="button" className="btn btn-secondary" data-dismiss="modal">Save</button>
					</div>
				</div>
			</div>
		</div >
	)
}
export default TakeAttendanceModal;
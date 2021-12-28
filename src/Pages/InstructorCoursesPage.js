import '../css/StudentCoursesPage.css'
import Navbar from '../components/navbar'
import courses from '../components/courseData'
import Sidebar from '../components/Sidebar'
import TakeAttendanceModal from '../components/TakeAttendanceModal'
import ViewDetailedInfoModal from '../components/viewDetailedInfo'
import {useState} from 'react'
import {connect} from "react-redux"

const InstructorCoursesPage = ({ courses}) => {
	const [currentWeek, setCurrentWeek] = useState(1);

	var attendance = [
        {
            lecture: 1,
            attendance: 'Attended'
        },
        {
            lecture: 2,
            attendance: 'Attended'
        },
        {
            lecture: 3,
            attendance: 'Not Attended'
        },
        {
            lecture: 4,
            attendance: 'Attended'
        },
        {
            lecture: 5,
            attendance: 'Not Attended'
        },
        {
            lecture: 6,
            attendance: 'Attended'
        },
        {
            lecture: 7,
            attendance: 'Attended'
        },
        {
            lecture: 8,
            attendance: 'Not Attended'
        },
        {
            lecture: 9,
            attendance: 'Attended'
        },
        {
            lecture: 10,
            attendance: 'Not Attended'
        },

    ],
	return (
		<>
			<div className="container">
				<div className="row">
					<Navbar />
				</div>

				<div className='row align-items-between'>
					<div className="d-none d-md-block col-md-2">
						<Sidebar />
					</div>
					<div className="col-12 col-md-10 bg-light ">
						<div className="row">
							{courses.map((courses) => {
								return (

									<div className="col-12 col-lg-6">
										<div className="card courseCard text-center my-4 ">
											<div className="card-header cardColoredPart">
												<span className='courseName'>{courses.name}</span>
												<span className='sectionAndType'> Section: {courses.section} ({courses.type})</span>
											</div>
											<div className="card-body">
												<ul className="attendanceList list-group list-group-flush">
													{attendance.map((attendance) => {
														return (
															<>
															<li className=" list-group-item d-flex justify-content-between">
																<div>Lecture {attendance.lecture}</div>
																<a data-toggle="modal" href={String(`#takeAttendanceModal${attendance.lecture}${courses.name}${courses.section}`)}  onClick={()=>{setCurrentWeek(attendance.lecture)
																	console.log(attendance.lecture)}}> Take Attendance</a>
																
															</li>
															<TakeAttendanceModal lecture ={attendance.lecture} courseName = {courses.name} section = {courses.section}/>
															</>
														)
													})}
												</ul>
											</div>
											<div className="card-footer cardColoredPart text-muted">
												<a data-toggle="modal" href={`#viewDetailedInfoModal${courses.name + courses.section}`} className= "text-white">View Detailed Info</a>
											</div>
											<ViewDetailedInfoModal name = {courses.name} section={courses.section} type={courses.type} course={courses}/>
										</div>
									</div>

								)
							})
							}

						</div>
					</div>
				</div>
			</div>
		
		<ViewDetailedInfoModal/>
		</>
	)
}

const mapStateToProps = state => {
	return {
	// attendance: state.attendance,
		courses: state.courses
	};
}

export default connect(mapStateToProps)(InstructorCoursesPage)
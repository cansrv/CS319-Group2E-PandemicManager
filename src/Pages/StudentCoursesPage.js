import '../css/StudentCoursesPage.css'
import Navbar from '../components/navbar'
import courses from '../components/courseData'
import Sidebar from '../components/Sidebar'
import {connect} from "react-redux"
import reducer from '../redux/reducer'

const StudentCoursesPage = ({courses, attendance,id}) => {
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
							{ courses?.length ? (
							courses.map((courses) => {
								return (
									<div className="col-12 col-md-6">
										<div class="card courseCard text-center my-4 ">
											<div class="card-header cardColoredPart">
												<span className='courseName'>{courses.name}</span>
												<span className='sectionAndType'> Section: {courses.section} ({courses.type})</span>
											</div>
											<div class="card-body">
												<ul class="attendanceList list-group list-group-flush">
													{courses.attendance.map((attendance) => {
														return (
															attendance.map((a) => {
																return (
																<li class=" list-group-item d-flex justify-content-between">
																	<div>Lecture {attendance.lecture[0]}</div>
																	<div>{attendance.attendance[0].includes(id)? "Attended":"Absent"}</div>
																</li>)
															})
														)
													})}
												</ul>
											</div>
											<div class="card-footer cardColoredPart text-muted">
												<p className='courseName'>{courses.instructor}</p>
											</div>
										</div>
									</div>

								)
							})) : (
								<div className="container bg-danger display-4 text-light d-flex justify-content-center mx-5 rounded">
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

const mapStateToProps = state => {
	return {
		courses: state.courses,
		attendance: state.attendance,
		id: state.id,
	};
}

export default connect(mapStateToProps)(StudentCoursesPage)
import '../css/StudentCoursesPage.css'
import Navbar from '../components/navbar'
import courses from '../components/courseData'
import Sidebar from '../components/Sidebar'
import TakeAttendanceModal from '../components/TakeAttendanceModal'
import ViewDetailedInfoModal from '../components/viewDetailedInfo'

const InstructorCoursesPage = () => {
	const attendance = [
		{
			week: 1,
			attendance: '3/3'
		},
		{
			week: 2,
			attendance: '2/3'
		},
		{
			week: 3,
			attendance: '0/3'
		},
		{
			week: 4,
			attendance: '1/3'
		},
		{
			week: 5,
			attendance: '3/3'
		},
		{
			week: 1,
			attendance: '3/3'
		},
		{
			week: 2,
			attendance: '2/3'
		},
		{
			week: 3,
			attendance: '0/3'
		},
		{
			week: 4,
			attendance: '1/3'
		},
		{
			week: 5,
			attendance: '3/3'
		}

	]
	const courses = [
		{
			name: 'CS-319',
			section: 1,
			instructor: 'Eray Tuzun',
			type: 'Face to Face',
			attendance: attendance

		},
		
		{
			name: 'CS-319',
			section: 1,
			instructor: 'Eray Tuzun',
			type: 'Face to Face',
			attendance: attendance

		},
		{
			name: 'CS-319',
			section: 1,
			instructor: 'Eray Tuzun',
			type: 'Face to Face',
			attendance: attendance

		}
	]

	return (
		<>
			<div className="container px-5">
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
															<li className=" list-group-item d-flex justify-content-between">
																<div>Week {attendance.week}</div>
																<a data-toggle="modal" href="#takeAttendanceModal"  > Take Attendance</a>
																
															</li>
														)
													})}

												</ul>
											</div>
											<div className="card-footer cardColoredPart text-muted">
												<a data-toggle="modal" href="#viewDetailedInfoModal" className= "text-white">View Detailed Info</a>
											</div>
										</div>
									</div>

								)
							})
							}

						</div>
						

						
						

					</div>
				</div>
			</div>
		<TakeAttendanceModal/>
		<ViewDetailedInfoModal/>
		</>
	)
}
export default InstructorCoursesPage
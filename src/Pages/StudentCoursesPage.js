import '../css/StudentCoursesPage.css'
import Navbar from '../components/navbar'
import courses from '../components/courseData'
import Sidebar from '../components/Sidebar'

const StudentCoursesPage = () => {
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
			name: 'CS-315',
			section: 4,
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

									<div className="col-12 col-md-6">
										<div class="card courseCard text-center my-4 ">
											<div class="card-header cardColoredPart">
												<span className='courseName'>{courses.name}</span>
												<span className='sectionAndType'> Section: {courses.section} ({courses.type})</span>
											</div>
											<div class="card-body">
												<ul class="attendanceList list-group list-group-flush">
													{attendance.map((attendance) => {
														return (
															<li class=" list-group-item d-flex justify-content-between">
																<div>Week {attendance.week}</div>
																<div>{attendance.attendance}</div>
															</li>
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
							})
							}

						</div>

					</div>
				</div>
			</div>
		</>
	)
}
export default StudentCoursesPage
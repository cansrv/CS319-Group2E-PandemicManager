import {useState} from "react"
import Navbar from "../components/navbar"
import '../css/InstructorCampusPage.css'
import report from "../components/weeklyReportData"
import exams from "../components/examData"
import { Link } from "react-router-dom"
import Sidebar from "../components/Sidebar"


const InstructorCampusPage = (user) => {

	const [status, setstatus] = useState(true);
	const [report, setreport] = useState([])

	const courses = [
		"CS-319",
		"CS-415",
		"CS-453"
	]

	const [exams, setExams] = useState([
		{
			course: 'CS-319',
			classification: "Midterm 1",
			instructor: 'Eray Tuzun',
			type: 'Face to Face',
			participantsList: [21902570, 21902572, 21902574],
			place: "EE-102"
			
		},
	])

	return (
		<>
			<div className='container staffCampusPg'>
				<div className='row'>
					<Navbar />
				</div>
				<div className='row align-items-between'>
					<div className="d-none d-md-block col-md-2">
						<Sidebar/>
					</div>
					<div className="col-12 col-md-10 bg-light ">
						<div className="row mt-4 d-flex justify-content-between ml-5">
							<div className="col-12 col-sm-8 px-sm-1">
								{status ? (<div className="statusNotRisky d-flex text-center justify-content-center align-items-center">
									You Are Allowed On Campus
								</div>) : (<div className="statusRisky d-flex text-center justify-content-center align-items-center">
									You Are  NOT Allowed On Campus
								</div>)}
							</div>
							<div className="d-none d-sm-block col-12 col-sm-4">
								<Link to="/exams">
									<button className="btn createExam text-center d-flex justify-content-center align-items-center">
										Exams Page
									</button>
								</Link>
							
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
									{report?.map((report) => {
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
									{exams?.map((exams) => {
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
						<Link to="/groups">
                            <button className='groupsButton mb-3 py-3 btn'>
                            	Groups
                            </button>
                        </Link>
					</div>
				</div>
			</div>
		</>
	)
}

export default InstructorCampusPage
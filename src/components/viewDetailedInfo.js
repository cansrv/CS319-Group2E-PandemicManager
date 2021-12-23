import '../css/viewDetailedInfo.css'
const riskyStudents = [
	{
		name: "Cenk Duramayan",
		id: "21903214"
	},
	{
		name: "Tuco",
		id: "21903214"
	},
	{
		name: "Ytekin",
		id: "21903214"
	},
	{
		name: "BJK",
		id: "21903214"
	},
	{
		name: "Corona elif",
		id: "21903214"
	},
	{
		name: "CoronA yAMUR",
		id: "21903214"
	},
	{
		name: "Cenk Duramayan",
		id: "21903214"
	},
	{
		name: "Tuco",
		id: "21903214"
	},
	{
		name: "Ytekin",
		id: "21903214"
	},
	{
		name: "BJK",
		id: "21903214"
	},
	{
		name: "Corona elif",
		id: "21903214"
	},
	{
		name: "CoronA yAMUR",
		id: "21903214"
	},
]
const ViewDetailedInfoModal = () => {
	return (
		< div className="modal fade" id="viewDetailedInfoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true" >
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
								<div className="row">
									<div className="col-12">
										<div className = "btn d-flex align-items-center justify-content-center switchF2F">Make Lesson Face To Face</div>
									</div>
									<div className="col-12">
										<div className="btn d-flex align-items-center justify-content-center switchOnline">Make Lesson Online</div>
									</div>

								</div>
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
export default ViewDetailedInfoModal;
import Navbar from "../components/navbar"
import Sidebar from "../components/Sidebar"

const GroupsPage = () => {
    const groups = [
        {
            groupId: 1,
            groupName: "LibraryGroup",
            date: "10.12.2021",
            participants: ["21902570", "21902572", "21902574"],
            isActive: true,
        },
        {
            groupId: 1,
            groupName: "LibraryGroup",
            date: "11.12.2021",
            participants: ["21902570", "21902572", "21902574", "21902576"],
            isActive: true,
        },
        {
            groupId: 3,
            groupName: "Study Group",
            date: "12.12.2021",
            participants: ["21902570", "21902572"],
            isActive: false,
        },
    ]
    
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
						<div className="row">
							{groups.map((group)=>{
								return(
										<div className="col-12 col-md-6">
											<div className="card text-center my-4 ">
												<div className="card-header">
													<span><h5 className="card-title">{group.groupName}</h5></span>
                                                    <span>
                                                        <span className="card-text">{
                                                        group.isActive ? (
                                                            <p className="card-text">(Active)</p>
                                                        ) : (
                                                            <p className="card-text text-muted">(Inactive)</p>
                                                        )
                                                        }</span>
                                                    </span>
												</div>
												<div className="card-body">
													<p className="card-text">{group.date}</p>
													<p className="card-text">{group.participants.length} Participants</p>
													
												</div>
												<div className="card-footer">
													<p className = 'courseName'>{group.instructor}</p>
												</div>
											</div>
										</div>
									
								)})
							}
						</div>
					</div>
				</div>
			</div>
		</>
    )
}

export default GroupsPage
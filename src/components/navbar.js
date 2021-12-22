import Sidebar from "../components/Sidebar"
import '../css/Navbar.css'

const Navbar = () => {

	return(
		<>
		<div className="collapse navbar-collapse" id="navbarSupportedContent">
		<Sidebar/>
		</div>
		<nav className="navbar navbar-expand-lg panman-bg container d-flex">
			{/*LİNK KOY*/}
			<div className="row navbar-content-area">
				<div className="col-lg-7 col-md-12 d-flex offset-1 offset-md-0
				justify-content-md-center justify-content-center align-items-center">
					<a className="navbar-brand" href="/studenthomepage"><div className="panman-logo"></div></a>
					<span className="navbar-logo-text ml-md-4 ml-1">PanMan</span>
					<span className="navbar-name-text ml-lg-4 ml-3 d-none d-sm-inline">University Pandemic Manager</span>
				</div>
				<div className="col-lg-5 d-flex align-items-center">
					<div className="ml-auto d-flex align-items-center">
						<div className="d-none d-lg-block user-logo mr-3"></div>
						<div className="d-none d-lg-block">
							<div>
								<div className="username">Mehmet Yılmaz</div>
								<div className="account-status text-muted">Student</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<button className="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
				<span className="navbar-toggler-icon bg-dark"></span>
			</button>
			<div className="collapse navbar-collapse" id="navbarSupportedContent">
				<section className="sidebar-link mb-1 mt-1 hover-effect d-sm-none nav-item"> <span className="ml-lg-3 ml-2">Home</span></section>
				<section className="sidebar-link mb-1 hover-effect d-md-none"><span className="ml-lg-3 ml-2">Profile</span></section>
				<section className="sidebar-link mb-1 hover-effect d-md-none"><span className="ml-lg-3 ml-2">Tests</span></section>
				<section className="sidebar-link mb-1 hover-effect d-md-none"><span className="ml-lg-3 ml-2">Campus</span></section>
				<section className="sidebar-link mb-1 hover-effect d-md-none"><span className="ml-lg-3 ml-2">Courses</span></section>
				<section className="sidebar-link hover-effect logout-div d-md-none"><span className="ml-lg-3 ml-2">Logout</span></section>
			</div>
		</nav>
		</>
	)
}

export default Navbar

import '../css/Navbar.css'

const Navbar = () => {

	return(
		<nav className="navbar navbar-expand-lg fixed-top panman-bg container d-flex">
			<button className="navbar-toggler d-none" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
					aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
				<span className="navbar-toggler-icon">fghbjbjjjbjbjb</span>
			</button>
			{/*LİNK KOY*/}
			<div className="row navbar-content-area">
				<div className="col-lg-7 col-md-12 d-flex offset-1 offset-md-0
				justify-content-md-center justify-content-center align-items-center">
					<a className="navbar-brand" href="#"><div className="panman-logo"></div></a>
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
		</nav>
	)
}

export default Navbar
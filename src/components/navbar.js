import Sidebar from "../components/Sidebar"
import '../css/Navbar.css'
import {useState} from 'react'
import { Link } from 'react-router-dom'
import {connect} from "react-redux"

const Navbar = ({name, surname, accountType}) => {
	const [click, setClick] = useState(false)
	return(
		<>
		<nav className="navbar navbar-expand-lg panman-bg container d-flex">
			{/*LİNK KOY*/}
			<div className="row navbar-content-area">
				<div className="col-lg-7 col-md-12 d-flex offset-1 offset-md-0
				justify-content-md-center justify-content-center align-items-center">
					<a className="navbar-brand" href="/home"><div className="panman-logo"></div></a>
					<span className="navbar-logo-text ml-md-4 ml-1">PanMan</span>
					<span className="navbar-name-text ml-lg-4 ml-3 d-none d-sm-inline">University Pandemic Manager</span>
				</div>
				<div className="col-lg-5 d-flex align-items-center">
					<div className="ml-auto d-flex align-items-center">
						<div className="d-none d-lg-block user-logo mr-3"></div>
						<div className="d-none d-lg-block">
							<div>
								<div className="username">{ `${name} ${surname}`}</div>
								<div className="account-status text-muted">{accountType}</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<button onClick={()=>setClick(!click)} className="navbar-toggler btn btn-block toggler-w mr-auto bg-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
				<span className="navbar-toggler-icon"></span>
			</button>
			{click &&
			<div className="collapse navbar-collapse" id="navbarSupportedContent">
				<Link to="/home" className="text-decoration-none text-white">
					<section className="sidebar-link mb-1 mt-1 hover-effect nav-item text-white"><span
						className="ml-lg-3 ml-2">Home</span></section>
				</Link>
				<Link to="/myProfile" className="text-decoration-none text-white">
					<section className="sidebar-link mb-1 hover-effect "><span
						className="ml-lg-3 ml-2 text-light">Profile</span></section>
				</Link>
				<Link to="/tests" className="text-decoration-none text-white">
					<section className="sidebar-link mb-1 hover-effect"><span
						className="ml-lg-3 ml-2 text-light">Tests</span></section>
				</Link>
				<Link to="/campus" className="text-decoration-none text-white">
					<section className="sidebar-link mb-1 hover-effect"><span
						className="ml-lg-3 ml-2 text-light">Campus</span></section>
				</Link>

				{
					!(accountType === "staff") ? <Link to="/courses" className="text-decoration-none text-white">
						<section className="sidebar-link mb-1 hover-effect"><span
							className="ml-lg-3 ml-2 text-light">Courses</span></section>
					</Link> : null}

				<Link to="/" className="text-decoration-none text-white">
					<section className="sidebar-link hover-effect logout-div"><span
						className="ml-lg-3 ml-2 text-light">Logout</span></section>
				</Link>
			</div>
			}
		</nav>
		</>
	)
}

const mapStateToProps = state => {
	return {
		name: state.name,
		surname: state.surname,
		accountType: state.accountType
	};
}

export default connect(mapStateToProps)(Navbar);

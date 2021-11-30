
import '../css/navbar.css'

const Navbar = () => {

	return(
		<div className = 'row navbar'>
			<div className= 'col-2 logoContainer'>
				<a className = "logoContainer" href="/">v</a>
			</div>
			<div className="col-7 brandContainer">
				<p id="brandName">PanMan</p>
				<p id="brandDesc">Bilkent University Pandemic Manager</p>
				 
			</div>
			<div className = "col-3  userInfo">
				<p id="nameSurname">Name Surname</p>
				<p id="userType">User Type</p>
			</div>
			
		</div>
	)
}

export default Navbar
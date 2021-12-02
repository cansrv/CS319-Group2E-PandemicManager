import "../css/Login.css"
import { Link } from "react-router-dom"

const Login = () => {
    return (
        <div className = "mainContainer">
            <div className="seperator d-none d-"></div>
            <div className = "row">
                <div className = "col-12 col-md-6 justify-content-center text-center leftContainer">
                    <div className = "row col-12 justify-content-center text-center logoContainer"></div>
                    <div className = "row col-12 justify-content-center text-center nameContainer">
                        PANMAN
                    </div>
                    <div className = "row d-none d-md-block col-md-12 justify-content-center text-center aboutContainer">
                        Welcome stranger! PanMan is a pandemic manager application for all Bilkenters. 
                        But, it is not only an app, it is an idea, it is a way of life. 
                        You are free and recommended to use it, but come in at your own risk…
                    </div>
                </div>
                <div className = "d-flex col-12 col-md-6 align-items-center rightContainer justify-content-between">
                    <form className = "col-12">
                        <div class="form-group flex-row d-flex justify-content-between align-items-center">
                            <label for="inputEmail3" class="col-sm-2 col-form-label label">Email: </label>
                            <div class="col-8 inputGroup">
                                <input type="email" class="form-control" id="inputEmail3" placeholder="Email"/>
                            </div>
                        </div>
                        <div class="form-group flex-row d-flex justify-content-between align-items-center">
                            <label for="inputPassword3" class="col-sm-2 col-form-label label">Password: </label>
                            <div class="col-8 inputGroup">
                                <input type="password" class="form-control" id="inputPassword3" placeholder="Password"/>
                            </div>
                        </div>
                        <div class="form-group flex-row d-flex justify-content-center align-items-center">
                            <div class="buttonContainer">
                                <button type="submit" href= "#" class="btn loginButton">Log-in</button>
                            </div>
                        </div>
                        <div className = "signupPrompt flex-row d-flex justify-content-center align-items-center">
                            Don’t have an Account? <Link to = "/signup" className="pl-2" >Sign-up</Link>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default Login

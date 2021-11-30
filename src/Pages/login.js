import "../css/Login.css"

const Login = () => {
    return (
        <div className = "mainContainer">
            <div className="seperator"></div>
            <div className = "row">
                <div className = "col-6 justify-content-center text-center leftContainer">
                    <div className = "row col-12 justify-content-center text-center logoContainer"></div>
                    <div className = "row col-12 justify-content-center text-center nameContainer">
                        PANMAN
                    </div>
                    <div className = "row col-12 justify-content-center text-center aboutContainer">
                        Welcome stranger! PanMan is a pandemic manager application for all Bilkenters. 
                        But, it is not only an app, it is an idea, it is a way of life. 
                        You are free and recommended to use it, but come in at your own risk…
                    </div>
                </div>
                <div className = "col-6 rightContainer">
                    <form className>
                        <div class="form-group row">
                            <label for="inputEmail3" class="col-sm-2 col-form-label label">Email: </label>
                            <div class="col-8 inputGroup">
                                <input type="email" class="form-control emailInput" id="inputEmail3" placeholder="Email"/>
                            </div>
                        </div>
                        <div class="form-group row ">
                            <label for="inputPassword3" class="col-sm-2 col-form-label label">Password: </label>
                            <div class="col-8 inputGroup">
                                <input type="password" class="form-control passwordInput" id="inputPassword3" placeholder="Password"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <div class="col-sm-10 buttonContainer">
                                <button type="submit" href= "#" class="btn loginButton">Log-in</button>
                            </div>
                        </div>
                    </form>
                    <div className = "signupPrompt">
                        Don’t have an Account? <a href = "#" className="signupLink">Sign-up</a>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Login

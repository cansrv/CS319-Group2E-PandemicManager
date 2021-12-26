import "../css/Login.css"
import { Link } from "react-router-dom"
import { useState, useEffect } from "react"
import {connect} from "react-redux" 
import axios from "axios"
import {temp_Data, valid_Accounts} from "../Data"
const Login = ({login_account, loggedIn, setHasLoggedIn}) => {
    const [mail, setMail] = useState("")
    const [password, setPassword] = useState("")
    const [loginAttempt, setLoginAttempt] = useState(false)

    const mailHandler = (value) => {
        console.log(value);
        setMail(value);
    };
    
    const passwordHandler = (value) => {
        console.log(value);
        setPassword(value);
    };

    const validateEmail = (email) => {
    return String(email)
        .toLowerCase()
        .match(
        /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
        );
    };

    /*useEffect( () => {
        var loginInfo = {
            mail: mail,
            password: password
        }
        axios.post("http://127.0.0.1:4567/login",
            loginInfo
        ).then((response) => {
            console.log("Response" + response)
            if (response.data !== null){
                login_account(response.data)
                window.location.href = "/home"
            }
        }).catch(error => { console.error(error);
            console.log("Database Problem"); setLoginAttempt(false); return Promise.reject(error); })
    }, [loginAttempt])*/

    const login = (e) => {
        e.preventDefault()
        if (validateEmail(mail) && password !== "") {
            console.log(({email: mail, password: password}))
            /*if (valid_Accounts.find(item => item.email === mail && item.password === password)) {
                var theIndex = temp_Data.findIndex(item => 
                    item.email === mail
                )
                var theUser = temp_Data[theIndex];
                login_account(theUser)
            }*/
            var loginInfo = {
                mail: mail,
                password: password
            }
            axios.post("http://127.0.0.1:4567/login",
                loginInfo
            ).then((response) => {
            console.log("Response" + response)
            if (response.data !== null){
                login_account(response.data)
                window.location.href = "/home"
            }
        }).catch(error => { console.error(error);
            console.log("Database Problem"); setLoginAttempt(false); return Promise.reject(error); })
        }
        else if (!validateEmail(mail)) {
            window.alert("Please enter a valid mail");
        }
        else if (password == "") {
            window.alert("Please enter password");
        }
    }

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
                        <div className="form-group flex-row d-flex justify-content-between align-items-center">
                            <label for="inputEmail3" className="col-sm-2 col-form-label label">Email: </label>
                            <div className="col-8 inputGroup">
                                <input type="email" className="form-control" id="inputEmail3" placeholder="Email"
                                onChange={(e) => mailHandler(e.target.value)}
                                value={mail}/>
                            </div>
                        </div>
                        <div className="form-group flex-row d-flex justify-content-between align-items-center">
                            <label for="inputPassword3" className="col-sm-2 col-form-label label">Password: </label>
                            <div className="col-8 inputGroup">
                                <input type="password" className="form-control" id="inputPassword3" placeholder="Password"
                                onChange={(e) => passwordHandler(e.target.value)}
                                value={password}/>
                            </div>
                        </div>
                        <div className="form-group flex-row d-flex justify-content-center align-items-center">
                            <div className="buttonContainer">
                            
                                    <button type="submit" href= {loggedIn ? "/home" : "/login"} className="btn loginButton"
                                    onClick={(e) => login(e)}>Log-in</button>
                                
                                    
                                
                            </div>
                        </div>
                        <div className = "signupPrompt flex-row d-flex justify-content-center align-items-center pb-3">
                            Don’t have an Account? <Link to = "/signup" className="pl-2">Sign-up</Link>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    )
}

const mapDispatchToProps = (dispatch) => {
    return { login_account: (payload) => dispatch({type : "LOGIN", payload: {...payload} })}
}
const mapStateToProps = (state) => {
    return {loggedIn: state.loggedIn}
}

export default connect(mapStateToProps,mapDispatchToProps)(Login);

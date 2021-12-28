import "../css/SignUp.css"
import React, {useState, useEffect} from 'react';
import { Link } from "react-router-dom"
import axios from "axios";

export const SignUp = () => {
    const [signUpInfo, setSignUpInfo] = useState({ name: '', email: '', surname: '', id: '', password: '', HEScode: ''});
    const [dataSendNeeded, setDataSendNeeded] = useState(false)

    /*useEffect( () => {
        axios.post("http://127.0.0.1:8080/signup",
            signUpInfo
        ).then((response) => {
            
    }, [dataSendNeeded])})*/

    const handleChange = (e) => {
        const name = e.target.id;
        const value = e.target.value;
        setSignUpInfo({ ...signUpInfo, [name]: value });
    };
    const handleSubmit = (e) => {
        e.preventDefault();
        const empty_check = (signUpInfo.name !== "") &&
            (signUpInfo.surname !== "") &&
            (signUpInfo.email !== "") &&
            (signUpInfo.id !== "") &&
            (signUpInfo.password !== "") &&
            (signUpInfo.HEScode !== "")
        if (empty_check) {
            window.alert("You have successfully signed up! Please go back to Login Page to start using PANMAN!")
            // setDataSendNeeded(!dataSendNeeded)
            axios.post("http://127.0.0.1:8080/signup",
            signUpInfo
        ).then((response) => {
            
    })
            setSignUpInfo (
                {
                    name: '', email: '', surname: '', id: '', password: '', HEScode: ''
                }
            )
        }
         else {
            window.alert("Please enter all of the fields to create an account");
        }
    };


    return (
        <>
            <header className="navbar navbar-expand-lg sign-up-header">
                <div className="panman-logo"></div>
                <h1 className="panman-text" href="#">PanMan</h1>
            </header>

            <section className="container">
                <div className="row">
                    <div className="col-lg-10 col-12 offset-lg-1">
                        <section className="card">
                            <div className="card-body sign-up-card">
                                <div className="row">
                                    <div className="col-md-8 col-12 offset-sm-2 offset-md-3 offset-lg-4 text-center text-sm-left">
                                        <h1 className="sign-up-text">Sign-up Form</h1>
                                    </div>
                                </div>

                                <form>
                                    <div className="form-group row d-flex justify-content-between align-items-center">
                                        <label htmlFor="name"
                                               className="col-lg-3 col-form-label form-text"> Name: </label>
                                        <div className="col-lg-7 col-12 sign-up-form-container">
                                            <input type="text" className="form-control" id="name"
                                                   onChange={(e) => handleChange(e)} placeholder="Name" value={signUpInfo.name}/>
                                        </div>
                                    </div>
                                    <div className="form-group row d-flex justify-content-between align-items-center">
                                        <label htmlFor="surname"
                                               className="col-lg-3 col-form-label form-text"> Surname: </label>
                                        <div className="col-lg-7 col-12 sign-up-form-container">
                                            <input type="text" className="form-control" id="surname"
                                                   onChange={(e) => handleChange(e)} placeholder="Surname" value={signUpInfo.surname}/>
                                        </div>
                                    </div>
                                    <div className="form-group row d-flex justify-content-between align-items-center">
                                        <label htmlFor="id" className="col-lg-3 col-form-label form-text"> ID: </label>
                                        <div className="col-lg-7 col-12 sign-up-form-container">
                                            <input type="number" className="form-control" id="id"
                                                   onChange={(e) => handleChange(e)} placeholder="Ex:21xxxxxx" value={signUpInfo.id}/>
                                        </div>
                                    </div>
                                    <div className="form-group row d-flex justify-content-between align-items-center">
                                        <label htmlFor="mail"
                                                  className="col-lg-3 col-form-label form-text"> Mail: </label>
                                        <div className="col-lg-7 col-12 sign-up-form-container">
                                            <input type="email" className="form-control" id="email"
                                                   onChange={(e) => handleChange(e)} placeholder="Bilkent Mail" value={signUpInfo.email}/>
                                        </div>
                                    </div>
                                    <div className="form-group row d-flex justify-content-between align-items-center">
                                        <label htmlFor="password"
                                               className="col-lg-3 col-form-label form-text"> Password: </label>
                                        <div className = "col-lg-7 col-12 sign-up-form-container" >
                                        <input type="password" className="form-control" id="password"
                                               onChange={(e) => handleChange(e)} placeholder="Password" value={signUpInfo.password}/>
                                    </div>
                                        </div>
                                    <div className="form-group row d-flex justify-content-between align-items-center">
                                        <label htmlFor="hesCode" className="col-lg-3 col-form-label form-text"> HES
                                            Code: </label>
                                        <div className="col-lg-7 col-12 sign-up-form-container">
                                            <input type="text" className="form-control" id="HEScode"
                                                   onChange={(e) => handleChange(e)} placeholder="Ex:29ef23" value={signUpInfo.HEScode}/>
                                        </div>
                                    </div>
                                    <div className="row d-flex justify-content-between align-items-center col-sm-11">
                                            <button type="submit" className="btn btn-primary sign-up-button"
                                                    onClick={(e) => handleSubmit(e)}> Sign-up
                                            </button>
                                    </div>
                                    <Link to="/">
                                    <div className="row d-flex justify-content-between align-items-center col-sm-11">
                                       <p className="text-muted ml-auto mt-2 mr-2 text-underline"> Back to login</p>
                                    </div>
                                    </Link>
                                </form>
                            </div>
                        </section>
                    </div>
                </div>
            </section>
        </>
    )
}
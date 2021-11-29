import "../css/SignUp.css"
import React, {useState} from 'react';

export const SignUp = () => {
    const [signUpInfo, setSignUpInfo] = useState({ name: '', email: '', surname: '', id: '', password: '', HEScode: ''});
    const handleChange = (e) => {
        const name = e.target.id;
        const value = e.target.value;
        setSignUpInfo({ ...signUpInfo, [name]: value });
    };
    const handleSubmit = (e) => {
        e.preventDefault();
        console.log(signUpInfo);
        window.alert("your account has been created with the following information:\n" + signUpInfo.name + "\n" +
            signUpInfo.surname + "\n" +signUpInfo.password + "\n" +signUpInfo.email + "\n" +signUpInfo.HEScode + "\n" +signUpInfo.id + "\n");
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
                                        <h1 className="sign-up-text">Sign-up Form< /h1>
                                    </div>
                                </div>

                                <form>
                                    <div className="form-group row d-flex justify-content-between align-items-center">
                                        <label htmlFor="name"
                                               className="col-lg-3 col-form-label form-text"> Name: < /label>
                                        <div className="col-lg-7 col-12 sign-up-form-container">
                                            <input type="text" className="form-control" id="name"
                                                   onChange={(e) => handleChange(e)}/>
                                        </div>
                                    </div>
                                    <div className="form-group row d-flex justify-content-between align-items-center">
                                        <label htmlFor="surname"
                                               className="col-lg-3 col-form-label form-text"> Surname: < /label>
                                        <div className="col-lg-7 col-12 sign-up-form-container">
                                            <input type="text" className="form-control" id="surname"
                                                   onChange={(e) => handleChange(e)}/>
                                        < /div>
                                    </div>
                                    <div className="form-group row d-flex justify-content-between align-items-center">
                                        <label htmlFor="id" className="col-lg-3 col-form-label form-text"> ID: < /label>
                                        <div className="col-lg-7 col-12 sign-up-form-container">
                                            <input type="number" className="form-control" id="id"
                                                   onChange={(e) => handleChange(e)}/>
                                        < /div>
                                    </div>
                                    <div className="form-group row d-flex justify-content-between align-items-center">
                                        <label htmlFor="mail"
                                                  className="col-lg-3 col-form-label form-text"> Mail: < /label>
                                        <div className="col-lg-7 col-12 sign-up-form-container">
                                            <input type="email" className="form-control" id="email"
                                                   onChange={(e) => handleChange(e)}/>
                                        </div>
                                    </div>
                                    <div className="form-group row d-flex justify-content-between align-items-center">
                                        <label htmlFor="password"
                                               className="col-lg-3 col-form-label form-text"> Password: < /label>
                                        <div className = "col-lg-7 col-12 sign-up-form-container" >
                                        <input type="password" className="form-control" id="password"
                                               onChange={(e) => handleChange(e)}/>
                                    </div>
                                        </div>
                                    <div className="form-group row d-flex justify-content-between align-items-center">
                                        <label htmlFor="hesCode" className="col-lg-3 col-form-label form-text"> HES
                                            Code: < /label>
                                        <div className="col-lg-7 col-12 sign-up-form-container">
                                            <input type="number" className="form-control" id="HEScode"
                                                   onChange={(e) => handleChange(e)}/>
                                        < /div>
                                    </div>
                                    <div className="form-group row d-flex justify-content-between align-items-center">
                                        <div className="col-sm-11">
                                            <button type="submit" className="btn btn-primary sign-up-button"
                                                    onClick={(e) => handleSubmit(e)}> Sign-up
                                            < /button>
                                        < /div>
                                    </div>
                                </form>

                            </div>
                        </section>
                    </div>
                </div>
            </section>
        </>
    )
}
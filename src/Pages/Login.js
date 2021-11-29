import "../css/Login.css"

const Login = () => {
    return (
        <div className = "mainContainer">
            <div className = "row">
                <div className = "col-6 justify-content-center text-center leftContainer">
                    <div className = "row col-12 justify-content-center text-center logoContainer">
                        Logo
                    </div>
                    <div className = "row col-12 justify-content-center text-center nameContainer">
                        PANMAN
                    </div>
                    <div className = "row col-12 justify-content-center text-center aboutContainer">
                        “blandit turpis cursus in hac habitasse platea dictumst quisque sagittis purus sit amet volutpat consequat mauris nunc congue nisi vitae suscipit tellus mauris a diam maecenas sed enim ut sem”
                    </div>
                </div>
                {console.log("I am at the login page")}
                <div className = "col-6 rightContainer">
                    Right Side
                </div>
            </div>
        </div>
    )
}

export default Login

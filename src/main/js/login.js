import React from "react"
import bootstrap from "jsview-bootstrap"

bootstrap(
    function (initial) {

        const {contextPath, csrfToken} = initial;

        return (
            <div className="container">
                <div className="row">
                    <div className="col">
                        <h1>Skat-Cards Login</h1>

                        <hr/>
                        <h3>
                            {" Demo accounts"}
                        </h3>
                        <p>
                            There is one user "admin" with the same password.
                        </p>


                        {
                            location.search.indexOf("error") >= 0 && (
                                <React.Fragment>
                                    <p className="text-danger">Login failed</p>
                                    <hr/>
                                </React.Fragment>
                            )
                        }

                        <form method="POST" action={contextPath + "/login_check"}>
                            <div className="form-group">
                                <label htmlFor="loginField">Login</label>
                                <input type="text" className="form-control" name="username" id="loginField"
                                       placeholder="Login Name"/>
                            </div>
                            <div className="form-group">
                                <label htmlFor="passwordField">Password</label>
                                <input type="password" className="form-control" id="passwordField"
                                       placeholder="Password" name="password"/>
                            </div>
                            <div className="form-check">
                                <input type="checkbox" className="form-check-input" id="rememberMeCheckbox"
                                       name="remember-me"/>
                                <label className="form-check-label" htmlFor="rememberMeCheckbox">Remember the login on
                                    this computer</label>
                            </div>

                            <input type="hidden" name={csrfToken.param} value={csrfToken.value}/>

                            <button type="submit" className="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        );
    },
    () => console.info("ready!")
);


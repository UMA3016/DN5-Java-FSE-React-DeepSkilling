import React, { Component } from "react";
import GuestPage from "./GuestPage";
import UserPage from "./UserPage";

class Login extends Component {

    constructor(props) {
        super(props);

        this.state = {
            isLoggedIn: false
        };
    }

    login = () => {
        this.setState({ isLoggedIn: true });
    };

    logout = () => {
        this.setState({ isLoggedIn: false });
    };

    render() {

        if (this.state.isLoggedIn) {
            return (
                <div>
                    <button onClick={this.logout}>
                        Logout
                    </button>

                    <UserPage />
                </div>
            );
        }

        return (
            <div>
                <button onClick={this.login}>
                    Login
                </button>

                <GuestPage />
            </div>
        );
    }
}

export default Login;
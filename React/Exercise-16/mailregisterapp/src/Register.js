import React, { Component } from "react";

class Register extends Component {

    constructor(props) {
        super(props);

        this.state = {
            name: "",
            email: "",
            password: "",
            errors: {}
        };
    }

    handleChange = (event) => {

        this.setState({
            [event.target.name]: event.target.value
        });

    };

    handleSubmit = (event) => {

        event.preventDefault();

        let errors = {};

        if (this.state.name.length < 5) {
            errors.name = "Name should have at least 5 characters";
        }

        if (
            !this.state.email.includes("@") ||
            !this.state.email.includes(".")
        ) {
            errors.email = "Enter a valid Email";
        }

        if (this.state.password.length < 8) {
            errors.password = "Password should have at least 8 characters";
        }

        this.setState({ errors });

        if (Object.keys(errors).length === 0) {
            alert("Registration Successful!");
        }

    };

    render() {

        return (

            <div className="container">

                <h2>Mail Registration Form</h2>

                <form onSubmit={this.handleSubmit}>

                    <label>Name</label><br />

                    <input
                        type="text"
                        name="name"
                        value={this.state.name}
                        onChange={this.handleChange}
                    />

                    <div className="error">
                        {this.state.errors.name}
                    </div>

                    <br />

                    <label>Email</label><br />

                    <input
                        type="text"
                        name="email"
                        value={this.state.email}
                        onChange={this.handleChange}
                    />

                    <div className="error">
                        {this.state.errors.email}
                    </div>

                    <br />

                    <label>Password</label><br />

                    <input
                        type="password"
                        name="password"
                        value={this.state.password}
                        onChange={this.handleChange}
                    />

                    <div className="error">
                        {this.state.errors.password}
                    </div>

                    <br />

                    <button type="submit">
                        Register
                    </button>

                </form>

            </div>

        );

    }

}

export default Register;
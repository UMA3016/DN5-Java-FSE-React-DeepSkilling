import React, { Component } from "react";

class ComplaintRegister extends Component {

    constructor(props) {
        super(props);

        this.state = {
            employeeName: "",
            complaint: ""
        };
    }

    handleNameChange = (event) => {
        this.setState({
            employeeName: event.target.value
        });
    };

    handleComplaintChange = (event) => {
        this.setState({
            complaint: event.target.value
        });
    };

    handleSubmit = (event) => {

        event.preventDefault();

        const referenceNumber = Math.floor(100000 + Math.random() * 900000);

        alert(
            `Complaint Registered Successfully!\n\nEmployee Name: ${this.state.employeeName}\nReference Number: ${referenceNumber}`
        );

        this.setState({
            employeeName: "",
            complaint: ""
        });

    };

    render() {

        return (

            <div className="container">

                <h2>Ticket Raising Application</h2>

                <form onSubmit={this.handleSubmit}>

                    <label>Employee Name</label>

                    <br />

                    <input
                        type="text"
                        value={this.state.employeeName}
                        onChange={this.handleNameChange}
                        required
                    />

                    <br /><br />

                    <label>Complaint</label>

                    <br />

                    <textarea
                        rows="5"
                        cols="40"
                        value={this.state.complaint}
                        onChange={this.handleComplaintChange}
                        required
                    >
                    </textarea>

                    <br /><br />

                    <button type="submit">
                        Submit Complaint
                    </button>

                </form>

            </div>

        );

    }

}

export default ComplaintRegister;
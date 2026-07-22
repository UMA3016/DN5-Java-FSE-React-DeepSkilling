import React, { Component } from "react";
import EmployeesList from "./EmployeesList";
import ThemeContext from "./ThemeContext";
import "./App.css";

class App extends Component {

    constructor(props) {

        super(props);

        this.state = {

            theme: "light",

            employees: [

                {
                    id: 1,
                    name: "Rahul",
                    designation: "Software Engineer",
                    department: "Development"
                },

                {
                    id: 2,
                    name: "Anjali",
                    designation: "Tester",
                    department: "QA"
                },

                {
                    id: 3,
                    name: "Suresh",
                    designation: "Project Manager",
                    department: "Management"
                }

            ]

        };

    }

    toggleTheme = () => {

        this.setState({

            theme:
                this.state.theme === "light"
                    ? "dark"
                    : "light"

        });

    };

    render() {

        return (

            <ThemeContext.Provider value={this.state.theme}>

                <div className="App">

                    <h1>Employee Management System</h1>

                    <button onClick={this.toggleTheme}>
                        Change Theme
                    </button>

                    <EmployeesList
                        employees={this.state.employees}
                    />

                </div>

            </ThemeContext.Provider>

        );

    }

}

export default App;
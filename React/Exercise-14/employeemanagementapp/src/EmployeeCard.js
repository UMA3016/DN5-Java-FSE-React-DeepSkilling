import React, { useContext } from "react";
import ThemeContext from "./ThemeContext";

function EmployeeCard(props) {

    const theme = useContext(ThemeContext);

    return (
        <div
            style={{
                border: "1px solid gray",
                padding: "15px",
                margin: "10px",
                width: "300px"
            }}
        >

            <h3>{props.employee.name}</h3>

            <p>Designation : {props.employee.designation}</p>

            <p>Department : {props.employee.department}</p>

            <button className={theme}>
                View Details
            </button>

        </div>
    );
}

export default EmployeeCard;
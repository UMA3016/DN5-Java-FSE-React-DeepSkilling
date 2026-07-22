import React from "react";
import "./App.css";
import CohortDetails from "./Components/CohortDetails";

function App() {
    return (
        <div>
            <CohortDetails
                name="React Cohort"
                startDate="20-Jul-2026"
                status="ongoing"
                coach="John"
                trainer="David"
            />

            <CohortDetails
                name="Java Full Stack"
                startDate="15-Jun-2026"
                status="completed"
                coach="Alex"
                trainer="Robert"
            />

            <CohortDetails
                name="Angular Cohort"
                startDate="10-May-2026"
                status="ongoing"
                coach="Priya"
                trainer="Rahul"
            />
        </div>
    );
}

export default App;
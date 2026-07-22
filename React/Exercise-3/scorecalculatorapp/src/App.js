import React from "react";
import "./App.css";
import CalculateScore from "./Components/CalculateScore";

function App() {
    return (
        <div>
            <CalculateScore
                name="Uma Sri"
                school="SRKR Engineering College"
                total={480}
                goal={6}
            />
        </div>
    );
}

export default App;
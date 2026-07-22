import React from "react";
import Counter from "./Counter";
import CurrencyConvertor from "./CurrencyConvertor";

function App() {

    return (

        <div style={{ textAlign: "center", marginTop: "30px" }}>

            <h1>React Event Examples</h1>

            <Counter />

            <hr />

            <CurrencyConvertor />

        </div>

    );

}

export default App;
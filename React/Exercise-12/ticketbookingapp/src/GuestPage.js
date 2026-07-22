import React from "react";
import FlightDetails from "./FlightDetails";

function GuestPage() {
    return (
        <div>
            <h2>Welcome Guest</h2>
            <p>You can browse the available flights.</p>

            <FlightDetails />
        </div>
    );
}

export default GuestPage;
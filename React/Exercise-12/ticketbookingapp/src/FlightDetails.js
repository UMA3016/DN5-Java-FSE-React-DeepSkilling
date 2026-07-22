import React from "react";

function FlightDetails() {
    return (
        <div>
            <h2>Flight Details</h2>

            <table border="1" cellPadding="10">
                <thead>
                    <tr>
                        <th>Flight</th>
                        <th>From</th>
                        <th>To</th>
                        <th>Fare</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>AI101</td>
                        <td>Hyderabad</td>
                        <td>Delhi</td>
                        <td>₹6500</td>
                    </tr>

                    <tr>
                        <td>6E205</td>
                        <td>Chennai</td>
                        <td>Mumbai</td>
                        <td>₹5200</td>
                    </tr>

                    <tr>
                        <td>SG301</td>
                        <td>Bangalore</td>
                        <td>Kolkata</td>
                        <td>₹7100</td>
                    </tr>
                </tbody>
            </table>
        </div>
    );
}

export default FlightDetails;
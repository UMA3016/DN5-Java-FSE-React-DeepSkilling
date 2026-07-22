import React from "react";
import officeImage from "./office.jpg";

function App() {

  const office = {
    name: "Smart Work Office",
    rent: 55000,
    address: "Madhapur, Hyderabad"
  };

  const officeList = [
    {
      name: "Smart Work Office",
      rent: 55000,
      address: "Madhapur, Hyderabad"
    },
    {
      name: "Tech Hub",
      rent: 75000,
      address: "Gachibowli, Hyderabad"
    },
    {
      name: "Business Square",
      rent: 45000,
      address: "Banjara Hills, Hyderabad"
    },
    {
      name: "Corporate Tower",
      rent: 85000,
      address: "Hitech City, Hyderabad"
    }
  ];

  return (
    <div style={{ margin: "20px" }}>

      <h1>Office Space Rental App</h1>

      <img
        src={officeImage}
        alt="Office"
        width="500"
        height="300"
      />

      <h2>Single Office Details</h2>

      <p><b>Name:</b> {office.name}</p>

      <p
        style={{
          color: office.rent < 60000 ? "red" : "green"
        }}
      >
        <b>Rent:</b> ₹{office.rent}
      </p>

      <p><b>Address:</b> {office.address}</p>

      <hr />

      <h2>All Office Spaces</h2>

      {
        officeList.map((item, index) => (

          <div
            key={index}
            style={{
              border: "1px solid black",
              padding: "10px",
              marginBottom: "15px",
              width: "400px"
            }}
          >

            <h3>{item.name}</h3>

            <p
              style={{
                color: item.rent < 60000 ? "red" : "green"
              }}
            >
              <b>Rent:</b> ₹{item.rent}
            </p>

            <p>
              <b>Address:</b> {item.address}
            </p>

          </div>

        ))
      }

    </div>
  );
}

export default App;
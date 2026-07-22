import React from "react";

function BookDetails() {

    const books = [
        { id: 1, name: "React JS", price: 550 },
        { id: 2, name: "Java Programming", price: 700 },
        { id: 3, name: "Spring Boot", price: 650 }
    ];

    return (
        <div>
            <h2>Book Details</h2>

            <table border="1" cellPadding="8">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Book Name</th>
                        <th>Price</th>
                    </tr>
                </thead>

                <tbody>
                    {
                        books.map(book => (
                            <tr key={book.id}>
                                <td>{book.id}</td>
                                <td>{book.name}</td>
                                <td>₹{book.price}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
}

export default BookDetails;
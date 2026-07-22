import React from "react";

import BookDetails from "./Components/BookDetails";
import BlogDetails from "./Components/BlogDetails";
import CourseDetails from "./Components/CourseDetails";

function App() {

    const showBooks = true;
    const showBlogs = false;
    const showCourses = true;

    return (

        <div style={{ margin: "20px" }}>

            <h1>Blogger Application</h1>

            {/* If-Else using element variable */}

            {showBooks ? <BookDetails /> : <p>Books Not Available</p>}

            <hr />

            {/* Logical AND */}

            {showBlogs && <BlogDetails />}

            {!showBlogs && <p>Blogs Not Available</p>}

            <hr />

            {/* Ternary Operator */}

            {showCourses
                ? <CourseDetails />
                : <p>Courses Not Available</p>}

        </div>

    );

}

export default App;
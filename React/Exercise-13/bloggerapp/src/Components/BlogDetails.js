import React from "react";

function BlogDetails() {

    const blogs = [
        {
            id: 1,
            title: "Introduction to React",
            author: "Uma Sri"
        },
        {
            id: 2,
            title: "Understanding JSX",
            author: "John"
        },
        {
            id: 3,
            title: "React Components",
            author: "David"
        }
    ];

    return (
        <div>
            <h2>Blog Details</h2>

            <ul>
                {
                    blogs.map(blog => (
                        <li key={blog.id}>
                            <b>{blog.title}</b> - {blog.author}
                        </li>
                    ))
                }
            </ul>
        </div>
    );
}

export default BlogDetails;
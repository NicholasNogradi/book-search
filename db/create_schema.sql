-- We are using PostgreSQL 17.6
-- CSV Header is below
-- bookId,title,author,rating,description,language,isbn,bookFormat,edition,pages,publisher,publishDate,firstPublishDate,likedPercent,price

-- Create the books table
CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    rating DECIMAL(2, 1) CHECK (rating >= 0 AND rating <= 5),
    description TEXT NOT NULL,
    language VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) UNIQUE,
    book_format VARCHAR(255) NOT NULL,
    edition VARCHAR(255) NOT NULL,
    pages INTEGER CHECK (pages > 0),
    publisher VARCHAR(255),
    publish_date DATE,
    first_publish_date DATE,
    liked_percent DECIMAL(5, 2) CHECK (liked_percent >= 0 AND liked_percent <= 100),
    price DECIMAL(10, 2) CHECK (price >= 0)
);

-- Create the authors table
CREATE TABLE authors (
    author_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

-- Create the books_authors table
CREATE TABLE books_authors (
    book_id INTEGER NOT NULL,
    author_id INTEGER NOT NULL,
    PRIMARY KEY (book_id, author_id),
    FOREIGN KEY (book_id) REFERENCES books(book_id),
    FOREIGN KEY (author_id) REFERENCES authors(author_id)
);
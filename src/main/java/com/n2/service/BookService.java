package com.n2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n2.entity.Book;
import com.n2.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> searchBooks(String searchTerm, int limit, int offset) {
        if(searchTerm == null || searchTerm.trim().isEmpty()) {
            throw new IllegalArgumentException("Search term cannot be null or empty");
        }
        if(searchTerm.length() < 3) {
            throw new IllegalArgumentException("Search term must be at least 3 characters long");
        }
        if(searchTerm.length() > 100) {
            throw new IllegalArgumentException("Search term must not exceed 100 characters");
        }
        // Validate the search term to prevent SQL injection or other issues
        searchTerm = searchTerm.trim().toLowerCase();
        if (!searchTerm.matches("[a-zA-Z0-9\\s]+")) {
            throw new IllegalArgumentException("Search term contains invalid characters");
        }
        // Call the repository method to search for books
        return bookRepository.searchBooks(searchTerm, limit, offset);
    }
}

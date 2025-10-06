package com.n2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.n2.entity.Book;
import com.n2.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    List<Book> searchBooks(@RequestParam String searchTerm, @RequestParam int limit, @RequestParam int offset) {
        return bookService.searchBooks(searchTerm, limit, offset);
    }
    
}

package com.n2.service;

import java.util.List;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.n2.entity.Book;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    void testSearchBooksWhenTermIsEmpty() {
        String searchTerm = "";
        assertThrows(IllegalArgumentException.class, () -> {
            bookService.searchBooks(searchTerm, 0, 0);
        });
    }

    @Test
    void testSearchBooksWhenTermIsNull() {
        String searchTerm = null;
        assertThrows(IllegalArgumentException.class, () -> {
            bookService.searchBooks(searchTerm, 0, 0);
        });
    }

    @Test
    void testSearchBooksWhenTermIsValid() {
        String searchTerm = "algorithms";
        List<Book> books = bookService.searchBooks(searchTerm, 10, 0);
        assertTrue(!books.isEmpty());
    }
}

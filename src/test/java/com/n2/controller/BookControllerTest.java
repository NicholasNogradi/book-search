package com.n2.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.n2.entity.Book;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class BookControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testSearchBooks() {
        String searchTerm = "algorithms";
        ResponseEntity<Book[]> response = restTemplate.getForEntity(
                "/api/books/search?searchTerm={searchTerm}&limit={limit}&offset={offset}",
                Book[].class, searchTerm, 10, 0);

        Book[] books = response.getBody();
        assertNotNull(books);
        assertTrue(books.length > 0);

        // for (Book book : books) {
        //     System.out.println(book);
        // }
    }
}

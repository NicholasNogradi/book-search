package com.n2.repository;


import java.util.List;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.n2.entity.Book;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void testSearchBooks() {
        List<Book> books = bookRepository.searchBooks("algorithms", 10, 0);
        assertTrue(books.size() > 0);
        
        // for (Book book : books) {
        //     System.out.println(">>> Book title: " + book.getTitle());
        // }
    }
}

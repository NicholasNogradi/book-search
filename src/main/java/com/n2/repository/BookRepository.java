package com.n2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.n2.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM books WHERE search_vector @@ to_tsquery(:searchTerm) " +
                   "LIMIT :limit OFFSET :offset", 
           nativeQuery = true)    
    List<Book> searchBooks(@Param("searchTerm") String searchTerm, @Param("limit") int limit, @Param("offset") int offset);

    
}

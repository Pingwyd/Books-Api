package com.library.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface bookRepository extends JpaRepository<Book, Long > {
}

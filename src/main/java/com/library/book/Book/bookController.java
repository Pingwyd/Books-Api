package com.library.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class bookController {

    @Autowired
    bookRepository bookRepository;

    @GetMapping
    public List<Book> getallBooks(){
        return bookRepository.findAll();
    }

    @PostMapping
    private Book addBook(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    private String deleteBook(@PathVariable Long id ){
        bookRepository.deleteById(id);
        return "Book Deleted";
    }

        @PutMapping("/{id}")
        private String updateBook(@RequestBody Book updatedBook,@PathVariable Long id){
            Book existingBook = bookRepository.findById(id).orElseThrow();

            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());

            bookRepository.save(existingBook);
            return "Book updated Successfully";
        }

}

package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Dto.BookDTO;
import com.example.demo.Service.BookService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Retrieve all books
    @GetMapping("/get")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Retrieve a single book by its ISBN
    @GetMapping("/get/{isbn}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<BookDTO> getBookByIsbn(@PathVariable String isbn) {
        return bookService.getBookByIsbn(isbn);
    }

    // Add a new book
    @PostMapping("/create")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<BookDTO> createBook(@RequestBody @Valid BookDTO bookDTO) {
        return bookService.createBook(bookDTO);
    }

    // Update an existing book by its ISBN
    @PutMapping("/update/{isbn}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<BookDTO> updateBookAuthor(@PathVariable String isbn, @RequestBody @Valid BookDTO bookDTO) {
        return bookService.updateBook(isbn, bookDTO);
    }

    // Delete a book by its ISBN
    @DeleteMapping("/delete/{isbn}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Void> deleteBook(@PathVariable String isbn) {
        return bookService.deleteBook(isbn);
    }
}

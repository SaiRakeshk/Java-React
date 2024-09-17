package com.example.demo.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.BookRepository;
import com.example.demo.Dto.BookDTO;
import com.example.demo.Entities.Book;
import com.example.demo.Exception.BookNotFoundException;
import com.example.demo.Exception.DuplicateIsbnException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    // Retrieve all books
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        try {
            List<Book> books = bookRepository.findAll();
            if (books.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            List<BookDTO> bookDTOs = books.stream()
                                           .map(this::convertToDTO)
                                           .collect(Collectors.toList());
            return new ResponseEntity<>(bookDTOs, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Retrieve a single book by its ISBN
    public ResponseEntity<BookDTO> getBookByIsbn(String isbn) {
        Optional<Book> book = bookRepository.findByIsbn(isbn);
        if (book.isPresent()) {
            return new ResponseEntity<>(convertToDTO(book.get()), HttpStatus.OK);
        } else {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
        }
    }

    // Add a new book
    public ResponseEntity<BookDTO> createBook(BookDTO bookDTO) {
        Optional<Book> existingBook = bookRepository.findByIsbn(bookDTO.getIsbn());
        if (existingBook.isPresent()) {
            throw new DuplicateIsbnException("Book with ISBN " + bookDTO.getIsbn() + " already exists.");
        }
        Book newBook = convertToEntity(bookDTO);
        Book savedBook = bookRepository.save(newBook);
        return new ResponseEntity<>(convertToDTO(savedBook), HttpStatus.CREATED);
    }

    // Update an existing book by its ISBN
    public ResponseEntity<BookDTO> updateBook(String isbn, BookDTO bookDTO) {
        Optional<Book> existingBook = bookRepository.findByIsbn(isbn);
        if (existingBook.isPresent()) {
            Book bookToUpdate = existingBook.get();
            bookToUpdate.setTitle(bookDTO.getTitle());
            bookToUpdate.setAuthor(bookDTO.getAuthor());
            bookToUpdate.setPublicationYear(bookDTO.getPublicationYear());
            Book updatedBook = bookRepository.save(bookToUpdate);
            return new ResponseEntity<>(convertToDTO(updatedBook), HttpStatus.OK);
        } else {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
        }
    }

    // Delete a book by its ISBN
    public ResponseEntity<Void> deleteBook(String isbn) {
        Optional<Book> book = bookRepository.findByIsbn(isbn);
        if (book.isPresent()) {
            bookRepository.deleteByIsbn(isbn);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new BookNotFoundException("Book with ISBN " + isbn + " not found.");
        }
    }

    private BookDTO convertToDTO(Book book) {
        return new BookDTO(book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear());
    }

    private Book convertToEntity(BookDTO bookDTO) {
        return new Book(bookDTO.getTitle(), bookDTO.getAuthor(), bookDTO.getIsbn(), bookDTO.getPublicationYear());
    }
}

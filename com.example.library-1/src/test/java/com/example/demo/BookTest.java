package com.example.demo;


import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.Dao.BookRepository;
import com.example.demo.Dto.BookDTO;
import com.example.demo.Entities.Book;
import com.example.demo.Service.BookService;

import java.util.Optional;

import static org.mockito.Mockito.when;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class BookTest {

    @Mock
    private BookRepository bookRepo;

    @InjectMocks
    private BookService bookService;

    @Test
    void addBook_ShouldReturnSavedBook() {
    	
        BookDTO bookDTO = new BookDTO("Naruto", "Itachi", "BOOK567890", 1990);
        Book book = new Book("Naruto", "Itachi", "BOOK567890", 1990);
        when(bookRepo.save(any(Book.class))).thenReturn(book);

        ResponseEntity<BookDTO> result = bookService.createBook(bookDTO);

        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(result.getBody().getTitle()).isEqualTo("Naruto");
    }


    @Test
    void getAllBooks_ShouldReturnAllBooks() {
        Book book1 = new Book("Naruto", "Itachi", "BOOK567890", 1990);
        Book book2 = new Book("One piece", "luffy", "BOOK567891", 1980);
        List<Book> books = Arrays.asList(book1, book2);
        when(bookRepo.findAll()).thenReturn(books);

        ResponseEntity<List<BookDTO>> result = bookService.getAllBooks();

        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody().size()).isEqualTo(2);
        
    }


    @Test
    void removeBook_ShouldReturnRemovedBookIfExists() {
        Book book = new Book("One piece", "luffy", "BOOK567891", 1980);
        when(bookRepo.findByIsbn("BOOK567891")).thenReturn(Optional.of(book));
        doNothing().when(bookRepo).deleteByIsbn("BOOK567891");

        ResponseEntity<Void> result = bookService.deleteBook("BOOK567891");

        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }



    @Test
    void updateBookAuthor_ShouldReturnUpdatedBookIfExists() {
        Book existingBook = new Book("One piece", "luffy", "BOOK567891", 1980);
        BookDTO updatedBookDTO = new BookDTO("One piece", "zoro", "BOOK567891", 1980);
        when(bookRepo.findByIsbn("BOOK567891")).thenReturn(Optional.of(existingBook));
        when(bookRepo.save(any(Book.class))).thenAnswer(invocation -> invocation.getArgument(0));

       ResponseEntity<BookDTO> result = bookService.updateBook("BOOK567891", updatedBookDTO);

       assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getAuthor()).isEqualTo("zoro");
    }


    @Test
    void getBookByIsbn_ShouldReturnBookFoundIfExists() {
        Book book = new Book("One piece", "luffy", "BOOK567891", 1980);
        when(bookRepo.findByIsbn("BOOK567891")).thenReturn(Optional.of(book));

        ResponseEntity<BookDTO> result = bookService.getBookByIsbn("BOOK567891");

        assertThat(result).isNotNull();
        assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getTitle()).isEqualTo("One piece");
    }

}

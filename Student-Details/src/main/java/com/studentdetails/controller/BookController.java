package com.studentdetails.controller;

import com.studentdetails.model.Book;
import com.studentdetails.model.Course;
import com.studentdetails.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping(value = "all")
    public ResponseEntity<List<Book>> getAllBook() {
        return bookService.getAllBook();
    }

    @PostMapping(value = "/")
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id) {
        return bookService.deleteBookById(id);
    }
}

package com.studentdetails.service;

import com.studentdetails.model.Book;
import com.studentdetails.model.Course;
import com.studentdetails.repository.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    IBookRepo bookRepo;

    public ResponseEntity<List<Book>> getAllBook() {
        List<Book> all = bookRepo.findAll();
        if(all != null) {
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<String> addBook(Book book) {
        Book save = bookRepo.save(book);
        if(save != null) {
            return  new ResponseEntity<>("Book Saved", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> deleteBookById(String id) {
        if(bookRepo.existsById(Integer.parseInt(id))) {
            bookRepo.deleteById(Integer.parseInt(id));
            if(bookRepo.existsById(Integer.parseInt(id))) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Book Deleted", HttpStatus.OK);
        }
        else return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
    }
}

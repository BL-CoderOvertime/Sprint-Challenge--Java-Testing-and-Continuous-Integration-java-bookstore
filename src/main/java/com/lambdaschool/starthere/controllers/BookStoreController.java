package com.lambdaschool.starthere.controllers;

import com.lambdaschool.starthere.models.Author;
import com.lambdaschool.starthere.models.Book;
import com.lambdaschool.starthere.services.AuthorService;
import com.lambdaschool.starthere.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BookStoreController {

    private static final Logger logger = LoggerFactory.getLogger(RolesController.class);

    @Autowired
    AuthorService authorService;

    @Autowired
    BookService bookService;

    @GetMapping(value = "/authors", produces = {"application/json"})
    public ResponseEntity<?> listAllAuthors(HttpServletRequest request)
    {
        logger.trace(request.getRequestURI() + " accessed");

        List<Author> allAuthors = authorService.findAll();
        return new ResponseEntity<>(allAuthors, HttpStatus.OK);
    }


    @GetMapping(value = "/books", produces = {"application/json"})
    public ResponseEntity<?> listAllBooks(HttpServletRequest request)
    {
        logger.trace(request.getRequestURI() + " accessed");

        List<Book> allBooks = bookService.findAll();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    // - /data/books/{id}


    //DELETE /data/books/{id} - deletes a book and the book author combinations - but does not delete the author records.

    @DeleteMapping(value = "/data/books/{id}")
    public ResponseEntity<?> deleteBookById(HttpServletRequest request, @PathVariable long id)
    {
        logger.trace(request.getRequestURI() + " accessed");

        bookService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}

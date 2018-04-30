package com.secondson.perpus.controller;

import com.secondson.perpus.model.Book;
import com.secondson.perpus.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api")
public class MainControllerAPI {

    @Autowired
    private BookService bookService;

    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping(value = "/findAllBook")
    public Collection<Book> getAllBook(){
        return bookService.findAllBook();
    }

    @GetMapping(value = "deleteBook")
    public void deleteBook(@RequestParam long id){
        bookService.deleteBook(id);
    }

}

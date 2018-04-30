package com.secondson.perpus.controller;

import com.secondson.perpus.model.Book;
import com.secondson.perpus.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class MainController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String init(HttpServletRequest req){
        req.setAttribute("books", bookService.findAllBook());
        req.setAttribute("mode", "BOOK_VIEW");
        return "index";
    }
    
    @GetMapping("/updateBook")
    public String updateBook(@RequestParam long id, HttpServletRequest req){
        req.setAttribute("books", bookService.findOne(id));
        req.setAttribute("mode", "BOOK_EDIT");
        return "index";
    }
    
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//    	binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-dd-mm"), false));
//    }
    
    @PostMapping("/saveBook")
    public void saveBook(@ModelAttribute Book book, BindingResult bindingResult, HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	bookService.saveBook(book);
    	req.setAttribute("books", bookService.findAllBook());
        req.setAttribute("mode", "BOOK_VIEW");
    	resp.sendRedirect("/");
    }

    @GetMapping("/addBook")
    public String addBook(HttpServletRequest req){
        req.setAttribute("mode", "BOOK_NEW");
        return "index";
    }

    @GetMapping("deleteBook")
    public String deleteBook(@RequestParam long id, HttpServletRequest req){
        bookService.deleteBook(id);
        req.setAttribute("books", bookService.findAllBook());
        req.setAttribute("mode", "BOOK_VIEW");
        return "index";
    }
}

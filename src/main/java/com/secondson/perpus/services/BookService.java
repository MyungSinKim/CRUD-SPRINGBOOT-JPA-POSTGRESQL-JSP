package com.secondson.perpus.services;

import com.secondson.perpus.model.Book;
import com.secondson.perpus.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Collection<Book> findAllBook(){
        List<Book> books = new ArrayList<Book>();
        for (Book book : bookRepository.findAll()){
            books.add(book);
        }
        return books;
    }

    public void deleteBook(long id){
        bookRepository.delete(id);
    }
    
    public Book findOne(long id) {
    	return bookRepository.findOne(id);
    }
    
    public void saveBook(Book book) {
    	bookRepository.save(book);
    }
}

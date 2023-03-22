package com.work.controller;

import com.work.entity.Book;
import com.work.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/list")
    public List<Book> list(){
        return bookService.list();
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    @PostMapping("/delete")
    public boolean delete(Integer id){
        return bookService.removeById(id);
    }

}

package edu.yevynchuk.projtest.controller;

/*
    @author Nibe
    @project projTest
    @class BookRestController
    @version 1.0.0
    @SE 05.10.2024 - 21:16
*/

import edu.yevynchuk.projtest.model.Book;
import edu.yevynchuk.projtest.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BookRestController {
    private final BookService bookService;

    @RequestMapping("/hello")
    public String hello() {
        return "<h1> !!!!!!! hello !!!!!!! <h1>";
    }

    @RequestMapping("/")
    public List<Book> showAll() {
        return bookService.getBooks();
    }
}

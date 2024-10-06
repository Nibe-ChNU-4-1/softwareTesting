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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BookRestController {
    private final BookService bookService;

    // CRUD



    // read all
    @GetMapping
    public List<Book> showAll() {
        return bookService.getAll();
    }

    // read one
    @GetMapping("{id}")
    public Book showOneById(@PathVariable String id) {
        return bookService.getById(id);
    }

    // create
    @PostMapping
    public Book insert(@RequestBody Book book) {
        return bookService.create(book);
    }

    // update
    @PutMapping
    public Book edit(@RequestBody Book book) {
        return bookService.update(book);
    }

    // delete
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        bookService.delById(id);
    }
}

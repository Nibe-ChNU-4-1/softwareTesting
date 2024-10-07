package edu.yevynchuk.projtest.service;

/*
    @author Nibe
    @project projTest
    @class BookService
    @version 1.0.0
    @SE 05.10.2024 - 21:33
*/

import edu.yevynchuk.projtest.model.Book;
import edu.yevynchuk.projtest.repository.BookRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private static List<Book> books = new ArrayList<Book>();

    {
        books.add(new Book("1", "The Hobbit", "000001", "A fantasy novel by J.R.R. Tolkien"));
        books.add(new Book("2", "1984", "000002", "A dystopian novel by George Orwell"));
        books.add(new Book("3", "The Catcher in the Rye", "000003", "A novel by J.D. Salinger"));
    }

  //  @PostConstruct
    void init() {
        bookRepository.deleteAll();
        bookRepository.saveAll(books);
    }



    // CRUD
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    public Book create(Book book) {
        return bookRepository.save(book);
    }

    public Book update(Book book) {
        return bookRepository.save(book);
    }

    public void delById(String id) {
        bookRepository.deleteById(id);
    }

}

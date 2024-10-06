package edu.yevynchuk.projtest.repository;

/*
    @author Nibe
    @project projTest
    @class BookRepository
    @version 1.0.0
    @SE 05.10.2024 - 21:55
*/

import edu.yevynchuk.projtest.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {
}

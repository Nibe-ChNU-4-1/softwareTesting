package edu.yevynchuk.projtest.repository;

/*
    @author Nibe
    @project projTest
    @class ItemRepository
    @version 1.0.0
    @SE 05.10.2024 - 21:55
*/

import edu.yevynchuk.projtest.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}

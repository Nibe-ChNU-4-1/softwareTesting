package edu.yevynchuk.projtest.service;

/*
    @author Nibe
    @project projTest
    @class ItemService
    @version 1.0.0
    @SE 05.10.2024 - 21:33
*/

import edu.yevynchuk.projtest.model.Item;
import edu.yevynchuk.projtest.repository.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private static List<Item> items = new ArrayList<Item>();
    {
        items.add(new Item("1", "name1", "000001", "description1"));
        items.add(new Item("2", "name2", "000002", "description2"));
        items.add(new Item("3", "name3", "000003", "description3"));
    }

  //  @PostConstruct
    void init() {
        itemRepository.saveAll(items);
    }

    public List<Item> getItems() {
        return itemRepository.findAll();
    }



}

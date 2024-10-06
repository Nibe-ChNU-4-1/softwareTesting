package edu.yevynchuk.projtest.controller;

/*
    @author Nibe
    @project projTest
    @class ItemRestController
    @version 1.0.0
    @SE 05.10.2024 - 21:16
*/

import edu.yevynchuk.projtest.model.Item;
import edu.yevynchuk.projtest.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/items")
@RequiredArgsConstructor
public class ItemRestController {
    private final ItemService itemService;


    @RequestMapping("/hello")
    public String hello() {
        return "<h1> !!!!!!! hello !!!!!!! <h1>";
    }


    @RequestMapping("/")
    public List<Item> showAll() {
        return itemService.getItems();
    }





}

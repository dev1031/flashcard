package com.example.flashcard.controllers;

import com.example.flashcard.filters.Filters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController

public class FilterController {
    @Autowired
    Filters filters;

    @GetMapping("/prefilter")
    public List<Integer> getPreList(){
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);
        return filters.getEvenList(list);
    }

    @GetMapping("/postfilter")
    public List<Integer>getPostList(){
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> list = new ArrayList<>();
        for (int x : nums) list.add(x);
        return filters.getOddList(list);
    }

    @GetMapping("/preAuthorize")
    public String getPreString(){
        return filters.getPreMsg();
    }
}

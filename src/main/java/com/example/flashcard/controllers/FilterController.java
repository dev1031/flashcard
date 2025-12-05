package com.example.flashcard.controllers;

import com.example.flashcard.FlashcardApplication;
import com.example.flashcard.filters.Filters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController

public class FilterController {
    private static final Logger log = LoggerFactory.getLogger(FilterController.class);

    @Autowired
    Filters filters;

    @GetMapping("/prefilter")
    public List<Integer> getPreList(){
        log.info("prefilter is called🐮🐮🐮👾👾🐐🐪🐡🪲");//Just for logging test
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

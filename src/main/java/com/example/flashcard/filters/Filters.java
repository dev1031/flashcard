package com.example.flashcard.filters;

import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class Filters {
    @PreFilter("filterObject % 2 == 0")  // allow only even numbers
    public List<Integer> getEvenList(List<Integer> A){
        return A;
    }

    @PostFilter("filterObject % 2 != 0")  // allow only odd numbers
    public List<Integer> getOddList(List<Integer> A){
        return A;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")  // allow only for user role
    public String getPreMsg(){
        return "Hello this msg is from PreAuthorize";
    }
}

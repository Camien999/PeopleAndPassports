package com.example.peopleandpassports.controller;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class DateController {


    @PostMapping("/local-date")
    public void localDate(@RequestParam("localDate")
                          @DateTimeFormat(pattern = "yyyy-MMM-dd") LocalDate localDate) {
        // ...
    }
}

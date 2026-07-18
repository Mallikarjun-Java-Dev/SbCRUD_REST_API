package com.Demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/librarys")
public class LibraryController {

    // Simple in-memory list to demonstrate the endpoint
    private final List<String> libraries = new ArrayList<>();

    public LibraryController() {
        libraries.add("Central Library");
        libraries.add("City Library");
    }

    @GetMapping
    public List<String> getAll() {
        return libraries;
    }

    @PostMapping
    public String add(@RequestBody String name) {
        libraries.add(name);
        return "Added: " + name;
    }
}

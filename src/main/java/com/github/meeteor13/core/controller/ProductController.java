package com.github.meeteor13.core.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/products", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class ProductController {

    // can do this here
    @PreAuthorize("hasRole('PRODUCTS_READ')")
    @GetMapping
    @ResponseBody
    public Flux<List<String>> getProducts() {
        return Flux.just(Arrays.asList("iPhone", "iPad", "iWatch"));
    }
}

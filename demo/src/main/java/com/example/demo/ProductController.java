package com.example.demo;


import org.example.Sight;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)

public class ProductController {

    @GetMapping("/products/{id}")
    public ResponseEntity<org.example.Sight[]> getProduct(@PathVariable("id") String id) {

        org.example.KeelungSightsCrawler crawler = new org.example.KeelungSightsCrawler();
        Sight[] sights = crawler.getItems(id);

        if (sights.length > 0) {
            return ResponseEntity.ok().body(sights);
        } else {
            return ResponseEntity.notFound().build();
        }


    }

}

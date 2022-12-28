package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)

public class SightController {

    @GetMapping("/zone/{id}")
    public ResponseEntity<Sight[]> getProduct(@PathVariable("id") String id) {

        KeelungSightsCrawler crawler = new KeelungSightsCrawler();
        Sight[] sights = crawler.getItems(id);

        if (sights.length > 0) {
            return ResponseEntity.ok().body(sights);
        } else {
            return ResponseEntity.notFound().build(); //404
        }

    }

}

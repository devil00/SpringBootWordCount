package com.example.javainterview.controller;

import com.example.javainterview.model.WordCountResponse;
import com.example.javainterview.model.WordRequest;
import com.example.javainterview.service.WordCounterService;
import com.example.javainterview.validators.ValidWordRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
public class WordCounterController {
    private final WordCounterService wordCounterService;

    public WordCounterController(WordCounterService wordCounterService) {
        this.wordCounterService =  wordCounterService;
    }

    @GetMapping(value = "/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("working!");
    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> receiveWord(@RequestBody WordRequest wordRequest) {
        System.out.println("---------- empty: " + wordRequest.getWord().isEmpty());
        wordCounterService.addWord(wordRequest.getWord());
        return new ResponseEntity<>(wordRequest.getWord(), HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-count/{word}")
    public ResponseEntity<?> getWordCount(@PathVariable String word) {
        WordCountResponse response = new WordCountResponse(word, wordCounterService.getWordCount(word));
        return ResponseEntity.ok(response);
    }
}



package com.example.javainterview.service;

import com.example.javainterview.repository.InMemoryWordRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@Log4j2
public class WordCounterService {
    private final InMemoryWordRepository repository;
    private static final String SPACE = " ";

    public WordCounterService(InMemoryWordRepository repository) {
        this.repository = repository;
    }

    public void addWord(String word) {
        log.info("Adding word to repository {}", word);
        String[] wordArr = word.split(SPACE);
        Arrays.stream(wordArr).forEach(wd -> repository.addWord(wd));
    }

    public int getWordCount(String word) {
        log.info("Getting count of word to repository {}", word);
        return repository.getWordCount(word);
    }
}

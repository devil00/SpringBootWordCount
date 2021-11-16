package com.example.javainterview.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class InMemoryWordRepository implements WordRepository {
    private final Map<String, Integer> wordCounterCache;

    public InMemoryWordRepository() {
        this.wordCounterCache = new HashMap<>();
    }
    @Override
    public void addWord(String word) {
        wordCounterCache.put(word, wordCounterCache.getOrDefault(word, 0) + 1);
    }

    @Override
    public int getWordCount(String word) {
        return wordCounterCache.get(word);
    }
}

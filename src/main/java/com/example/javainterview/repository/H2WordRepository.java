package com.example.javainterview.repository;

import org.springframework.stereotype.Repository;

@Repository
public class H2WordRepository implements WordRepository {
    @Override
    public void addWord(String word) {

    }

    @Override
    public int getWordCount(String word) {
        return 0;
    }
}

package com.example.javainterview.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WordCountResponse {
    private String word;
    private Integer count;
}

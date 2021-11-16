package com.example.javainterview.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
public class WordRequest {
    @NotEmpty
    private String word;

    public WordRequest(@NotEmpty String word) {
        this.word = word;
    }
}

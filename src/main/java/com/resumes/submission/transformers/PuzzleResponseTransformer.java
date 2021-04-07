package com.resumes.submission.transformers;

import org.springframework.stereotype.Component;

@Component
public class PuzzleResponseTransformer implements StringTransformer {
    @Override
    public String transform(String input) {
        return " ABCD "+input.replaceAll("[A-Z]","\n$0");
    }
}